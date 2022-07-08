package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.network.protocol.Protocol;
import cn.nukkit.utils.BedrockResourceUtil;
import cn.nukkit.utils.BinaryStream;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

import static com.google.common.base.Verify.verify;

@Since("1.4.0.0-PN")
@UtilityClass
@Log4j2
public class RuntimeItems {

    private static final Gson GSON = new Gson();
    private static final Type ENTRY_TYPE = new TypeToken<ArrayList<Entry>>() {
    }.getType();

    private static final Int2ObjectMap<RuntimeItemMapping> itemPalette = new Int2ObjectOpenHashMap<>();

    public static void init() {
        log.debug("Loading runtime items...");

        for (Protocol protocol : Protocol.VALUES) {
            if (protocol.equals(Protocol.UNKNOWN)) {
                continue;
            }

            final String itemPaletteFile = "bedrock/resource/item_palette/item_palette." + BedrockResourceUtil.fileVersionByMinecraftVersion(protocol.minecraftVersion()) + ".json";

            try (InputStream inputStream = RuntimeItems.class.getClassLoader().getResourceAsStream(itemPaletteFile)) {
                if (inputStream != null) {
                    Collection<Entry> entries;
                    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                    entries = GSON.fromJson(reader, ENTRY_TYPE);

                    BinaryStream paletteBuffer = new BinaryStream();
                    paletteBuffer.putUnsignedVarInt(entries.size());

                    Int2IntMap legacyNetworkMap = new Int2IntOpenHashMap();
                    Int2IntMap networkLegacyMap = new Int2IntOpenHashMap();
                    Map<String, Integer> namespaceNetworkMap = new LinkedHashMap<>();
                    Int2ObjectMap<String> networkNamespaceMap = new Int2ObjectOpenHashMap<>();
                    for (Entry entry : entries) {
                        paletteBuffer.putString(entry.name.replace("minecraft:", ""));
                        paletteBuffer.putLShort(entry.id);
                        paletteBuffer.putBoolean(false); // Component item
                        namespaceNetworkMap.put(entry.name, entry.id);
                        networkNamespaceMap.put(entry.id, entry.name);
                        if (entry.oldId != null) {
                            boolean hasData = entry.oldData != null;
                            int fullId = getFullId(entry.oldId, hasData ? entry.oldData : 0);
                            if (entry.deprecated != Boolean.TRUE) {
                                verify(legacyNetworkMap.put(fullId, (entry.id << 1) | (hasData ? 1 : 0)) == 0,
                                        "Conflict while registering an item runtime id!"
                                );
                            }
                            verify(networkLegacyMap.put(entry.id, fullId | (hasData ? 1 : 0)) == 0,
                                    "Conflict while registering an item runtime id!"
                            );
                        }
                    }

                    byte[] itemDataPalette = paletteBuffer.getBuffer();
                    itemPalette.put(BedrockResourceUtil.protocolVersionByFileName(itemPaletteFile),
                            new RuntimeItemMapping(itemDataPalette, legacyNetworkMap, networkLegacyMap, namespaceNetworkMap, networkNamespaceMap));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static RuntimeItemMapping getRuntimeMapping() {
        return itemPalette.get(Protocol.oldest().version());
    }

    public static RuntimeItemMapping getRuntimeMapping(int protocol) {
        return protocol == -1 ? RuntimeItems.getRuntimeMapping() : itemPalette.get(protocol);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static int getId(int fullId) {
        return (short) (fullId >> 16);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static int getData(int fullId) {
        return ((fullId >> 1) & 0x7fff);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static int getFullId(int id, int data) {
        return (((short) id) << 16) | ((data & 0x7fff) << 1);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static int getNetworkId(int networkFullId) {
        return networkFullId >> 1;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static boolean hasData(int id) {
        return (id & 0x1) != 0;
    }

    @ToString
    @RequiredArgsConstructor
    static class Entry {
        String name;
        int id;
        Integer oldId;
        Integer oldData;
        @PowerNukkitOnly
        @Since("1.4.0.0-PN")
        Boolean deprecated;
    }
}

package cn.nukkit.utils;

import cn.nukkit.network.protocol.Protocol;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.Value;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMappingGenerator {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        final File itemPaletteDir = new File("src/main/resources/bedrock/resource/item_palette/");

        // TODO add renamed identifier mapping

        final Int2ObjectMap<Map<String, Integer>> itemsMap = new Int2ObjectOpenHashMap<>();

        final File[] files = itemPaletteDir.listFiles();

        Arrays.sort(Objects.requireNonNull(files), File::compareTo);

        for (File file : files) {
            final Protocol protocol = Protocol.byMinecraftVersion(file.getName()
                    .split("\\.")[1]
                    .split("\\.")[0]
                    .replaceAll("_", "."));

            if (!protocol.equals(Protocol.UNKNOWN)) {
                final Map<String, Integer> items = new HashMap<>();

                try (FileReader fileReader = new FileReader(file)) {
                    final JsonArray jsonItems = ItemMappingGenerator.GSON.fromJson(fileReader, JsonArray.class);

                    for (int i = 0; i < jsonItems.size(); i++) {
                        final JsonObject jsonObject = jsonItems.get(i).getAsJsonObject();

                        if (jsonObject.has("name") && jsonObject.has("id")) {
                            items.put(jsonObject.get("name").getAsString(), jsonObject.get("id").getAsInt());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                itemsMap.put(protocol.version(), items);

                System.out.println("Successfully loaded items of " + protocol.minecraftVersion() +
                        " (" + protocol.version() + ")");
            }
        }

        final int sourceProtocol = Protocol.oldest().version();
        final Map<String, Integer> sourceItems = itemsMap.get(sourceProtocol);
        final Int2ObjectMap<List<MappedEntry>> mapped = new Int2ObjectOpenHashMap<>();

        for (Map.Entry<String, Integer> entry : sourceItems.entrySet()) {
            for (Protocol protocol : Protocol.values()) {
                if (!itemsMap.containsKey(protocol.version()) || protocol.version() == sourceProtocol) {
                    continue;
                }

                for (Map.Entry<String, Integer> targetEntry : itemsMap.get(protocol.version()).entrySet()) {
                    // different network ids
                    if (targetEntry.getKey().equalsIgnoreCase(entry.getKey()) &&
                            targetEntry.getValue().intValue() != entry.getValue().intValue()) {
                        final List<MappedEntry> mappedEntries = mapped.getOrDefault(protocol.version(), new ArrayList<>());

                        mappedEntries.add(new MappedEntry(new ItemEntry(entry.getKey(), entry.getValue()),
                                new ItemEntry(targetEntry.getKey(), targetEntry.getValue())));

                        mapped.put(protocol.version(), mappedEntries);

                        break;
                    }
                }
            }
        }

        for (Map.Entry<Integer, List<MappedEntry>> entry : mapped.int2ObjectEntrySet()) {
            final String filePath = "src/main/resources/bedrock/mapping/item_palette/item_mapping_"
                    + sourceProtocol + "_to_" + entry.getKey() + ".json";

            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                fileOutputStream.write(ItemMappingGenerator.GSON.toJson(mapped.get(entry.getKey()))
                        .getBytes(StandardCharsets.UTF_8));

                System.out.println("Generated item mapping (" + sourceProtocol + " => " + entry.getKey() + ")");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Value
    public static class ItemEntry {
        String name;
        int id;
    }

    @Value
    public static class MappedEntry {
        ItemEntry source;
        ItemEntry target;
    }
}
package cn.nukkit.utils;

import cn.nukkit.network.protocol.Protocol;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BedrockMappingUtil {

    private static final Int2ObjectMap<Int2IntMap> blockPaletteMapping = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<Int2IntMap> reverseBlockPaletteMapping = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<Int2IntMap> itemPaletteMapping = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<Int2IntMap> reverseItemPaletteMapping = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<Map<String, String>> blockIdMapping = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<Map<String, Integer>> commandParameterMapping = new Int2ObjectOpenHashMap<>();

    private static final Gson gson = new Gson();

    public static void init() {
        final File mappingFile = new File("src/main/resources/bedrock/mapping/");
        final File blockPaletteFile = new File(mappingFile.getPath() + "/block_palette/");
        final File itemPaletteFile = new File(mappingFile.getPath() + "/item_palette/");
        final File blockIdentifierFile = new File(mappingFile.getPath() + "/block_identifier/");
        final File commandParameterFile = new File(mappingFile.getPath() + "/command_parameter/command_parameter_mapping.json");

        for (File blockPaletteMappingFile : Objects.requireNonNull(blockPaletteFile.listFiles())) {
            try (FileReader fileReader = new FileReader(blockPaletteMappingFile)) {
                final int protocol = BedrockMappingUtil.protocolVersionByFileName(blockPaletteMappingFile.getName());

                BedrockMappingUtil.blockPaletteMapping.put(protocol, BedrockMappingUtil.createMapping(fileReader));

                final Int2IntMap reverseMapping = new Int2IntOpenHashMap();

                for (Map.Entry<Integer, Integer> entry : BedrockMappingUtil.blockPaletteMapping.get(protocol).entrySet()) {
                    reverseMapping.put(entry.getValue(), entry.getKey());
                }

                BedrockMappingUtil.reverseBlockPaletteMapping.put(protocol, reverseMapping);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (File itemPaletteMappingFile : Objects.requireNonNull(itemPaletteFile.listFiles())) {
            try (FileReader fileReader = new FileReader(itemPaletteMappingFile)) {
                final int protocol = BedrockMappingUtil.protocolVersionByFileName(itemPaletteMappingFile.getName());

                BedrockMappingUtil.itemPaletteMapping.put(protocol, BedrockMappingUtil.createMapping(fileReader));

                final Int2IntMap reverseMapping = new Int2IntOpenHashMap();

                for (Map.Entry<Integer, Integer> entry : BedrockMappingUtil.itemPaletteMapping.get(protocol).entrySet()) {
                    reverseMapping.put(entry.getValue(), entry.getKey());
                }

                BedrockMappingUtil.reverseItemPaletteMapping.put(protocol, reverseMapping);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (File blockIdMappingFile : Objects.requireNonNull(blockIdentifierFile.listFiles())) {
            try (FileReader fileReader = new FileReader(blockIdMappingFile)) {
                final int protocol = BedrockMappingUtil.protocolVersionByFileName(blockIdMappingFile.getName());
                final Map<String, String> blockIdTranslations = new HashMap<>();
                final JsonObject jsonObject = BedrockMappingUtil.gson.fromJson(fileReader, JsonObject.class);

                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    blockIdTranslations.put(entry.getKey(), entry.getValue().getAsString());
                }

                BedrockMappingUtil.blockIdMapping.put(protocol, blockIdTranslations);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (FileReader fileReader = new FileReader(commandParameterFile)) {
            final JsonObject jsonObject = BedrockMappingUtil.gson.fromJson(fileReader, JsonObject.class);

            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                final int protocolVersion = Integer.parseInt(entry.getKey());
                final JsonElement element = entry.getValue();

                final Map<String, Integer> cmdParameterMap = new HashMap<>();

                if (element.isJsonObject()) {
                    JsonObject commandParameter = element.getAsJsonObject();

                    for (Map.Entry<String, JsonElement> cmdParameterEntry : commandParameter.entrySet()) {
                        cmdParameterMap.put(cmdParameterEntry.getKey(), cmdParameterEntry.getValue().getAsInt());
                    }
                }

                BedrockMappingUtil.commandParameterMapping.put(protocolVersion, cmdParameterMap);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int translateCommandParameter(int protocol, String commandParameterName) {
        return protocol == -1 || !BedrockMappingUtil.commandParameterMapping.containsKey(protocol) ? BedrockMappingUtil.commandParameterMapping.get(Protocol.oldest().version()).get(commandParameterName) : BedrockMappingUtil.commandParameterMapping.get(protocol).get(commandParameterName);
    }

    public static String translateBlockId(int protocol, String blockId) {
        return protocol == -1 || protocol == Protocol.oldest().version() || !BedrockMappingUtil.blockIdMapping.containsKey(protocol) || !BedrockMappingUtil.blockIdMapping.get(protocol).containsKey(blockId) ? blockId : BedrockMappingUtil.blockIdMapping.get(protocol).get(blockId);
    }

    public static int translateBlockRuntimeId(int protocol, int blockRuntimeId, boolean toClient) {
        return protocol == -1 || protocol == Protocol.oldest().version() ? blockRuntimeId : BedrockMappingUtil.translateRuntimeId(BedrockMappingUtil.blockPaletteMapping.get(protocol), BedrockMappingUtil.reverseBlockPaletteMapping.get(protocol), blockRuntimeId, toClient);
    }

    public static int translateItemRuntimeId(int protocol, int itemRuntimeId, boolean toClient) {
        return protocol == -1 || protocol == Protocol.oldest().version() ? itemRuntimeId : BedrockMappingUtil.translateRuntimeId(BedrockMappingUtil.itemPaletteMapping.get(protocol), BedrockMappingUtil.reverseItemPaletteMapping.get(protocol), itemRuntimeId, toClient);
    }

    private static int translateRuntimeId(Int2IntMap map, Int2IntMap reverseMap, int runtimeId, boolean toClient) {
        return toClient ? map.get(runtimeId) : reverseMap.get(runtimeId);
    }

    private static int protocolVersionByFileName(String fileName) {
        return Protocol.byVersion(Integer.parseInt(fileName.split("_to_")[1].split("\\.")[0])).version();
    }

    private static Int2IntMap createMapping(FileReader fileReader) {
        final JsonObject jsonObject = BedrockMappingUtil.gson.fromJson(fileReader, JsonObject.class);
        final Int2IntMap mapping = new Int2IntOpenHashMap();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            mapping.put(Integer.parseInt(entry.getKey()), entry.getValue().getAsInt());
        }

        return mapping;
    }
}
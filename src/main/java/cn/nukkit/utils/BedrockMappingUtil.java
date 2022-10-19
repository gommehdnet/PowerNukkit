package cn.nukkit.utils;

import cn.nukkit.network.protocol.Protocol;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
        for (Protocol protocol : Protocol.VALUES) {
            if (protocol.equals(Protocol.UNKNOWN) || protocol.equals(Protocol.oldest())) {
                continue;
            }

            final int oldestVersion = Protocol.oldest().version();
            final int protocolVersion = protocol.version();

            try (InputStream inputStream = BedrockMappingUtil.class.getClassLoader().getResourceAsStream("bedrock/mapping/block_palette/block_mapping_" + oldestVersion + "_to_" + protocolVersion + ".json")) {
                if (inputStream != null) {
                    BedrockMappingUtil.blockPaletteMapping.put(protocolVersion, BedrockMappingUtil.createMapping(new InputStreamReader(inputStream)));

                    final Int2IntMap reverseMapping = new Int2IntOpenHashMap();

                    for (Map.Entry<Integer, Integer> entry : BedrockMappingUtil.blockPaletteMapping.get(protocolVersion).entrySet()) {
                        reverseMapping.put(entry.getValue(), entry.getKey());
                    }

                    BedrockMappingUtil.reverseBlockPaletteMapping.put(protocolVersion, reverseMapping);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (InputStream inputStream = BedrockMappingUtil.class.getClassLoader().getResourceAsStream("bedrock/mapping/item_palette/item_mapping_" + oldestVersion + "_to_" + protocolVersion + ".json")) {
                if (inputStream != null) {
                    BedrockMappingUtil.itemPaletteMapping.put(protocolVersion, BedrockMappingUtil.createMapping(new InputStreamReader(inputStream)));

                    final Int2IntMap reverseMapping = new Int2IntOpenHashMap();

                    for (Map.Entry<Integer, Integer> entry : BedrockMappingUtil.itemPaletteMapping.get(protocolVersion).entrySet()) {
                        reverseMapping.put(entry.getValue(), entry.getKey());
                    }

                    BedrockMappingUtil.reverseItemPaletteMapping.put(protocolVersion, reverseMapping);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (InputStream inputStream = BedrockMappingUtil.class.getClassLoader().getResourceAsStream("bedrock/mapping/block_identifier/block_name_mapping" + oldestVersion + "_to_" + protocolVersion + ".json")) {
                if (inputStream != null) {
                    final Map<String, String> blockIdTranslations = new HashMap<>();
                    final JsonObject jsonObject = BedrockMappingUtil.gson.fromJson(new InputStreamReader(inputStream), JsonObject.class);

                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        blockIdTranslations.put(entry.getKey(), entry.getValue().getAsString());
                    }

                    BedrockMappingUtil.blockIdMapping.put(protocolVersion, blockIdTranslations);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (InputStream inputStream = BedrockMappingUtil.class.getClassLoader().getResourceAsStream("bedrock/mapping/command_parameter/command_parameter_mapping.json")) {
            if (inputStream != null) {
                final JsonObject jsonObject = BedrockMappingUtil.gson.fromJson(new InputStreamReader(inputStream), JsonObject.class);

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
        return map == null ? runtimeId : (toClient ? map.get(runtimeId) : reverseMap.get(runtimeId));
    }

    private static Int2IntMap createMapping(InputStreamReader reader) {
        final JsonObject jsonObject = BedrockMappingUtil.gson.fromJson(reader, JsonObject.class);
        final Int2IntMap mapping = new Int2IntOpenHashMap();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            mapping.put(Integer.parseInt(entry.getKey()), entry.getValue().getAsInt());
        }

        return mapping;
    }
}
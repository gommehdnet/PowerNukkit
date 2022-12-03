package cn.nukkit.utils;

import cn.nukkit.network.protocol.Protocol;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.*;

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
    private static final Int2ObjectMap<Map<String, Integer>> commandParameterMapping = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<Int2IntMap> containerSlotTypeMapping = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<Int2IntMap> entityFlagMapping = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<Int2IntMap> entityFlagReverseMapping = new Int2ObjectOpenHashMap<>();

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
                e.printStackTrace();
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
                e.printStackTrace();
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
            e.printStackTrace();
        }

        try (InputStream inputStream = BedrockMappingUtil.class.getClassLoader().getResourceAsStream("bedrock/mapping/special/container_slot_type_mapping.json")) {
            if (inputStream != null) {
                final JsonObject jsonObject = BedrockMappingUtil.gson.fromJson(new InputStreamReader(inputStream), JsonObject.class);

                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    final int protocolVersion = Integer.parseInt(entry.getKey());
                    final JsonElement element = entry.getValue();

                    final Int2IntMap slotTypeMap = new Int2IntArrayMap();

                    if (element.isJsonObject()) {
                        final JsonObject slotType = element.getAsJsonObject();

                        for (Map.Entry<String, JsonElement> slotTypeEntry : slotType.entrySet()) {
                            slotTypeMap.put(slotTypeEntry.getValue().getAsInt(), Integer.parseInt(slotTypeEntry.getKey()));
                        }
                    }

                    BedrockMappingUtil.containerSlotTypeMapping.put(protocolVersion, slotTypeMap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = BedrockMappingUtil.class.getClassLoader().getResourceAsStream("bedrock/mapping/special/entity_flag_mapping.json")) {
            if (inputStream != null) {
                final JsonObject jsonObject = BedrockMappingUtil.gson.fromJson(new InputStreamReader(inputStream), JsonObject.class);

                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    final int protocolVersion = Integer.parseInt(entry.getKey());
                    final JsonElement element = entry.getValue();

                    final Int2IntMap entityFlagMap = new Int2IntArrayMap();
                    final Int2IntMap entityFlagReverseMap = new Int2IntArrayMap();

                    if (element.isJsonObject()) {
                        final JsonObject slotType = element.getAsJsonObject();

                        for (Map.Entry<String, JsonElement> slotTypeEntry : slotType.entrySet()) {
                            entityFlagMap.put(Integer.parseInt(slotTypeEntry.getKey()), slotTypeEntry.getValue().getAsInt());
                            entityFlagReverseMap.put(slotTypeEntry.getValue().getAsInt(), Integer.parseInt(slotTypeEntry.getKey()));
                        }
                    }

                    BedrockMappingUtil.entityFlagMapping.put(protocolVersion, entityFlagMap);
                    BedrockMappingUtil.entityFlagReverseMapping.put(protocolVersion, entityFlagReverseMap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int translateContainerSlotType(int protocol, int containerSlotType) {
        if (protocol == -1 || !BedrockMappingUtil.containerSlotTypeMapping.containsKey(protocol)) {
            return containerSlotType;
        }

        if (!BedrockMappingUtil.containerSlotTypeMapping.get(protocol).containsKey(containerSlotType)) {
            return containerSlotType;
        }

        return BedrockMappingUtil.containerSlotTypeMapping.get(protocol).get(containerSlotType);
    }

    public static int translateEntityFlag(int protocol, int entityFlag, boolean toClient) {
        if (protocol == -1 || !BedrockMappingUtil.entityFlagMapping.containsKey(protocol)) {
            return entityFlag;
        }

        if (!BedrockMappingUtil.entityFlagMapping.get(protocol).containsKey(entityFlag)) {
            return entityFlag;
        }

        return toClient ? BedrockMappingUtil.entityFlagMapping.get(protocol).get(entityFlag) : BedrockMappingUtil.entityFlagReverseMapping.get(protocol).get(entityFlag);
    }

    public static int translateCommandParameter(int protocol, String commandParameterName) {
        return protocol == -1 || !BedrockMappingUtil.commandParameterMapping.containsKey(protocol) ? BedrockMappingUtil.commandParameterMapping.get(Protocol.oldest().version()).get(commandParameterName) : BedrockMappingUtil.commandParameterMapping.get(protocol).get(commandParameterName);
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
package cn.nukkit.utils;

import cn.nukkit.network.protocol.Protocol;
import com.google.common.io.ByteStreams;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BedrockResourceUtil {

    private static final Int2ObjectMap<byte[]> biomeDefinitions = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<byte[]> entityIdentifiers = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<InputStream> creativeItems = new Int2ObjectOpenHashMap<>();

    public static void init() {
        for (Protocol protocol : Protocol.VALUES) {
            if (protocol.equals(Protocol.UNKNOWN)) {
                continue;
            }

            final String fileVersion = BedrockResourceUtil.fileVersionByMinecraftVersion(protocol.minecraftVersion());
            final String biomeDefinitionsFile = "bedrock/resource/biome_definitions/biome_definitions." + fileVersion + ".dat";
            final String creativeItemsFile = "bedrock/resource/creative_items/creative_items." + fileVersion + ".json";
            final String entityIdentifiersFile = "bedrock/resource/entity_identifiers/entity_identifiers." + fileVersion + ".dat";

            try (InputStream inputStream = BedrockResourceUtil.class.getClassLoader().getResourceAsStream(biomeDefinitionsFile)) {
                if (inputStream != null) {
                    BedrockResourceUtil.biomeDefinitions.put(BedrockResourceUtil.protocolVersionByFileName(biomeDefinitionsFile), ByteStreams.toByteArray(inputStream));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            InputStream creativeInput = BedrockResourceUtil.class.getClassLoader().getResourceAsStream(creativeItemsFile);

            if (creativeInput != null) {
                BedrockResourceUtil.creativeItems.put(BedrockResourceUtil.protocolVersionByFileName(creativeItemsFile), creativeInput);
            }

            try (InputStream inputStream = BedrockResourceUtil.class.getClassLoader().getResourceAsStream(entityIdentifiersFile)) {
                if (inputStream != null) {
                    BedrockResourceUtil.entityIdentifiers.put(BedrockResourceUtil.protocolVersionByFileName(entityIdentifiersFile), ByteStreams.toByteArray(inputStream));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static byte[] biomeDefinitionTag(int protocol) {
        return BedrockResourceUtil.biomeDefinitions.get(protocol);
    }

    public static byte[] entityIdentifiersTag(int protocol) {
        return BedrockResourceUtil.entityIdentifiers.get(protocol);
    }

    public static InputStream creativeItemsInput(int protocol) {
        return BedrockResourceUtil.creativeItems.get(protocol);
    }

    public static int protocolVersionByFileName(String fileName) {
        return Protocol.byMinecraftVersion(fileName.split("\\.")[1].replaceAll("_", ".")).version();
    }

    public static String fileVersionByMinecraftVersion(String minecraftVersion) {
        return minecraftVersion.replaceAll("\\.", "_");
    }
}
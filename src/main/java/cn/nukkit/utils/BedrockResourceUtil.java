package cn.nukkit.utils;

import cn.nukkit.network.protocol.Protocol;
import com.google.common.io.ByteStreams;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BedrockResourceUtil {

    private static final Int2ObjectMap<byte[]> biomeDefinitions = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<byte[]> entityIdentifiers = new Int2ObjectOpenHashMap<>();
    private static final Int2ObjectMap<InputStream> creativeItems = new Int2ObjectOpenHashMap<>();

    public static void init() {
        final File resourceDir = new File("src/main/resources/bedrock/resource/");
        final File biomeDefinitionsDir = new File(resourceDir.getPath() + "/biome_definitions/");
        final File entityIdentifiersDir = new File(resourceDir.getPath() + "/entity_identifiers/");
        final File creativeItemsDir = new File(resourceDir.getPath() + "/creative_items/");

        for (File biomeDefinitionsFile : Objects.requireNonNull(biomeDefinitionsDir.listFiles())) {
            BedrockResourceUtil.biomeDefinitions.put(BedrockResourceUtil.protocolVersionByFileName(biomeDefinitionsFile.getName()), BedrockResourceUtil.readDatFile(biomeDefinitionsFile.getPath()));
        }

        for (File entityIdentifiersFile : Objects.requireNonNull(entityIdentifiersDir.listFiles())) {
            BedrockResourceUtil.entityIdentifiers.put(BedrockResourceUtil.protocolVersionByFileName(entityIdentifiersFile.getName()), BedrockResourceUtil.readDatFile(entityIdentifiersFile.getPath()));
        }

        for (File creativeItemsFile : Objects.requireNonNull(creativeItemsDir.listFiles())) {
            BedrockResourceUtil.creativeItems.put(BedrockResourceUtil.protocolVersionByFileName(creativeItemsFile.getName()), BedrockResourceUtil.readJsonFile(creativeItemsFile.getPath()));
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

    private static byte[] readDatFile(String filePath) {
        try (InputStream inputStream = BedrockResourceUtil.class.getClassLoader().getResourceAsStream(filePath.split("resources")[1])) {
            if (inputStream != null) {
                return ByteStreams.toByteArray(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new byte[0];
    }

    private static InputStream readJsonFile(String filePath) {
        return BedrockResourceUtil.class.getClassLoader().getResourceAsStream(filePath.split("resources")[1]);
    }
}
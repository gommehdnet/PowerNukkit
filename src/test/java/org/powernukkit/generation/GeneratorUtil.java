package org.powernukkit.generation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nukkitx.nbt.NBTInputStream;
import com.nukkitx.nbt.NbtMap;
import com.nukkitx.nbt.NbtType;
import com.nukkitx.nbt.NbtUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

/**
 * @author Kaooot
 * @version 1.0
 */
public class GeneratorUtil {

    static void readItemPalette(File file, Map<String, Integer> identifiers) {
        try (final FileReader fileReader = new FileReader(file)) {
            final JsonElement element = JsonParser.parseReader(fileReader);

            if (element.isJsonArray()) {
                for (JsonElement entry : element.getAsJsonArray()) {
                    if (entry.isJsonObject()) {
                        final JsonObject item = entry.getAsJsonObject();

                        identifiers.put(item.get("name").getAsString(), item.get("id").getAsInt());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readBlockPalette(File file, List<String> identifiers) {
        try (final NBTInputStream nbtInputStream = NbtUtils.createGZIPReader(
                Files.newInputStream(file.toPath()))) {
            final NbtMap nbtMap = (NbtMap) nbtInputStream.readTag();

            for (NbtMap block : nbtMap.getList("blocks", NbtType.COMPOUND)) {
                final String name = block.getString("name");

                if (!identifiers.contains(name)) {
                    identifiers.add(name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String identifierToName(String identifier) {
        identifier = identifier.split(":")[1];

        if (identifier.contains("_")) {
            final String[] s = identifier.split("_");
            final StringBuilder stringBuilder = new StringBuilder();

            for (String part : s) {
                stringBuilder.append(String.valueOf(part.charAt(0)).toUpperCase() + part.substring(1)).append(s[s.length - 1].equals(part) ? "" : " ");
            }

            return stringBuilder.toString();
        } else {
            return String.valueOf(identifier.charAt(0)).toUpperCase() + identifier.substring(1);
        }
    }

    static String identifierToEnumName(String identifier) {
        return identifier.split(":")[1].toUpperCase();
    }
}
package org.powernukkit.generation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemIdGenerator {

    public static void main(String[] args) {
        final File file = new File("src/test/resources/org/powernukkit/palettes/item_palette.json");

        if (!file.exists()) {
            System.out.println("Could not find item_palette.json!");

            return;
        }

        final Map<String, Integer> identifiers = new HashMap<>();

        GeneratorUtil.readItemPalette(file, identifiers);

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package cn.nukkit.item;\n" +
                "\n" +
                "import lombok.Getter;\n" +
                "import lombok.RequiredArgsConstructor;\n" +
                "\n" +
                "/**\n" +
                " * @author Kaooot\n" +
                " * @version 1.0\n" +
                " */\n" +
                "@Getter\n" +
                "@RequiredArgsConstructor\n" +
                "public enum ItemID {" +
                "\n\n");

        final List<String> keys = new ArrayList<>(identifiers.keySet());

        Collections.sort(keys);

        for (String identifier : keys) {
            if (!identifier.startsWith("minecraft:item")) {
                stringBuilder.append("    ").append(identifier.split(":")[1].toUpperCase())
                        .append("(\"")
                        .append(identifier).append("\", ").append(identifiers.get(identifier)).append(", ").append("Item")
                        .append(GeneratorUtil.identifierToName(identifier).replaceAll(" ", ""))
                        .append(".class").append(")")
                        .append(keys.indexOf(identifier) == (identifiers.size() - 1) ? ";" : ",")
                        .append("\n");
            }
        }

        stringBuilder.append("\n").append("    private final String identifier;\n")
                .append("    private final int networkId;\n")
                .append("    private final Class<? extends Item> clazz;\n\n")
                .append("    public static ItemID byIdentifier(String identifier) {\n" +
                        "        for (ItemID itemID : ItemID.values()) {\n" +
                        "            if (itemID.identifier.equalsIgnoreCase(identifier)) {\n" +
                        "                return itemID;\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        return ItemID.AIR;\n" +
                        "    }\n\n")
                .append("    public static ItemID byNetworkId(int networkId) {\n" +
                        "        for (ItemID itemID : ItemID.values()) {\n" +
                        "            if (itemID.networkId == networkId) {\n" +
                        "                return itemID;\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        return ItemID.AIR;\n" +
                        "    }\n\n")
                .append("    @Override\n" +
                        "    public String toString() {\n" +
                        "        return this.identifier;\n" +
                        "    }").append("\n}");

        try (final FileWriter fileWriter = new FileWriter(
                "src/test/resources/org/powernukkit/output/ItemID.java")) {
            fileWriter.write(stringBuilder.toString());

            System.out.println("generated ItemID class");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
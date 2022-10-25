package org.powernukkit.generation;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemClassGenerator {

    public static void main(String[] args) {
        final File file = new File("src/test/resources/org/powernukkit/palettes/item_palette.json");
        final File blockPaletteFile = new File("src/test/resources/org/powernukkit/palettes/block_palette.nbt");

        if (!file.exists()) {
            System.out.println("Unable to locate item palette!");

            return;
        }

        if (!blockPaletteFile.exists()) {
            System.out.println("Unable to locate block palette!");

            return;
        }

        final Map<String, Integer> identifiers = new LinkedHashMap<>();

        final List<String> blockIdentifiers = new ObjectArrayList<>();

        GeneratorUtil.readItemPalette(file, identifiers);
        GeneratorUtil.readBlockPalette(blockPaletteFile, blockIdentifiers);

        for (String identifier : identifiers.keySet()) {
            if (identifier.startsWith("minecraft:item")) {
                continue;
            }

            final StringBuilder stringBuilder = new StringBuilder();

            final String className = GeneratorUtil.identifierToName(identifier).replace(" ", "");

            if (!blockIdentifiers.contains(identifier)) {
                stringBuilder.append("package cn.nukkit.item;\n" +
                        "\n" +
                        "/**\n" +
                        " * @author Kaooot\n" +
                        " * @version 1.0\n" +
                        " */\n" +
                        "public class Item" + className + " extends Item {\n" +
                        "\n" +
                        "    public Item" + className + "() {\n" +
                        "        this(0, 1);\n" +
                        "    }\n" +
                        "\n" +
                        "    public Item" + className + "(Integer meta) {\n" +
                        "        this(meta, 1);\n" +
                        "    }\n" +
                        "\n" +
                        "    public Item" + className + "(Integer meta, int count) {\n" +
                        "        super(ItemID." + GeneratorUtil.identifierToEnumName(identifier) + ", meta, count, \"" + GeneratorUtil.identifierToName(identifier) + "\");\n" +
                        "    }\n" +
                        "}");
            } else {
                stringBuilder.append("package cn.nukkit.item;\n" +
                        "\n" +
                        "import cn.nukkit.block.Block;\n" +
                        "import cn.nukkit.block.BlockID;\n" +
                        "\n" +
                        "/**\n" +
                        " * @author Kaooot\n" +
                        " * @version 1.0\n" +
                        " */\n" +
                        "public class Item" + className + " extends Item {\n" +
                        "\n" +
                        "    public Item" + className + "() {\n" +
                        "        this(0, 1);\n" +
                        "    }\n" +
                        "\n" +
                        "    public Item" + className + "(Integer meta) {\n" +
                        "        this(meta, 1);\n" +
                        "    }\n" +
                        "\n" +
                        "    public Item" + className + "(Integer meta, int count) {\n" +
                        "        super(ItemID." + GeneratorUtil.identifierToEnumName(identifier) + ", meta, count, \"" + GeneratorUtil.identifierToName(identifier) + "\");\n" +
                        "        this.block = Block.get(BlockID." + GeneratorUtil.identifierToEnumName(identifier) + ", meta);\n" +
                        "    }\n" +
                        "}");
            }

            final File classFile = new File("src/test/resources/org/powernukkit/item/Item" + className + ".java");

            if (classFile.exists()) {
                continue;
            }

            try (final FileWriter fileWriter = new FileWriter(classFile)) {
                fileWriter.write(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
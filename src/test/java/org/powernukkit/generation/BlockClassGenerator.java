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
public class BlockClassGenerator {

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

        final Map<String, Integer> itemIdentifiers = new LinkedHashMap<>();

        final List<String> identifiers = new ObjectArrayList<>();

        GeneratorUtil.readBlockPalette(blockPaletteFile, identifiers);
        GeneratorUtil.readItemPalette(file, itemIdentifiers);

        for (String identifier : identifiers) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String name = GeneratorUtil.identifierToName(identifier);
            final String className = name.replace(" ", "");
            final String enumName = GeneratorUtil.identifierToEnumName(identifier);

            stringBuilder.append("package cn.nukkit.block;\n" +
                    "\n" +
                    "import cn.nukkit.item.Item;\n" +
                    "import cn.nukkit.item.ItemID;\n" +
                    "\n" +
                    "/**\n" +
                    " * @author Kaooot\n" +
                    " * @version 1.0\n" +
                    " */\n" +
                    "public class Block" + className + " extends Block {\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public BlockID getId() {\n" +
                    "        return BlockID." + enumName + ";\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public String getName() {\n" +
                    "        return \"" + name + "\";\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public Item toItem() {\n" +
                    "        return Item.get(ItemID." + enumName + ");\n" +
                    "    }\n" +
                    "}");

            final File classFile = new File("src/test/resources/org/powernukkit/block/Block" + className + ".java");

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
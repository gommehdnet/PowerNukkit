package org.powernukkit.generation;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockIdGenerator {

    public static void main(String[] args) {
        final File file = new File("src/test/resources/org/powernukkit/palettes/block_palette.nbt");

        if (!file.exists()) {
            System.out.println("Could not find block_palette.nbt!");
        }

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("package cn.nukkit.block;\n" +
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
                "public enum BlockID {\n\n");

        final List<String> identifiers = new ObjectArrayList<>();

        GeneratorUtil.readBlockPalette(file, identifiers);

        Collections.sort(identifiers);

        for (final String identifier : identifiers) {
            stringBuilder.append("    ").append(identifier.split(":")[1].toUpperCase())
                    .append("(\"").append(identifier).append("\", Block")
                    .append(GeneratorUtil.identifierToName(identifier).replaceAll(" ", ""))
                    .append(".class)").append(identifiers.indexOf(identifier) != (identifiers.size() - 1) ? "," : ";")
                    .append("\n");
        }

        stringBuilder.append("\n    private final String identifier;\n");
        stringBuilder.append("\n    private final Class<? extends Block> clazz;\n\n")
                .append("    public static BlockID byIdentifier(String identifier) {\n" +
                        "        for (BlockID blockID : BlockID.values()) {\n" +
                        "            if (blockID.getIdentifier().equalsIgnoreCase(identifier)) {\n" +
                        "                return blockID;\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        return BlockID.AIR;\n" +
                        "    }\n\n")
                .append("    @Override\n" +
                        "    public String toString() {\n" +
                        "        return this.identifier;\n" +
                        "    }").append("\n}");

        try (final FileWriter fileWriter = new FileWriter(
                "src/test/resources/org/powernukkit/output/BlockID.java")) {
            fileWriter.write(stringBuilder.toString());

            System.out.println("generated BlockID class");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
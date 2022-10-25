package cn.nukkit.level.biome.impl.forest;

import cn.nukkit.level.generator.populator.impl.PopulatorFlower;

/**
 * @author DaPorkchop_ (Nukkit Project)
 */
public class FlowerForestBiome extends ForestBiome {
    public FlowerForestBiome() {
        this(TYPE_NORMAL);
    }

    public FlowerForestBiome(int type) {
        super(type);

        //see https://minecraft.gamepedia.com/Flower#Flower_biomes
        PopulatorFlower flower = new PopulatorFlower();
        flower.setBaseAmount(10);
        /*flower.addType(BlockID.YELLOW_FLOWER, 0);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_POPPY);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_ALLIUM);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_AZURE_BLUET);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_RED_TULIP);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_ORANGE_TULIP);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_WHITE_TULIP);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_PINK_TULIP);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_OXEYE_DAISY);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_CORNFLOWER);
        flower.addType(BlockID.RED_FLOWER, BlockFlower.TYPE_LILY_OF_THE_VALLEY);
        flower.addType(BlockID.DOUBLE_PLANT, BlockDoublePlant.LILAC);
        flower.addType(BlockID.DOUBLE_PLANT, BlockDoublePlant.ROSE_BUSH);
        flower.addType(BlockID.DOUBLE_PLANT, BlockDoublePlant.PEONY); TODO: Kaooot */
        this.addPopulator(flower);

        this.setHeightVariation(0.4f);
    }

    @Override
    public String getName() {
        return this.type == TYPE_BIRCH ? "Birch Forest" : "Forest";
    }
}

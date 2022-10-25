package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntityMusic;
import cn.nukkit.event.player.PlayerInteractEvent.Action;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.level.Level;
import cn.nukkit.level.Sound;
import cn.nukkit.math.BlockFace;
import cn.nukkit.network.protocol.BlockEventPacket;
import cn.nukkit.network.protocol.LevelSoundEventPacket;
import cn.nukkit.utils.BlockColor;
import cn.nukkit.utils.RedstoneComponent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Snake1999
 * @since 2016/1/17
 */
@PowerNukkitDifference(info = "Implements RedstoneComponent.", since = "1.4.0.0-PN")
@PowerNukkitDifference(since = "1.4.0.0-PN", info = "Implements BlockEntityHolder only in PowerNukkit")
public class BlockNoteblock extends BlockSolid implements RedstoneComponent, BlockEntityHolder<BlockEntityMusic> {

    public BlockNoteblock() {
        // Does nothing
    }

    @Override
    public String getName() {
        return "Note Block";
    }

    @Override
    public BlockID getId() {
        return BlockID.NOTEBLOCK;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public Class<? extends BlockEntityMusic> getBlockEntityClass() {
        return BlockEntityMusic.class;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    @Override
    public String getBlockEntityType() {
        return BlockEntity.MUSIC;
    }

    @Override
    public double getHardness() {
        return 0.8D;
    }

    @Override
    public double getResistance() {
        return 4D;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        return BlockEntityHolder.setBlockAndCreateEntity(this) != null;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int onTouch(@Nullable Player player, Action action) {
        if (action == Action.LEFT_CLICK_BLOCK && (player == null || (!player.isCreative() && !player.isSpectator()))) {
            emitSound();
        }
        return super.onTouch(player, action);
    }

    public int getStrength() {
        BlockEntityMusic blockEntity = this.getBlockEntity();
        return blockEntity != null ? blockEntity.getPitch() : 0;
    }

    public void increaseStrength() {
        getOrCreateBlockEntity().changePitch();
    }

    public Instrument getInstrument() {
        final BlockID blockID = this.down().getId();

        if (blockID.equals(BlockID.GOLD_BLOCK)) {
            return Instrument.GLOCKENSPIEL;
        } else if (blockID.equals(BlockID.CLAY) || blockID.equals(BlockID.HONEYCOMB_BLOCK)) {
            return Instrument.FLUTE;
        } else if (blockID.equals(BlockID.PACKED_ICE)) {
            return Instrument.CHIME;
        } else if (blockID.equals(BlockID.WOOL)) {
            return Instrument.GUITAR;
        } else if (blockID.equals(BlockID.BONE_BLOCK)) {
            return Instrument.XYLOPHONE;
        } else if (blockID.equals(BlockID.IRON_BLOCK)) {
            return Instrument.VIBRAPHONE;
        } else if (blockID.equals(BlockID.SOUL_SAND)) {
            return Instrument.COW_BELL;
        } else if (blockID.equals(BlockID.PUMPKIN)) {
            return Instrument.DIDGERIDOO;
        } else if (blockID.equals(BlockID.EMERALD_BLOCK)) {
            return Instrument.SQUARE_WAVE;
        } else if (blockID.equals(BlockID.HAY_BLOCK)) {
            return Instrument.BANJO;
        } else if (blockID.equals(BlockID.GLOWSTONE)) {
            return Instrument.ELECTRIC_PIANO;
        } else if (blockID.equals(BlockID.LOG) || blockID.equals(BlockID.LOG2) ||
                blockID.equals(BlockID.PLANKS) || blockID.equals(BlockID.DOUBLE_WOODEN_SLAB) ||
                blockID.equals(BlockID.WOODEN_SLAB) || blockID.equals(BlockID.OAK_STAIRS) ||
                blockID.equals(BlockID.SPRUCE_STAIRS) || blockID.equals(BlockID.BIRCH_STAIRS) ||
                blockID.equals(BlockID.JUNGLE_STAIRS) || blockID.equals(BlockID.ACACIA_STAIRS) ||
                blockID.equals(BlockID.DARK_OAK_STAIRS) || blockID.equals(BlockID.CRIMSON_STAIRS) ||
                blockID.equals(BlockID.WARPED_STAIRS) || blockID.equals(BlockID.FENCE) ||
                blockID.equals(BlockID.FENCE_GATE) || blockID.equals(BlockID.SPRUCE_FENCE_GATE) ||
                blockID.equals(BlockID.BIRCH_FENCE_GATE) || blockID.equals(BlockID.JUNGLE_FENCE_GATE) ||
                blockID.equals(BlockID.DARK_OAK_FENCE_GATE) || blockID.equals(BlockID.ACACIA_FENCE_GATE) ||
                blockID.equals(BlockID.CRIMSON_FENCE_GATE) || blockID.equals(BlockID.WARPED_FENCE_GATE) ||
                blockID.equals(BlockID.WOODEN_DOOR) || blockID.equals(BlockID.SPRUCE_DOOR) ||
                blockID.equals(BlockID.BIRCH_DOOR) || blockID.equals(BlockID.JUNGLE_DOOR) ||
                blockID.equals(BlockID.ACACIA_DOOR) || blockID.equals(BlockID.DARK_OAK_DOOR) ||
                blockID.equals(BlockID.CRIMSON_DOOR) || blockID.equals(BlockID.WARPED_DOOR) ||
                blockID.equals(BlockID.WOODEN_PRESSURE_PLATE) || blockID.equals(BlockID.TRAPDOOR) ||
                blockID.equals(BlockID.WALL_SIGN) || blockID.equals(BlockID.STANDING_SIGN) ||
                blockID.equals(BlockID.NOTEBLOCK) || blockID.equals(BlockID.BOOKSHELF) ||
                blockID.equals(BlockID.CHEST) || blockID.equals(BlockID.TRAPPED_CHEST) ||
                blockID.equals(BlockID.CRAFTING_TABLE) || blockID.equals(BlockID.JUKEBOX) ||
                blockID.equals(BlockID.BROWN_MUSHROOM_BLOCK) || blockID.equals(BlockID.RED_MUSHROOM_BLOCK) ||
                blockID.equals(BlockID.DAYLIGHT_DETECTOR) || blockID.equals(BlockID.DAYLIGHT_DETECTOR_INVERTED) ||
                blockID.equals(BlockID.STANDING_BANNER) || blockID.equals(BlockID.WALL_BANNER)) {
            return Instrument.BASS;
        } else if (blockID.equals(BlockID.SAND) || blockID.equals(BlockID.GRAVEL) || blockID.equals(BlockID.CONCRETE_POWDER)) {
            return Instrument.DRUM;
        } else if (blockID.equals(BlockID.GLASS) || blockID.equals(BlockID.GLASS_PANE) || blockID.equals(BlockID.STAINED_GLASS) ||
                blockID.equals(BlockID.STAINED_GLASS_PANE) || blockID.equals(BlockID.BEACON) || blockID.equals(BlockID.SEA_LANTERN)) {
            return Instrument.STICKS;
        } else if (blockID.equals(BlockID.STONE) || blockID.equals(BlockID.SANDSTONE) || blockID.equals(BlockID.RED_SANDSTONE) ||
                blockID.equals(BlockID.COBBLESTONE) || blockID.equals(BlockID.MOSSY_COBBLESTONE) || blockID.equals(BlockID.BRICK_BLOCK) ||
                blockID.equals(BlockID.STONEBRICK) || blockID.equals(BlockID.NETHER_BRICK) || blockID.equals(BlockID.RED_NETHER_BRICK) ||
                blockID.equals(BlockID.QUARTZ_BLOCK) || blockID.equals(BlockID.DOUBLE_WOODEN_SLAB) || blockID.equals(BlockID.WOODEN_SLAB) ||
                blockID.equals(BlockID.DOUBLE_STONE_BLOCK_SLAB2) || blockID.equals(BlockID.STONE_BLOCK_SLAB2) || blockID.equals(BlockID.STONE_STAIRS) ||
                blockID.equals(BlockID.BRICK_STAIRS) || blockID.equals(BlockID.STONE_BRICK_STAIRS) || blockID.equals(BlockID.NETHER_BRICK_STAIRS) ||
                blockID.equals(BlockID.SANDSTONE_STAIRS) || blockID.equals(BlockID.PURPUR_STAIRS) || blockID.equals(BlockID.COBBLESTONE_WALL) ||
                blockID.equals(BlockID.NETHER_BRICK_FENCE) || blockID.equals(BlockID.BEDROCK) || blockID.equals(BlockID.GOLD_ORE) ||
                blockID.equals(BlockID.IRON_ORE) || blockID.equals(BlockID.COAL_ORE) || blockID.equals(BlockID.LAPIS_ORE) ||
                blockID.equals(BlockID.DIAMOND_ORE) || blockID.equals(BlockID.REDSTONE_ORE) || blockID.equals(BlockID.LIT_REDSTONE_ORE) ||
                blockID.equals(BlockID.EMERALD_ORE) || blockID.equals(BlockID.DROPPER) || blockID.equals(BlockID.DISPENSER) ||
                blockID.equals(BlockID.FURNACE) || blockID.equals(BlockID.LIT_FURNACE) || blockID.equals(BlockID.OBSIDIAN) ||
                blockID.equals(BlockID.GLOWINGOBSIDIAN) || blockID.equals(BlockID.MOB_SPAWNER) || blockID.equals(BlockID.STONE_PRESSURE_PLATE) ||
                blockID.equals(BlockID.NETHERRACK) || blockID.equals(BlockID.QUARTZ_ORE) || blockID.equals(BlockID.ENCHANTING_TABLE) ||
                blockID.equals(BlockID.END_PORTAL_FRAME) || blockID.equals(BlockID.END_STONE) || blockID.equals(BlockID.END_BRICKS) ||
                blockID.equals(BlockID.ENDER_CHEST) || blockID.equals(BlockID.PRISMARINE) || blockID.equals(BlockID.COAL_BLOCK) ||
                blockID.equals(BlockID.PURPUR_BLOCK) || blockID.equals(BlockID.MAGMA) || blockID.equals(BlockID.CONCRETE) ||
                blockID.equals(BlockID.STONECUTTER) || blockID.equals(BlockID.OBSERVER) || blockID.equals(BlockID.CRIMSON_NYLIUM) || blockID.equals(BlockID.WARPED_NYLIUM)) {
            return Instrument.BASS_DRUM;
        } else {
            return Instrument.PIANO;
        }
    }

    public void emitSound() {
        if (this.up().getId() != BlockID.AIR) return;

        Instrument instrument = this.getInstrument();

        this.level.addLevelSoundEvent(this, LevelSoundEventPacket.SOUND_NOTE, instrument.ordinal() << 8 | this.getStrength());

        BlockEventPacket pk = new BlockEventPacket();
        pk.x = this.getFloorX();
        pk.y = this.getFloorY();
        pk.z = this.getFloorZ();
        pk.case1 = instrument.ordinal();
        pk.case2 = this.getStrength();
        this.getLevel().addChunkPacket(this.getFloorX() >> 4, this.getFloorZ() >> 4, pk);
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        this.increaseStrength();
        this.emitSound();
        return true;
    }

    @Override
    @PowerNukkitDifference(info = "Using new method for checking if powered", since = "1.4.0.0-PN")
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_REDSTONE) {
            // We can't use getOrCreateBlockEntity(), because the update method is called on block place,
            // before the "real" BlockEntity is set. That means, if we'd use the other method here,
            // it would create two BlockEntities.
            BlockEntityMusic music = getBlockEntity();
            if (music == null)
                return 0;

            if (this.isGettingPower()) {
                if (!music.isPowered()) {
                    this.emitSound();
                }
                music.setPowered(true);
            } else {
                music.setPowered(false);
            }
        }
        return super.onUpdate(type);
    }

    public enum Instrument {
        PIANO(Sound.NOTE_HARP),
        BASS_DRUM(Sound.NOTE_BD),
        DRUM(Sound.NOTE_SNARE),
        STICKS(Sound.NOTE_HAT),
        BASS(Sound.NOTE_BASS),
        GLOCKENSPIEL(Sound.NOTE_BELL),
        FLUTE(Sound.NOTE_FLUTE),
        CHIME(Sound.NOTE_CHIME),
        GUITAR(Sound.NOTE_GUITAR),
        XYLOPHONE(Sound.NOTE_XYLOPHONE),
        VIBRAPHONE(Sound.NOTE_IRON_XYLOPHONE),
        COW_BELL(Sound.NOTE_COW_BELL),
        DIDGERIDOO(Sound.NOTE_DIDGERIDOO),
        SQUARE_WAVE(Sound.NOTE_BIT),
        BANJO(Sound.NOTE_BANJO),
        ELECTRIC_PIANO(Sound.NOTE_PLING);

        private final Sound sound;

        Instrument(Sound sound) {
            this.sound = sound;
        }

        public Sound getSound() {
            return sound;
        }
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.WOOD_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.NOTEBLOCK);
    }
}

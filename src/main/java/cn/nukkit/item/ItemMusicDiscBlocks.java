package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscBlocks extends ItemMusicDisc {

    public ItemMusicDiscBlocks() {
        this(0, 1);
    }

    public ItemMusicDiscBlocks(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscBlocks(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_BLOCKS, meta, count);
        name = "Music Disc Blocks";
    }

    @Override
    public String getSoundId() {
        return "record.blocks";
    }
}

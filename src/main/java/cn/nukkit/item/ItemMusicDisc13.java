package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDisc13 extends ItemMusicDisc {

    public ItemMusicDisc13() {
        this(0, 1);
    }

    public ItemMusicDisc13(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDisc13(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_13, meta, count);
        name = "Music Disc 13";
    }

    @Override
    public String getSoundId() {
        return "record.13";
    }
}

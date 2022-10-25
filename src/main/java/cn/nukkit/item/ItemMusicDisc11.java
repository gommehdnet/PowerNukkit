package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDisc11 extends ItemMusicDisc {

    public ItemMusicDisc11() {
        this(0, 1);
    }

    public ItemMusicDisc11(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDisc11(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_11, meta, count);
        name = "Music Disc 11";
    }

    @Override
    public String getSoundId() {
        return "record.11";
    }
}

package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscCat extends ItemMusicDisc {

    public ItemMusicDiscCat() {
        this(0, 1);
    }

    public ItemMusicDiscCat(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscCat(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_CAT, meta, count);
        name = "Music Disc Cat";
    }

    @Override
    public String getSoundId() {
        return "record.cat";
    }
}

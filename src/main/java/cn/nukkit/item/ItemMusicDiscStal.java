package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscStal extends ItemMusicDisc {

    public ItemMusicDiscStal() {
        this(0, 1);
    }

    public ItemMusicDiscStal(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscStal(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_STAL, meta, count);
        name = "Music Disc Stal";
    }

    @Override
    public String getSoundId() {
        return "record.stal";
    }
}

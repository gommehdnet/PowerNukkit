package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMusicDiscOtherside extends Item {

    public ItemMusicDiscOtherside() {
        this(0, 1);
    }

    public ItemMusicDiscOtherside(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscOtherside(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_OTHERSIDE, meta, count, "Music Disc Otherside");
    }
}
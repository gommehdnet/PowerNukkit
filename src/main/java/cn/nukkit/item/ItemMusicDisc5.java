package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMusicDisc5 extends Item {

    public ItemMusicDisc5() {
        this(0, 1);
    }

    public ItemMusicDisc5(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDisc5(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_5, meta, count, "Music Disc 5");
    }
}
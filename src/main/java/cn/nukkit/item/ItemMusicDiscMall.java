package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscMall extends ItemMusicDisc {

    public ItemMusicDiscMall() {
        this(0, 1);
    }

    public ItemMusicDiscMall(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscMall(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_MALL, meta, count);
        name = "Music Disc Mall";
    }

    @Override
    public String getSoundId() {
        return "record.mall";
    }
}

package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscMellohi extends ItemMusicDisc {

    public ItemMusicDiscMellohi() {
        this(0, 1);
    }

    public ItemMusicDiscMellohi(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscMellohi(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_MELLOHI, meta, count);
        name = "Music Disc Mellohi";
    }

    @Override
    public String getSoundId() {
        return "record.mellohi";
    }
}

package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscFar extends ItemMusicDisc {

    public ItemMusicDiscFar() {
        this(0, 1);
    }

    public ItemMusicDiscFar(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscFar(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_FAR, meta, count);
        name = "Music Disc Far";
    }

    @Override
    public String getSoundId() {
        return "record.far";
    }
}

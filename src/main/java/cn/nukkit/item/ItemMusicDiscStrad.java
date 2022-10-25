package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscStrad extends ItemMusicDisc {

    public ItemMusicDiscStrad() {
        this(0, 1);
    }

    public ItemMusicDiscStrad(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscStrad(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_STRAD, meta, count);
        name = "Music Disc Strad";
    }

    @Override
    public String getSoundId() {
        return "record.strad";
    }
}

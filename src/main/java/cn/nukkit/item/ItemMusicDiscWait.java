package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscWait extends ItemMusicDisc {

    public ItemMusicDiscWait() {
        this(0, 1);
    }

    public ItemMusicDiscWait(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscWait(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_WAIT, meta, count);
        name = "Music Disc Wait";
    }

    @Override
    public String getSoundId() {
        return "record.wait";
    }
}

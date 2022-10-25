package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscWard extends ItemMusicDisc {

    public ItemMusicDiscWard() {
        this(0, 1);
    }

    public ItemMusicDiscWard(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscWard(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_WARD, meta, count);
        name = "Music Disc Ward";
    }

    @Override
    public String getSoundId() {
        return "record.ward";
    }
}

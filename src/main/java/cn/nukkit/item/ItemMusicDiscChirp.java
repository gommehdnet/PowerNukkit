package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public class ItemMusicDiscChirp extends ItemMusicDisc {

    public ItemMusicDiscChirp() {
        this(0, 1);
    }

    public ItemMusicDiscChirp(Integer meta) {
        this(meta, 1);
    }

    public ItemMusicDiscChirp(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_CHIRP, meta, count);
        name = "Music Disc Chirp";
    }

    @Override
    public String getSoundId() {
        return "record.chirp";
    }
}

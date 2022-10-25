package cn.nukkit.item;

import cn.nukkit.api.Since;

/**
 * @author PetteriM1
 */
@Since("1.4.0.0-PN")
public class ItemMusicDiscPigstep extends ItemMusicDisc {

    @Since("1.4.0.0-PN")
    public ItemMusicDiscPigstep() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemMusicDiscPigstep(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemMusicDiscPigstep(Integer meta, int count) {
        super(ItemID.MUSIC_DISC_PIGSTEP, meta, count);
        name = "Music Disc Pigstep";
    }

    @Override
    public String getSoundId() {
        return "record.pigstep";
    }
}

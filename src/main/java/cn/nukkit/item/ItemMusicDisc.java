package cn.nukkit.item;

/**
 * @author CreeperFace
 */
public abstract class ItemMusicDisc extends Item {

    public ItemMusicDisc(ItemID id, Integer meta, int count) {
        super(id, meta, count, "Music Disc");
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    public abstract String getSoundId();
}

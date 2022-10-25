package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemSign extends Item {

    public ItemSign(ItemID identifier) {
        super(identifier);
    }

    public ItemSign(ItemID identifier, int meta) {
        super(identifier, meta);
    }

    public ItemSign(ItemID identifier, int meta, int count) {
        super(identifier, meta, count);
    }

    public ItemSign(ItemID identifier, int meta, int count, String name) {
        super(identifier, meta, count, name);
    }

    @Override
    public int getMaxStackSize() {
        return 16;
    }
}

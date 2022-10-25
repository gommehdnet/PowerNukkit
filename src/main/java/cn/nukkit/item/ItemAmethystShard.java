package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAmethystShard extends Item {

    public ItemAmethystShard() {
        this(0, 1);
    }

    public ItemAmethystShard(Integer meta) {
        this(meta, 1);
    }

    public ItemAmethystShard(Integer meta, int count) {
        super(ItemID.AMETHYST_SHARD, meta, count, "Amethyst Shard");
    }
}
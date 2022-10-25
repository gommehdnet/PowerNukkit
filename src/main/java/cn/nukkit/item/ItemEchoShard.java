package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEchoShard extends Item {

    public ItemEchoShard() {
        this(0, 1);
    }

    public ItemEchoShard(Integer meta) {
        this(meta, 1);
    }

    public ItemEchoShard(Integer meta, int count) {
        super(ItemID.ECHO_SHARD, meta, count, "Echo Shard");
    }
}
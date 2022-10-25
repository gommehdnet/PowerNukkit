package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCommandBlockMinecart extends Item {

    public ItemCommandBlockMinecart() {
        this(0, 1);
    }

    public ItemCommandBlockMinecart(Integer meta) {
        this(meta, 1);
    }

    public ItemCommandBlockMinecart(Integer meta, int count) {
        super(ItemID.COMMAND_BLOCK_MINECART, meta, count, "Command Block Minecart");
    }
}
package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemIceBomb extends Item {

    public ItemIceBomb() {
        this(0, 1);
    }

    public ItemIceBomb(Integer meta) {
        this(meta, 1);
    }

    public ItemIceBomb(Integer meta, int count) {
        super(ItemID.ICE_BOMB, meta, count, "Ice Bomb");
    }
}
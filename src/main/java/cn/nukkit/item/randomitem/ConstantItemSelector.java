package cn.nukkit.item.randomitem;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Snake1999
 * @since 2016/1/15
 */
public class ConstantItemSelector extends Selector {

    protected final Item item;

    public ConstantItemSelector(ItemID id, Selector parent) {
        this(id, 0, parent);
    }

    public ConstantItemSelector(ItemID id, Integer meta, Selector parent) {
        this(id, meta, 1, parent);
    }

    public ConstantItemSelector(ItemID id, Integer meta, int count, Selector parent) {
        this(Item.get(id, meta, count), parent);
    }

    public ConstantItemSelector(Item item, Selector parent) {
        super(parent);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public Object select() {
        return getItem();
    }
}

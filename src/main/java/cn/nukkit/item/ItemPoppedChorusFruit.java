package cn.nukkit.item;

import cn.nukkit.api.Since;

@Since("1.4.0.0-PN")
public class ItemPoppedChorusFruit extends Item {

    @Since("1.4.0.0-PN")
    public ItemPoppedChorusFruit() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemPoppedChorusFruit(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemPoppedChorusFruit(Integer meta, int count) {
        super(ItemID.POPPED_CHORUS_FRUIT, meta, count, "Popped Chorus Fruit");
    }
}

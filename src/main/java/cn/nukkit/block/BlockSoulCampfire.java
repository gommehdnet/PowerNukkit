package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.entity.EntityDamageByBlockEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockSoulCampfire extends BlockCampfire {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockSoulCampfire() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockSoulCampfire(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SOUL_CAMPFIRE;
    }

    @Override
    public String getName() {
        return "Soul Campfire";
    }

    @Override
    public int getLightLevel() {
        return isExtinguished()? 0 : 10;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SOUL_CAMPFIRE);
    }
    
    @Override
    public Item[] getDrops(Item item) {
        return new Item[] { Item.get(ItemID.SOUL_SOIL) };
    }
    
    @Since("1.5.1.0-PN")
    @PowerNukkitOnly
    @Override
    protected EntityDamageEvent getDamageEvent(Entity entity) {
        return new EntityDamageByBlockEvent(this, entity, EntityDamageEvent.DamageCause.FIRE, 2);
    }
}

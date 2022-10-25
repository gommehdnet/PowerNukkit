package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntityCauldron;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.entity.EntityCombustByBlockEvent;
import cn.nukkit.event.entity.EntityDamageByBlockEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerBucketEmptyEvent;
import cn.nukkit.event.player.PlayerBucketFillEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBucket;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.Sound;
import cn.nukkit.math.AxisAlignedBB;
import cn.nukkit.potion.Effect;

import javax.annotation.Nonnull;

@PowerNukkitOnly
public class BlockLavaCauldron extends BlockCauldron {
    @PowerNukkitOnly
    public BlockLavaCauldron() {
        this(0x8);
    }

    @PowerNukkitOnly
    public BlockLavaCauldron(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Lava Cauldron";
    }

    @Override
    public BlockID getId() {
        return BlockID.LAVA_CAULDRON;
    }

    @Override
    public int getLightLevel() {
        return 15;
    }

    @Override
    public boolean hasEntityCollision() {
        return true;
    }

    @Override
    protected AxisAlignedBB recalculateCollisionBoundingBox() {
        return shrink(0.3, 0.3, 0.3);
    }

    @PowerNukkitOnly
    @Override
    public void setFillLevel(int fillLevel) {
        super.setFillLevel(fillLevel);
        setDamage(getDamage() | 0x8);
    }

    @Override
    public void onEntityCollide(Entity entity) {
        // Always setting the duration to 15 seconds? TODO
        EntityCombustByBlockEvent ev = new EntityCombustByBlockEvent(this, entity, 15);
        Server.getInstance().getPluginManager().callEvent(ev);
        if (!ev.isCancelled()
                // Making sure the entity is actually alive and not invulnerable.
                && entity.isAlive()
                && entity.noDamageTicks == 0) {
            entity.setOnFire(ev.getDuration());
        }

        if (!entity.hasEffect(Effect.FIRE_RESISTANCE)) {
            entity.attack(new EntityDamageByBlockEvent(this, entity, EntityDamageEvent.DamageCause.LAVA, 4));
        }
    }

    @Override
    public boolean onActivate(@Nonnull Item item, Player player) {
        BlockEntity be = this.level.getBlockEntity(this);

        if (!(be instanceof BlockEntityCauldron)) {
            return false;
        }

        BlockEntityCauldron cauldron = (BlockEntityCauldron) be;

        if (item.getIdentifier().equals(ItemID.BUCKET)) {
            ItemBucket bucket = (ItemBucket) item;
            if (bucket.getFishEntityId() != null) {
                return false;
            }
            if (item.getDamage() == 0) { //empty
                if (!isFull() || cauldron.isCustomColor() || cauldron.hasPotion()) {
                    return false;
                }

                PlayerBucketFillEvent ev = new PlayerBucketFillEvent(player, this, null, this, item, Item.get(ItemID.LAVA_BUCKET));
                this.level.getServer().getPluginManager().callEvent(ev);
                if (!ev.isCancelled()) {
                    replaceBucket(bucket, player, ev.getItem());
                    this.setFillLevel(FILL_LEVEL.getMinValue());//empty
                    this.level.setBlock(this, new BlockCauldron(0), true);
                    cauldron.clearCustomColor();
                    this.getLevel().addSound(this.add(0.5, 1, 0.5), Sound.BUCKET_FILL_LAVA);
                }
            } else if (bucket.isWater() || bucket.isLava()) { //water or lava bucket
                if (isFull() && !cauldron.isCustomColor() && !cauldron.hasPotion() && item.getDamage() == 10) {
                    return false;
                }

                PlayerBucketEmptyEvent ev = new PlayerBucketEmptyEvent(player, this, null, this, item, Item.get(ItemID.BUCKET));
                this.level.getServer().getPluginManager().callEvent(ev);
                if (!ev.isCancelled()) {
                    replaceBucket(bucket, player, ev.getItem());

                    if (cauldron.hasPotion()) {//if has potion
                        clearWithFizz(cauldron);
                    } else if (bucket.isLava()) { //lava bucket
                        this.setFillLevel(FILL_LEVEL.getMaxValue());//fill
                        cauldron.clearCustomColor();
                        this.level.setBlock(this, this, true);
                        this.getLevel().addSound(this.add(0.5, 1, 0.5), Sound.BUCKET_EMPTY_LAVA);
                    } else {
                        if (isEmpty()) {
                            this.level.setBlock(this, new BlockCauldron(6), true, true);
                            cauldron.clearCustomColor();
                            this.getLevel().addSound(this.add(0.5, 1, 0.5), Sound.CAULDRON_FILLWATER);
                        } else {
                            clearWithFizz(cauldron);
                        }
                    }
                }
            }
        }

        if (item.getIdentifier().equals(ItemID.POTION) || item.getIdentifier().equals(ItemID.SPLASH_POTION) || item.getIdentifier().equals(ItemID.LINGERING_POTION)) {
            if (!isEmpty() && (cauldron.hasPotion() ? cauldron.getPotionId() != item.getDamage() : item.getDamage() != 0)) {
                clearWithFizz(cauldron);
            }

            return super.onActivate(item, player);
        }

        if (item.getIdentifier().equals(ItemID.GLASS_BOTTLE)) {
            if (!isEmpty() && cauldron.hasPotion()) {
                return super.onActivate(item, player);
            }
        }

        this.level.updateComparatorOutputLevel(this);
        return true;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CAULDRON);
    }
}

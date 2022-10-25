package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.*;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.player.PlayerBucketEmptyEvent;
import cn.nukkit.event.player.PlayerBucketFillEvent;
import cn.nukkit.event.player.PlayerItemConsumeEvent;
import cn.nukkit.level.Level;
import cn.nukkit.level.Sound;
import cn.nukkit.level.particle.ExplodeParticle;
import cn.nukkit.math.BlockFace;
import cn.nukkit.math.BlockFace.Plane;
import cn.nukkit.math.Vector3;
import cn.nukkit.network.protocol.LevelSoundEventPacket;
import cn.nukkit.network.protocol.UpdateBlockPacket;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public abstract class ItemBucket extends Item {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public ItemBucket(ItemID id, int count, String name) {
        super(id, 0, count, name);
    }

    public ItemBucket(Integer meta, int count) {
        super(ItemID.BUCKET, meta, count);
    }

    public ItemBucket(int count) {
        super(ItemID.BUCKET, 0, count, "Bucket");
    }

    public static String getBlockIdByItemId(ItemID target) {
        if (target.equals(ItemID.COD_BUCKET) || target.equals(ItemID.SALMON_BUCKET) || target.equals(ItemID.TROPICAL_FISH_BUCKET) ||
                target.equals(ItemID.PUFFERFISH_BUCKET) || target.equals(ItemID.WATER_BUCKET)) {
            return BlockID.FLOWING_WATER.getIdentifier();
        }

        if (target.equals(ItemID.LAVA_BUCKET)) {
            return BlockID.LAVA.getIdentifier();
        }

        return BlockID.AIR.getIdentifier();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isEmpty() {
        return Objects.equals(getIdentifier(), ItemID.BUCKET.getIdentifier());
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isWater() {
        return getTargetBlock().getId() == BlockID.WATER;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isLava() {
        return getTargetBlock().getId() == BlockID.LAVA;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nullable
    public String getFishEntityId() {
        if (!Objects.equals(getIdentifier(), ItemID.BUCKET.getIdentifier())) {
            return null;
        }

        if (this.identifier.equals(ItemID.COD_BUCKET)) {
            return "Cod";
        } else if (this.identifier.equals(ItemID.SALMON_BUCKET)) {
            return "Salmon";
        } else if (this.identifier.equals(ItemID.TROPICAL_FISH_BUCKET)) {
            return "TropicalFish";
        } else if (this.identifier.equals(ItemID.PUFFERFISH_BUCKET)) {
            return "Pufferfish";
        } else {
            return null;
        }
    }

    @Override
    public int getMaxStackSize() {
        return this.meta == 0 && getIdentifier() == ItemID.BUCKET ? 16 : 1;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public Block getTargetBlock() {
        return getIdentifier() == ItemID.BUCKET ? Block.get(BlockID.byIdentifier(getBlockIdByItemId(this.identifier))) : Block.get(BlockID.AIR);
    }


    @PowerNukkitDifference(info = "You can't use bucket in adventure mode.", since = "1.4.0.0-PN")
    @PowerNukkitDifference(info = "Using new method to play sounds", since = "1.4.0.0-PN")
    @Override
    public boolean onActivate(Level level, Player player, Block block, Block target, BlockFace face, double fx, double fy, double fz) {
        if (player.isAdventure()) {
            return false;
        }

        Block targetBlock = getTargetBlock();

        if (targetBlock instanceof BlockAir) {
            if (!(target instanceof BlockLiquid)) {
                target = target.getLevelBlockAtLayer(1);
            }
            if (!(target instanceof BlockLiquid)) {
                target = block;
            }
            if (!(target instanceof BlockLiquid)) {
                target = block.getLevelBlockAtLayer(1);
            }
            if (target instanceof BlockLiquid) {
                Item result = Item.get(ItemID.byIdentifier(getBlockIdByItemId(target.getItemId())));
                PlayerBucketFillEvent ev;
                player.getServer().getPluginManager().callEvent(ev = new PlayerBucketFillEvent(player, block, face, target, this, result));
                if (!ev.isCancelled()) {
                    player.getLevel().setBlock(target, target.layer, Block.get(BlockID.AIR), true, true);

                    // When water is removed ensure any adjacent still water is
                    // replaced with water that can flow.
                    for (BlockFace side : Plane.HORIZONTAL) {
                        Block b = target.getSideAtLayer(0, side);
                        if (b.getId() == BlockID.WATER) {
                            level.setBlock(b, Block.get(BlockID.WATER));
                        }
                    }

                    if (player.isSurvival()) {
                        if (this.getCount() - 1 <= 0) {
                            player.getInventory().setItemInHand(ev.getItem());
                        } else {
                            Item clone = this.clone();
                            clone.setCount(this.getCount() - 1);
                            player.getInventory().setItemInHand(clone);
                            if (player.getInventory().canAddItem(ev.getItem())) {
                                player.getInventory().addItem(ev.getItem());
                            } else {
                                player.dropItem(ev.getItem());
                            }
                        }
                    }

                    if (target instanceof BlockFlowingLava) {
                        level.addSound(block, Sound.BUCKET_FILL_LAVA);
                    } else {
                        level.addSound(block, Sound.BUCKET_FILL_WATER);
                    }

                    return true;
                } else {
                    player.getInventory().sendContents(player);
                }
            }
        } else if (targetBlock instanceof BlockLiquid) {
            Item result = Item.get(ItemID.BUCKET);
            boolean usesWaterlogging = ((BlockLiquid) targetBlock).usesWaterLogging();
            Block placementBlock;
            if (usesWaterlogging) {
                if (block.getId() == BlockID.BAMBOO) {
                    placementBlock = block;
                } else if (target.getWaterloggingLevel() > 0) {
                    placementBlock = target.getLevelBlockAtLayer(1);
                } else if (block.getWaterloggingLevel() > 0) {
                    placementBlock = block.getLevelBlockAtLayer(1);
                } else {
                    placementBlock = block;
                }
            } else {
                placementBlock = block;
            }

            PlayerBucketEmptyEvent ev = new PlayerBucketEmptyEvent(player, placementBlock, face, target, this, result);
            boolean canBeFlowedInto = placementBlock.canBeFlowedInto() || placementBlock.getId() == BlockID.BAMBOO;
            if (usesWaterlogging) {
                ev.setCancelled(placementBlock.getWaterloggingLevel() <= 0 && !canBeFlowedInto);
            } else {
                ev.setCancelled(!canBeFlowedInto);
            }

            boolean nether = false;
            if (!canBeUsedOnDimension(player.getLevel().getDimension())) {
                ev.setCancelled(true);
                nether = !this.identifier.equals(ItemID.LAVA_BUCKET);
            }

            player.getServer().getPluginManager().callEvent(ev);

            if (!ev.isCancelled()) {
                player.getLevel().setBlock(placementBlock, placementBlock.layer, targetBlock, true, true);
                if (player.isSurvival()) {
                    if (this.getCount() - 1 <= 0) {
                        player.getInventory().setItemInHand(ev.getItem());
                    } else {
                        Item clone = this.clone();
                        clone.setCount(this.getCount() - 1);
                        player.getInventory().setItemInHand(clone);
                        if (player.getInventory().canAddItem(ev.getItem())) {
                            player.getInventory().addItem(ev.getItem());
                        } else {
                            player.dropItem(ev.getItem());
                        }
                    }
                }

                afterUse(level, block);

                return true;
            } else if (nether) {
                if (!player.isCreative()) {
                    player.getInventory().setItemInHand(Item.get(ItemID.BUCKET));
                }
                player.getLevel().addLevelSoundEvent(target, LevelSoundEventPacket.SOUND_FIZZ);
                player.getLevel().addParticle(new ExplodeParticle(target.add(0.5, 1, 0.5)));
            } else {
                player.getLevel().sendBlocks(new Player[]{player}, new Block[]{block.getLevelBlockAtLayer(1)}, UpdateBlockPacket.FLAG_ALL_PRIORITY, 1);
                player.getInventory().sendContents(player);
            }
        }

        return false;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    protected boolean canBeUsedOnDimension(int dimension) {
        if (!this.getIdentifier().equals(ItemID.BUCKET)) {
            return true;
        }

        return dimension != Level.DIMENSION_NETHER || (this.getIdentifier().equals(ItemID.LAVA_BUCKET) || this.getIdentifier().equals(ItemID.MILK_BUCKET));
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    protected void afterUse(Level level, Block block) {
        if (!this.getIdentifier().equals(ItemID.BUCKET)) {
            return;
        }

        if (this.getIdentifier().equals(ItemID.LAVA_BUCKET)) {
            level.addSound(block, Sound.BUCKET_EMPTY_LAVA);
        } else {
            level.addSound(block, Sound.BUCKET_EMPTY_WATER);
        }

        if (this.getIdentifier().equals(ItemID.COD_BUCKET)) {
            Entity e2 = Entity.createEntity("Cod", block);
            if (e2 != null) e2.spawnToAll();
        } else if (this.getIdentifier().equals(ItemID.SALMON_BUCKET)) {
            Entity e2 = Entity.createEntity("Salmon", block);
            if (e2 != null) e2.spawnToAll();
        } else if (this.getIdentifier().equals(ItemID.TROPICAL_FISH_BUCKET)) {
            Entity e2 = Entity.createEntity("TropicalFish", block);
            if (e2 != null) e2.spawnToAll();
        } else if (this.getIdentifier().equals(ItemID.PUFFERFISH_BUCKET)) {
            Entity e2 = Entity.createEntity("Pufferfish", block);
            if (e2 != null) e2.spawnToAll();
        }
    }

    @Override
    public boolean onClickAir(Player player, Vector3 directionVector) {
        return getIdentifier().equals(ItemID.MILK_BUCKET);
    }

    @PowerNukkitDifference(info = "You can't use milk in spectator mode and milk is now 'drinked' in adventure mode", since = "1.4.0.0-PN")
    @Override
    public boolean onUse(Player player, int ticksUsed) {
        if (player.isSpectator() || !this.identifier.equals(ItemID.MILK_BUCKET)) {
            return false;
        }

        PlayerItemConsumeEvent consumeEvent = new PlayerItemConsumeEvent(player, this);

        player.getServer().getPluginManager().callEvent(consumeEvent);
        if (consumeEvent.isCancelled()) {
            player.getInventory().sendContents(player);
            return false;
        }

        if (!player.isCreative()) {
            player.getInventory().setItemInHand(Item.get(ItemID.BUCKET));
        }

        player.removeAllEffects();
        return true;
    }
}
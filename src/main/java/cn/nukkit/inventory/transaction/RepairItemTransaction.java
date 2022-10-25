package cn.nukkit.inventory.transaction;

import cn.nukkit.Player;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockAnvil;
import cn.nukkit.block.BlockID;
import cn.nukkit.blockproperty.value.AnvilDamage;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.event.block.AnvilDamageEvent;
import cn.nukkit.event.block.AnvilDamageEvent.DamageCause;
import cn.nukkit.event.inventory.RepairItemEvent;
import cn.nukkit.inventory.AnvilInventory;
import cn.nukkit.inventory.FakeBlockMenu;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.transaction.action.InventoryAction;
import cn.nukkit.inventory.transaction.action.RepairItemAction;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.network.protocol.LevelEventPacket;
import cn.nukkit.network.protocol.types.NetworkInventoryAction;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Since("1.4.0.0-PN")
public class RepairItemTransaction extends InventoryTransaction {

    private Item inputItem;
    private Item materialItem;
    private Item outputItem;

    private int cost;

    @Since("1.4.0.0-PN")
    public RepairItemTransaction(Player source, List<InventoryAction> actions) {
        super(source, actions);
    }

    @Override
    public boolean canExecute() {
        Inventory inventory = getSource().getWindowById(Player.ANVIL_WINDOW_ID);
        if (inventory == null) {
            return false;
        }
        AnvilInventory anvilInventory = (AnvilInventory) inventory;
        return this.inputItem != null && this.outputItem != null && this.inputItem.equals(anvilInventory.getInputSlot(), true, true)
                && (!this.hasMaterial() || this.materialItem.equals(anvilInventory.getMaterialSlot(), true, true))
                && this.checkRecipeValid();
    }

    @Override
    public boolean execute() {
        if (this.hasExecuted() || !this.canExecute()) {
            this.source.removeAllWindows(false);
            this.sendInventories();
            return false;
        }
        AnvilInventory inventory = (AnvilInventory) getSource().getWindowById(Player.ANVIL_WINDOW_ID);

        if (inventory.getCost() != this.cost && !this.source.isCreative()) {
            this.source.getServer().getLogger().debug("Got unexpected cost " + inventory.getCost() + " from " + this.source.getName() + "(expected " + this.cost + ")");
        }

        RepairItemEvent event = new RepairItemEvent(inventory, this.inputItem, this.outputItem, this.materialItem, this.cost, this.source);
        this.source.getServer().getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            this.source.removeAllWindows(false);
            this.sendInventories();
            return true;
        }

        for (InventoryAction action : this.actions) {
            if (action.execute(this.source)) {
                action.onExecuteSuccess(this.source);
            } else {
                action.onExecuteFail(this.source);
            }
        }

        FakeBlockMenu holder = inventory.getHolder();
        Block block = this.source.level.getBlock(holder.getFloorX(), holder.getFloorY(), holder.getFloorZ());
        if (block.getId() == BlockID.ANVIL) {
            int oldDamage = block.getDamage() >= 8 ? 2 : block.getDamage() >= 4 ? 1 : 0;
            int newDamage = !this.source.isCreative() && ThreadLocalRandom.current().nextInt(100) < 12 ? oldDamage + 1 : oldDamage;

            AnvilDamageEvent ev = new AnvilDamageEvent(block, oldDamage, newDamage, DamageCause.USE, this.source);
            ev.setCancelled(oldDamage == newDamage);
            this.source.getServer().getPluginManager().callEvent(ev);
            if (!ev.isCancelled()) {
                BlockState newState = ev.getNewBlockState();
                if (newState.getBlockId() == BlockID.AIR
                        || newState.getBlockId() == BlockID.ANVIL && newState.getPropertyValue(BlockAnvil.DAMAGE).equals(AnvilDamage.BROKEN)) {
                    this.source.level.setBlock(block, Block.get(BlockID.AIR), true);
                    this.source.level.addLevelEvent(block, LevelEventPacket.EVENT_SOUND_ANVIL_BREAK);
                } else {
                    if (!newState.equals(ev.getOldBlockState())) {
                        Block newBlock = newState.getBlockRepairing(block);
                        this.source.level.setBlock(block, newBlock, true);
                    }
                    this.source.level.addLevelEvent(block, LevelEventPacket.EVENT_SOUND_ANVIL_USE);
                }
            } else {
                this.source.level.addLevelEvent(block, LevelEventPacket.EVENT_SOUND_ANVIL_USE);
            }
        }

        if (!this.source.isCreative()) {
            this.source.setExperience(this.source.getExperience(), this.source.getExperienceLevel() - event.getCost());
        }
        return true;
    }

    @Override
    public void addAction(InventoryAction action) {
        super.addAction(action);
        if (action instanceof RepairItemAction) {
            switch (((RepairItemAction) action).getType()) {
                case NetworkInventoryAction.SOURCE_TYPE_ANVIL_INPUT:
                    this.inputItem = action.getTargetItem();
                    break;
                case NetworkInventoryAction.SOURCE_TYPE_ANVIL_RESULT:
                    this.outputItem = action.getSourceItem();
                    break;
                case NetworkInventoryAction.SOURCE_TYPE_ANVIL_MATERIAL:
                    this.materialItem = action.getTargetItem();
                    break;
            }
        }
    }

    private boolean checkRecipeValid() {
        int cost = 0;
        int baseRepairCost = this.inputItem.getRepairCost();

        if (this.isMapRecipe()) {
            if (!this.matchMapRecipe()) {
                return false;
            }
            baseRepairCost = 0;
        } else if (this.hasMaterial()) {
            baseRepairCost += this.materialItem.getRepairCost();

            if (this.inputItem.getMaxDurability() != -1 && this.matchRepairItem()) {
                int maxRepairDamage = this.inputItem.getMaxDurability() / 4;
                int repairDamage = Math.min(this.inputItem.getDamage(), maxRepairDamage);
                if (repairDamage <= 0) {
                    return false;
                }

                int damage = this.inputItem.getDamage();
                for (; repairDamage > 0 && cost < this.materialItem.getCount(); cost++) {
                    damage = damage - repairDamage;
                    repairDamage = Math.min(damage, maxRepairDamage);
                }
                if (this.outputItem.getDamage() != damage) {
                    return false;
                }
            } else {
                boolean consumeEnchantedBook = this.materialItem.getIdentifier() == ItemID.ENCHANTED_BOOK && this.materialItem.hasEnchantments();
                if (!consumeEnchantedBook && (this.inputItem.getMaxDurability() == -1 || this.inputItem.getIdentifier() != this.materialItem.getIdentifier())) {
                    return false;
                }

                if (!consumeEnchantedBook && this.inputItem.getMaxDurability() != -1) {
                    int damage = this.inputItem.getDamage() - this.inputItem.getMaxDurability() + this.materialItem.getDamage() - this.inputItem.getMaxDurability() * 12 / 100 + 1;
                    if (damage < 0) {
                        damage = 0;
                    }

                    if (damage < this.inputItem.getDamage()) {
                        if (this.outputItem.getDamage() != damage) {
                            return false;
                        }
                        cost += 2;
                    }
                }

                Int2IntMap enchantments = new Int2IntOpenHashMap();
                enchantments.defaultReturnValue(-1);
                for (Enchantment enchantment : this.inputItem.getEnchantments()) {
                    enchantments.put(enchantment.getId(), enchantment.getLevel());
                }

                boolean hasCompatibleEnchantments = false;
                boolean hasIncompatibleEnchantments = false;
                for (Enchantment materialEnchantment : this.materialItem.getEnchantments()) {
                    Enchantment enchantment = this.inputItem.getEnchantment(materialEnchantment.getId());
                    int inputLevel = enchantment != null ? enchantment.getLevel() : 0;
                    int materialLevel = materialEnchantment.getLevel();
                    int outputLevel = inputLevel == materialLevel ? materialLevel + 1 : Math.max(materialLevel, inputLevel);

                    boolean canEnchant = materialEnchantment.canEnchant(this.inputItem) || this.inputItem.getIdentifier() == ItemID.ENCHANTED_BOOK;
                    for (Enchantment inputEnchantment : this.inputItem.getEnchantments()) {
                        if (inputEnchantment.getId() != materialEnchantment.getId() && !materialEnchantment.isCompatibleWith(inputEnchantment)) {
                            canEnchant = false;
                            cost++;
                        }
                    }

                    if (!canEnchant) {
                        hasIncompatibleEnchantments = true;
                    } else {
                        hasCompatibleEnchantments = true;
                        if (outputLevel > materialEnchantment.getMaxLevel()) {
                            outputLevel = materialEnchantment.getMaxLevel();
                        }

                        enchantments.put(materialEnchantment.getId(), outputLevel);
                        int rarityFactor;
                        switch (materialEnchantment.getRarity()) {
                            case COMMON:
                                rarityFactor = 1;
                                break;
                            case UNCOMMON:
                                rarityFactor = 2;
                                break;
                            case RARE:
                                rarityFactor = 4;
                                break;
                            case VERY_RARE:
                            default:
                                rarityFactor = 8;
                                break;
                        }

                        if (consumeEnchantedBook) {
                            rarityFactor = Math.max(1, rarityFactor / 2);
                        }

                        cost += rarityFactor * Math.max(0, outputLevel - inputLevel);
                        if (this.inputItem.getCount() > 1) {
                            cost = 40;
                        }
                    }
                }

                Enchantment[] outputEnchantments = this.outputItem.getEnchantments();
                if (hasIncompatibleEnchantments && !hasCompatibleEnchantments || enchantments.size() != outputEnchantments.length) {
                    return false;
                }

                for (Enchantment enchantment : outputEnchantments) {
                    if (enchantments.get(enchantment.getId()) != enchantment.getLevel()) {
                        return false;
                    }
                }
            }
        }

        int renameCost = 0;
        if (!this.inputItem.getCustomName().equals(this.outputItem.getCustomName())) {
            if (this.outputItem.getCustomName().length() > 30) {
                return false;
            }
            renameCost = 1;
            cost += renameCost;
        }

        this.cost = baseRepairCost + cost;
        if (renameCost == cost && renameCost > 0 && this.cost >= 40) {
            this.cost = 39;
        }
        if (baseRepairCost < 0 || cost < 0 || cost == 0 && !this.isMapRecipe() || this.cost > 39 && !this.source.isCreative()) {
            return false;
        }

        int nextBaseRepairCost = this.inputItem.getRepairCost();
        if (!this.isMapRecipe()) {
            if (this.hasMaterial() && nextBaseRepairCost < this.materialItem.getRepairCost()) {
                nextBaseRepairCost = this.materialItem.getRepairCost();
            }
            if (renameCost == 0 || renameCost != cost) {
                nextBaseRepairCost = 2 * nextBaseRepairCost + 1;
            }
        }
        if (this.outputItem.getRepairCost() != nextBaseRepairCost) {
            this.source.getServer().getLogger().debug("Got unexpected base cost " + this.outputItem.getRepairCost() + " from " + this.source.getName() + "(expected " + nextBaseRepairCost + ")");
            return false;
        }

        return true;
    }

    private boolean hasMaterial() {
        return this.materialItem != null && !this.materialItem.isNull();
    }

    private boolean isMapRecipe() {
        return this.hasMaterial() && (this.inputItem.getIdentifier() == ItemID.FILLED_MAP || this.inputItem.getIdentifier() == ItemID.EMPTY_MAP)
                && (this.materialItem.getIdentifier() == ItemID.EMPTY_MAP || this.materialItem.getIdentifier() == ItemID.PAPER || this.materialItem.getIdentifier() == ItemID.COMPASS);
    }

    private boolean matchMapRecipe() {
        if (this.inputItem.getIdentifier() == ItemID.EMPTY_MAP) {
            return this.inputItem.getDamage() != 2 && this.materialItem.getIdentifier() == ItemID.COMPASS // locator
                    && this.outputItem.getIdentifier() == ItemID.EMPTY_MAP && this.outputItem.getDamage() == 2 && this.outputItem.getCount() == 1;
        } else if (this.inputItem.getIdentifier() == ItemID.FILLED_MAP && this.outputItem.getDamage() == this.inputItem.getDamage()) {
            if (this.materialItem.getIdentifier() == ItemID.COMPASS) { // locator
                return this.inputItem.getDamage() != 2 && this.outputItem.getIdentifier() == ItemID.FILLED_MAP && this.outputItem.getCount() == 1;
            } else if (this.materialItem.getIdentifier() == ItemID.EMPTY_MAP) { // clone
                return this.outputItem.getIdentifier() == ItemID.FILLED_MAP && this.outputItem.getCount() == 2;
            } else if (this.materialItem.getIdentifier() == ItemID.PAPER && this.materialItem.getCount() >= 8) { // zoom out
                return this.inputItem.getDamage() < 3 && this.outputItem.getIdentifier() == ItemID.FILLED_MAP && this.outputItem.getCount() == 1;
            }
        }
        return false;
    }

    private final List<ItemID> leatherPieces = Arrays.asList(ItemID.LEATHER_HELMET, ItemID.LEATHER_CHESTPLATE, ItemID.LEATHER_LEGGINGS, ItemID.LEATHER_BOOTS);
    private final List<ItemID> woodenTools = Arrays.asList(ItemID.WOODEN_SWORD, ItemID.WOODEN_AXE, ItemID.WOODEN_PICKAXE, ItemID.WOODEN_SHOVEL, ItemID.WOODEN_HOE);
    private final List<ItemID> ironChainPieces = Arrays.asList(ItemID.IRON_SWORD, ItemID.IRON_PICKAXE, ItemID.IRON_SHOVEL, ItemID.IRON_AXE, ItemID.IRON_HOE, ItemID.IRON_HELMET,
            ItemID.IRON_CHESTPLATE, ItemID.IRON_LEGGINGS, ItemID.IRON_BOOTS, ItemID.CHAINMAIL_HELMET, ItemID.CHAINMAIL_CHESTPLATE, ItemID.CHAINMAIL_LEGGINGS, ItemID.CHAINMAIL_BOOTS);
    private final List<ItemID> goldPieces = Arrays.asList(ItemID.GOLDEN_SWORD, ItemID.GOLDEN_PICKAXE, ItemID.GOLDEN_SHOVEL, ItemID.GOLDEN_AXE, ItemID.GOLDEN_HOE, ItemID.GOLDEN_HELMET,
            ItemID.GOLDEN_CHESTPLATE, ItemID.GOLDEN_LEGGINGS, ItemID.GOLDEN_BOOTS);
    private final List<ItemID> diamondPieces = Arrays.asList(ItemID.DIAMOND_SWORD, ItemID.DIAMOND_PICKAXE, ItemID.DIAMOND_SHOVEL, ItemID.DIAMOND_AXE, ItemID.DIAMOND_HOE,
            ItemID.DIAMOND_HELMET, ItemID.DIAMOND_CHESTPLATE, ItemID.DIAMOND_LEGGINGS, ItemID.DIAMOND_BOOTS);
    private final List<ItemID> netheritePieces = Arrays.asList(ItemID.NETHERITE_SWORD, ItemID.NETHERITE_PICKAXE, ItemID.NETHERITE_AXE, ItemID.NETHERITE_SHOVEL, ItemID.NETHERITE_HOE,
            ItemID.NETHERITE_HELMET, ItemID.NETHERITE_CHESTPLATE, ItemID.NETHERITE_LEGGINGS, ItemID.NETHERITE_BOOTS);

    private boolean matchRepairItem() {
        final ItemID itemID = this.inputItem.getIdentifier();

        if (this.leatherPieces.contains(itemID)) {
            return this.materialItem.getIdentifier() == ItemID.LEATHER;
        }

        if (this.woodenTools.contains(itemID)) {
            return this.materialItem.getIdentifier() == ItemID.PLANKS;
        }

        if (this.ironChainPieces.contains(itemID)) {
            return this.materialItem.getIdentifier() == ItemID.IRON_INGOT;
        }

        if (this.goldPieces.contains(itemID)) {
            return this.materialItem.getIdentifier() == ItemID.GOLD_INGOT;
        }

        if (this.diamondPieces.contains(itemID)) {
            return this.materialItem.getIdentifier() == ItemID.DIAMOND;
        }

        if (this.netheritePieces.contains(itemID)) {
            return this.materialItem.getIdentifier() == ItemID.NETHERITE_INGOT;
        }

        if (itemID.equals(ItemID.TURTLE_HELMET)) {
            return this.materialItem.getIdentifier().equals(ItemID.SCUTE);
        }

        if (itemID.equals(ItemID.ELYTRA)) {
            return this.materialItem.getIdentifier().equals(ItemID.PHANTOM_MEMBRANE);
        }

        return false;
    }

    @Since("1.4.0.0-PN")
    public Item getInputItem() {
        return this.inputItem;
    }

    @Since("1.4.0.0-PN")
    public Item getMaterialItem() {
        return this.materialItem;
    }

    @Since("1.4.0.0-PN")
    public Item getOutputItem() {
        return this.outputItem;
    }

    @Since("1.4.0.0-PN")
    public int getCost() {
        return this.cost;
    }

    @Since("1.4.0.0-PN")
    public static boolean checkForRepairItemPart(List<InventoryAction> actions) {
        for (InventoryAction action : actions) {
            if (action instanceof RepairItemAction) {
                return true;
            }
        }
        return false;
    }
}

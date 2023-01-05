package cn.nukkit.inventory;

import cn.nukkit.Player;
import cn.nukkit.api.DeprecationDetails;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.level.Position;
import cn.nukkit.nbt.tag.CompoundTag;
import io.netty.util.internal.StringUtil;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class AnvilInventory extends FakeBlockUIComponent {

    @Since("1.4.0.0-PN")
    public static final int ANVIL_INPUT_UI_SLOT = 1;
    @Since("1.4.0.0-PN")
    public static final int ANVIL_MATERIAL_UI_SLOT = 2;
    @Since("1.4.0.0-PN")
    public static final int ANVIL_OUTPUT_UI_SLOT = CREATED_ITEM_OUTPUT_UI_SLOT;

    @PowerNukkitOnly
    public static final int OFFSET = 1;
    public static final int TARGET = 0;
    public static final int SACRIFICE = 1;
    public static final int RESULT = ANVIL_OUTPUT_UI_SLOT - 1; //1: offset

    private int cost;
    private String newItemName;

    @NonNull
    private Item currentResult = Item.get(ItemID.AIR);

    public AnvilInventory(PlayerUIInventory playerUI, Position position) {
        super(playerUI, InventoryType.ANVIL, OFFSET, position);
    }

    @Override
    public void onSlotChange(int index, Item before, boolean send) {
        try {
            if (index <= 1) {
                updateResult();
            }
        } finally {
            super.onSlotChange(index, before, send);
        }
    }

    @Deprecated
    @DeprecationDetails(since = "1.4.0.0-PN", by = "PowerNukkit", reason = "Experimenting the new implementation by Nukkit")
    @PowerNukkitOnly
    public void updateResult() {
        Item target = getFirstItem();
        Item sacrifice = getSecondItem();

        if (target.isNull() && sacrifice.isNull()) {
            setResult(Item.get(ItemID.AIR));
            setLevelCost(0);
            return;
        }

        setLevelCost(1);
        int extraCost = 0;
        int costHelper = 0;
        ItemID repairMaterial = getRepairMaterial(target);
        Item result = target.clone();
        int levelCost = getRepairCost(result) + (sacrifice.isNull() ? 0 : getRepairCost(sacrifice));
        Map<Integer, Enchantment> enchantmentMap = new LinkedHashMap<>();
        for (Enchantment enchantment : target.getEnchantments()) {
            enchantmentMap.put(enchantment.getId(), enchantment);
        }
        if (!sacrifice.isNull()) {
            boolean enchantedBook = sacrifice.getIdentifier() == ItemID.ENCHANTED_BOOK && sacrifice.getEnchantments().length > 0;
            int repair;
            int repair2;
            int repair3;
            if (result.getMaxDurability() != -1 && sacrifice.getIdentifier() == repairMaterial) {
                repair = Math.min(result.getDamage(), result.getMaxDurability() / 4);
                if (repair <= 0) {
                    setResult(Item.get(ItemID.AIR));
                    setLevelCost(0);
                    return;
                }

                for (repair2 = 0; repair > 0 && repair2 < sacrifice.getCount(); ++repair2) {
                    repair3 = result.getDamage() - repair;
                    result.setDamage(repair3);
                    ++extraCost;
                    repair = Math.min(result.getDamage(), result.getMaxDurability() / 4);
                }

            } else {
                if (!enchantedBook && (result.getIdentifier() != sacrifice.getIdentifier() || result.getMaxDurability() == -1)) {
                    setResult(Item.get(ItemID.AIR));
                    setLevelCost(0);
                    return;
                }

                if ((result.getMaxDurability() != -1) && !enchantedBook) {
                    repair = target.getMaxDurability() - target.getDamage();
                    repair2 = sacrifice.getMaxDurability() - sacrifice.getDamage();
                    repair3 = repair2 + result.getMaxDurability() * 12 / 100;
                    int totalRepair = repair + repair3;
                    int finalDamage = result.getMaxDurability() - totalRepair + 1;
                    if (finalDamage < 0) {
                        finalDamage = 0;
                    }

                    if (finalDamage < result.getDamage()) {
                        result.setDamage(finalDamage);
                        extraCost += 2;
                    }
                }

                Enchantment[] sacrificeEnchantments = sacrifice.getEnchantments();
                boolean compatibleFlag = false;
                boolean incompatibleFlag = false;
                Iterator<Enchantment> sacrificeEnchIter = Arrays.stream(sacrificeEnchantments).iterator();

                iter:
                while (true) {
                    Enchantment sacrificeEnchantment;
                    do {
                        if (!sacrificeEnchIter.hasNext()) {
                            if (incompatibleFlag && !compatibleFlag) {
                                setResult(Item.get(ItemID.AIR));
                                setLevelCost(0);
                                return;
                            }
                            break iter;
                        }

                        sacrificeEnchantment = sacrificeEnchIter.next();
                    } while (sacrificeEnchantment == null);

                    Enchantment resultEnchantment = result.getEnchantment(sacrificeEnchantment.id);
                    int targetLevel = resultEnchantment != null ? resultEnchantment.getLevel() : 0;
                    int resultLevel = sacrificeEnchantment.getLevel();
                    resultLevel = targetLevel == resultLevel ? resultLevel + 1 : Math.max(resultLevel, targetLevel);
                    boolean compatible = sacrificeEnchantment.isItemAcceptable(target);
                    if (playerUI.getHolder().isCreative() || target.getIdentifier() == ItemID.ENCHANTED_BOOK) {
                        compatible = true;
                    }

                    Iterator<Enchantment> targetEnchIter = Stream.of(target.getEnchantments()).iterator();

                    while (targetEnchIter.hasNext()) {
                        Enchantment targetEnchantment = targetEnchIter.next();
                        if (targetEnchantment.id != sacrificeEnchantment.id && (!sacrificeEnchantment.isCompatibleWith(targetEnchantment) || !targetEnchantment.isCompatibleWith(sacrificeEnchantment))) {
                            compatible = false;
                            ++extraCost;
                        }
                    }

                    if (!compatible) {
                        incompatibleFlag = true;
                    } else {
                        compatibleFlag = true;
                        if (resultLevel > sacrificeEnchantment.getMaxLevel()) {
                            resultLevel = sacrificeEnchantment.getMaxLevel();
                        }

                        enchantmentMap.put(sacrificeEnchantment.getId(), Enchantment.getEnchantment(sacrificeEnchantment.getId()).setLevel(resultLevel));
                        int rarity = 0;
                        int weight = sacrificeEnchantment.getWeight();
                        if (weight >= 10) {
                            rarity = 1;
                        } else if (weight >= 5) {
                            rarity = 2;
                        } else if (weight >= 2) {
                            rarity = 4;
                        } else {
                            rarity = 8;
                        }

                        if (enchantedBook) {
                            rarity = Math.max(1, rarity / 2);
                        }

                        extraCost += rarity * Math.max(0, resultLevel - targetLevel);
                        if (target.getCount() > 1) {
                            extraCost = 40;
                        }
                    }
                }
            }
        }

        if (StringUtil.isNullOrEmpty(this.newItemName)) {
            if (target.hasCustomName()) {
                costHelper = 1;
                extraCost += costHelper;
                result.clearCustomName();
            }
        } else {
            costHelper = 1;
            extraCost += costHelper;
            result.setCustomName(this.newItemName);
        }

        setLevelCost(levelCost + extraCost);
        if (extraCost <= 0) {
            result = Item.get(ItemID.AIR);
        }

        if (costHelper == extraCost && costHelper > 0 && getLevelCost() >= 40) {
            setLevelCost(39);
        }

        if (getLevelCost() >= 40 && !this.playerUI.getHolder().isCreative()) {
            result = Item.get(ItemID.AIR);
        }

        if (!result.isNull()) {
            int repairCost = getRepairCost(result);
            if (!sacrifice.isNull() && repairCost < getRepairCost(sacrifice)) {
                repairCost = getRepairCost(sacrifice);
            }

            if (costHelper != extraCost || costHelper == 0) {
                repairCost = repairCost * 2 + 1;
            }

            CompoundTag namedTag = result.getNamedTag();
            if (namedTag == null) {
                namedTag = new CompoundTag();
            }
            namedTag.putInt("RepairCost", repairCost);
            namedTag.remove("ench");
            result.setNamedTag(namedTag);
            if (!enchantmentMap.isEmpty()) {
                result.addEnchantment(enchantmentMap.values().toArray(Enchantment.EMPTY_ARRAY));
            }
        }
        setResult(result);
    }

    @Override
    public void onClose(Player who) {
        super.onClose(who);
        who.craftingType = Player.CRAFTING_SMALL;

        Item[] drops = new Item[]{getFirstItem(), getSecondItem()};
        drops = who.getInventory().addItem(drops);
        for (Item drop : drops) {
            if (!who.dropItem(drop)) {
                this.getHolder().getLevel().dropItem(this.getHolder().add(0.5, 0.5, 0.5), drop);
            }
        }

        clear(TARGET);
        clear(SACRIFICE);

        who.resetCraftingGridType();
    }

    @Override
    public void onOpen(Player who) {
        super.onOpen(who);
        who.craftingType = Player.CRAFTING_ANVIL;
    }

    @Override
    public Item getItem(int index) {
        if (index < 0 || index > 3) {
            return Item.get(ItemID.AIR);
        }
        if (index == 2) {
            return getResult();
        }

        return super.getItem(index);
    }

    @Override
    public boolean setItem(int index, Item item, boolean send) {
        if (index < 0 || index > 3) {
            return false;
        }

        if (index == 2) {
            return setResult(item);
        }

        return super.setItem(index, item, send);
    }

    @PowerNukkitOnly
    @Deprecated
    @DeprecationDetails(
            reason = "NukkitX added the samething with other name.",
            by = "PowerNukkit", since = "1.4.0.0-PN",
            replaceWith = "getInputSlot()"
    )
    public Item getFirstItem() {
        return getItem(TARGET);
    }

    @Since("1.4.0.0-PN")
    public Item getInputSlot() {
        return this.getItem(TARGET);
    }

    @PowerNukkitOnly
    @Deprecated
    @DeprecationDetails(
            reason = "NukkitX added the samething with other name.",
            by = "PowerNukkit", since = "1.4.0.0-PN",
            replaceWith = "getMaterialSlot()"
    )
    public Item getSecondItem() {
        return getItem(SACRIFICE);
    }

    @Since("1.4.0.0-PN")
    public Item getMaterialSlot() {
        return this.getItem(SACRIFICE);
    }

    @PowerNukkitOnly
    @Deprecated
    @DeprecationDetails(
            reason = "NukkitX added the samething with other name.",
            by = "PowerNukkit", since = "1.4.0.0-PN",
            replaceWith = "getOutputSlot()"
    )
    public Item getResult() {
        //return currentResult.clone();
        return getOutputSlot();
    }

    @Since("1.4.0.0-PN")
    public Item getOutputSlot() {
        return this.getItem(RESULT);
    }

    @Override
    public void sendContents(Player... players) {
        super.sendContents(players);
        // Fixes desync when transactions are cancelled.
        for (Player player : players) {
            player.sendExperienceLevel();
        }
    }

    @PowerNukkitOnly
    public boolean setFirstItem(Item item, boolean send) {
        return setItem(SACRIFICE, item, send);
    }

    @PowerNukkitOnly
    public boolean setFirstItem(Item item) {
        return setFirstItem(item, true);
    }

    @PowerNukkitOnly
    public boolean setSecondItem(Item item, boolean send) {
        return setItem(SACRIFICE, item, send);
    }

    @PowerNukkitOnly
    public boolean setSecondItem(Item item) {
        return setSecondItem(item, true);
    }

    private boolean setResult(Item item, boolean send) {
        return setItem(2, item, send);
    }

    private boolean setResult(Item item) {
        if (item == null || item.isNull()) {
            this.currentResult = Item.get(ItemID.AIR);
        } else {
            this.currentResult = item.clone();
        }
        return true;
    }

    private static int getRepairCost(Item item) {
        return item.hasCompoundTag() && item.getNamedTag().contains("RepairCost") ? item.getNamedTag().getInt("RepairCost") : 0;
    }

    @PowerNukkitOnly
    @Deprecated
    @DeprecationDetails(
            reason = "NukkitX added the samething with other name.",
            by = "PowerNukkit", since = "1.4.0.0-PN",
            replaceWith = "getCost()"
    )
    public int getLevelCost() {
        return getCost();
    }

    @PowerNukkitOnly
    @Deprecated
    @DeprecationDetails(
            reason = "NukkitX added the samething with other name.",
            by = "PowerNukkit", since = "1.4.0.0-PN",
            replaceWith = "setCost(int)"
    )
    protected void setLevelCost(int levelCost) {
        setCost(levelCost);
    }

    @Since("1.4.0.0-PN")
    public int getCost() {
        return this.cost;
    }

    @Since("1.4.0.0-PN")
    public void setCost(int cost) {
        this.cost = cost;
    }

    @PowerNukkitOnly
    public String getNewItemName() {
        return newItemName;
    }

    @PowerNukkitOnly
    public void setNewItemName(String newItemName) {
        this.newItemName = newItemName;
    }

    private static final List<ItemID> leatherPieces = Arrays.asList(ItemID.LEATHER_HELMET, ItemID.LEATHER_CHESTPLATE, ItemID.LEATHER_LEGGINGS, ItemID.LEATHER_BOOTS);
    private static final List<ItemID> woodenTools = Arrays.asList(ItemID.WOODEN_SWORD, ItemID.WOODEN_AXE, ItemID.WOODEN_PICKAXE, ItemID.WOODEN_SHOVEL, ItemID.WOODEN_HOE);
    private static final List<ItemID> ironChainPieces = Arrays.asList(ItemID.IRON_SWORD, ItemID.IRON_PICKAXE, ItemID.IRON_SHOVEL, ItemID.IRON_AXE, ItemID.IRON_HOE, ItemID.IRON_HELMET,
            ItemID.IRON_CHESTPLATE, ItemID.IRON_LEGGINGS, ItemID.IRON_BOOTS, ItemID.CHAINMAIL_HELMET, ItemID.CHAINMAIL_CHESTPLATE, ItemID.CHAINMAIL_LEGGINGS, ItemID.CHAINMAIL_BOOTS);
    private static final List<ItemID> goldPieces = Arrays.asList(ItemID.GOLDEN_SWORD, ItemID.GOLDEN_PICKAXE, ItemID.GOLDEN_SHOVEL, ItemID.GOLDEN_AXE, ItemID.GOLDEN_HOE, ItemID.GOLDEN_HELMET,
            ItemID.GOLDEN_CHESTPLATE, ItemID.GOLDEN_LEGGINGS, ItemID.GOLDEN_BOOTS);
    private static final List<ItemID> diamondPieces = Arrays.asList(ItemID.DIAMOND_SWORD, ItemID.DIAMOND_PICKAXE, ItemID.DIAMOND_SHOVEL, ItemID.DIAMOND_AXE, ItemID.DIAMOND_HOE,
            ItemID.DIAMOND_HELMET, ItemID.DIAMOND_CHESTPLATE, ItemID.DIAMOND_LEGGINGS, ItemID.DIAMOND_BOOTS);
    private static final List<ItemID> netheritePieces = Arrays.asList(ItemID.NETHERITE_SWORD, ItemID.NETHERITE_PICKAXE, ItemID.NETHERITE_AXE, ItemID.NETHERITE_SHOVEL, ItemID.NETHERITE_HOE,
            ItemID.NETHERITE_HELMET, ItemID.NETHERITE_CHESTPLATE, ItemID.NETHERITE_LEGGINGS, ItemID.NETHERITE_BOOTS);
    private static final List<ItemID> stoneTools = Arrays.asList(ItemID.STONE_SWORD, ItemID.STONE_PICKAXE, ItemID.STONE_AXE, ItemID.STONE_SHOVEL, ItemID.STONE_HOE);

    public static ItemID getRepairMaterial(Item target) {
        if (woodenTools.contains(target.getIdentifier())) {
            return ItemID.PLANKS;
        }

        if (leatherPieces.contains(target.getIdentifier())) {
            return ItemID.LEATHER;
        }

        if (diamondPieces.contains(target.getIdentifier())) {
            return ItemID.DIAMOND;
        }

        if (goldPieces.contains(target.getIdentifier())) {
            return ItemID.GOLD_INGOT;
        }

        if (ironChainPieces.contains(target.getIdentifier())) {
            return ItemID.IRON_INGOT;
        }

        if (netheritePieces.contains(target.getIdentifier())) {
            return ItemID.NETHERITE_INGOT;
        }

        if (stoneTools.contains(target.getIdentifier())) {
            return ItemID.COBBLESTONE;
        }

        // special cases
        if (target.getIdentifier().equals(ItemID.TURTLE_HELMET)) {
            return ItemID.SCUTE;
        }

        if (target.getIdentifier().equals(ItemID.ELYTRA)) {
            return ItemID.PHANTOM_MEMBRANE;
        }

        if (target.getIdentifier().equals(ItemID.SHEARS) || target.getIdentifier().equals(ItemID.BOW) ||
                target.getIdentifier().equals(ItemID.CROSSBOW)) {
            return target.getIdentifier();
        }

        return ItemID.AIR;
    }
}

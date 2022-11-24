package cn.nukkit.inventory.transaction;

import cn.nukkit.Player;
import cn.nukkit.inventory.CraftingRecipe;
import cn.nukkit.inventory.InventoryType;
import cn.nukkit.inventory.transaction.action.InventoryAction;
import cn.nukkit.inventory.transaction.action.SlotChangeAction;
import cn.nukkit.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
@Getter
public class CraftItemStackTransaction extends InventoryTransaction {

    private final CraftingRecipe recipe;
    @Setter
    private Item primaryOutput;
    @Getter
    private final List<Item> extraOutputs = new ArrayList<>();

    public CraftItemStackTransaction(Player source, CraftingRecipe recipe) {
        super(source, new ArrayList<>(), true);

        this.recipe = recipe;
    }

    public void setExtraOutput(int slot, Item item) {
        this.extraOutputs.add(slot, item);
    }

    public Item getPrimaryOutput() {
        return this.primaryOutput == null ? this.recipe.getResult() : this.primaryOutput;
    }

    @Override
    public boolean canExecute() {
        if (this.getActions().isEmpty()) {
            return false;
        }

        for (InventoryAction action : this.getActions()) {
            if (!action.isValid(this.getSource())) {
                for (InventoryAction inventoryAction : this.getActions()) {
                    inventoryAction.onExecuteFail(this.getSource());
                }

                return false;
            }
        }

        return true;
    }

    @Override
    public boolean execute() {
        if (super.execute()) {
            this.getSource().getUIInventory().clearAll();
            this.sendInventories();

            return true;
        }

        return false;
    }

    public boolean checkForCraftingPart(List<InventoryAction> actions) {
        for (InventoryAction action : actions) {
            if (action instanceof SlotChangeAction) {
                SlotChangeAction slotChangeAction = (SlotChangeAction) action;
                if (slotChangeAction.getInventory().getType() == InventoryType.UI && slotChangeAction.getSlot() == 50 &&
                        !slotChangeAction.getSourceItem().equals(slotChangeAction.getTargetItem())) {
                    return true;
                }
            }
        }

        return false;
    }
}
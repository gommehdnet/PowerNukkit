package cn.nukkit.blockentity;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.inventory.InventoryType;
import cn.nukkit.inventory.SmeltingRecipe;
import cn.nukkit.item.Item;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

@PowerNukkitOnly
public class BlockEntityBlastFurnace extends BlockEntityFurnace {
    @PowerNukkitOnly
    public BlockEntityBlastFurnace(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @PowerNukkitOnly
    @Override
    protected String getFurnaceName() {
        return "Blast Furnace";
    }

    @PowerNukkitOnly
    @Override
    protected String getClientName() {
        return BLAST_FURNACE;
    }

    @PowerNukkitOnly
    @Override
    protected BlockID getIdleBlockId() {
        return BlockID.BLAST_FURNACE;
    }

    @PowerNukkitOnly
    @Override
    protected BlockID getBurningBlockId() {
        return BlockID.LIT_BLAST_FURNACE;
    }

    @PowerNukkitOnly
    @Override
    protected InventoryType getInventoryType() {
        return InventoryType.BLAST_FURNACE;
    }

    @PowerNukkitOnly
    @Override
    protected SmeltingRecipe matchRecipe(Item raw) {
        return this.server.getCraftingManager().matchBlastFurnaceRecipe(raw);
    }

    @PowerNukkitOnly
    @Override
    protected int getSpeedMultiplier() {
        return 2;
    }
}

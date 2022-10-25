package cn.nukkit.level;

import cn.nukkit.api.DeprecationDetails;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.blockstate.BlockStateRegistry;
import lombok.extern.log4j.Log4j2;

@Deprecated
@DeprecationDetails(reason = "Reimplemented using BlockState", replaceWith = "BlockStateRegistry", since = "1.4.0.0-PN")
@Log4j2
public class GlobalBlockPalette {
    @Deprecated
    @DeprecationDetails(reason = "Public mutable array", replaceWith = "BlockStateRegistry.getBlockPaletteBytes() or BlockStateRegistry.copyBlockPaletteBytes()", since = "1.4.0.0-PN")
    @PowerNukkitOnly
    public static final byte[] BLOCK_PALETTE = BlockStateRegistry.getBlockPaletteBytes();

    @Deprecated
    @DeprecationDetails(reason = "Limited to 32 bits meta", since = "1.4.0.0-PN", replaceWith = "BlockStateRegistry.getRuntimeId(BlockState)")
    public static int getOrCreateRuntimeId(BlockID id, int meta) {
        return BlockStateRegistry.getRuntimeId(id, meta);
    }
}

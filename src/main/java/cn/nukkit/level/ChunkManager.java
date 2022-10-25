package cn.nukkit.level;

import cn.nukkit.api.DeprecationDetails;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.BlockID;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.level.format.generic.BaseFullChunk;
import cn.nukkit.math.ChunkVector2;

import javax.annotation.Nonnull;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public interface ChunkManager {

    @PowerNukkitOnly
    BlockID getBlockIdAt(int x, int y, int z, int layer);
    BlockID getBlockIdAt(int x, int y, int z);

    @PowerNukkitOnly
    void setBlockIdAt(int x, int y, int z, int layer, BlockID id);
    void setBlockIdAt(int x, int y, int z, BlockID id);

    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", since = "1.4.0.0-PN")
    @PowerNukkitOnly
    boolean setBlockAtLayer(int x, int y, int z, int layer, BlockID id);

    default void setBlockAt(int x, int y, int z, BlockID id) {
        setBlockStateAt(x, y, z, BlockState.of(id));
    }
    
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    boolean setBlockStateAt(int x, int y, int z, int layer, BlockState state);
    
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    default boolean setBlockStateAt(int x, int y, int z, BlockState state) {
        return setBlockStateAt(x, y, z, 0, state);
    }
    
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    BlockState getBlockStateAt(int x, int y, int z, int layer);
    
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    default BlockState getBlockStateAt(int x, int y, int z) {
        return getBlockStateAt(x, y, z, 0);
    }

    BaseFullChunk getChunk(int chunkX, int chunkZ);

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    default BaseFullChunk getChunk(@Nonnull ChunkVector2 pos) {
        return getChunk(pos.getX(), pos.getZ());
    }

    void setChunk(int chunkX, int chunkZ);

    void setChunk(int chunkX, int chunkZ, BaseFullChunk chunk);

    long getSeed();

    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", since = "1.4.0.0-PN")
    @PowerNukkitOnly
    int getBlockDataAt(int x, int y, int z, int layer);

    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", since = "1.4.0.0-PN")
    int getBlockDataAt(int x, int y, int z);

    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", since = "1.4.0.0-PN")
    @PowerNukkitOnly
    void setBlockDataAt(int x, int y, int z, int layer, int data);

    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", since = "1.4.0.0-PN")
    void setBlockDataAt(int x, int y, int z, int data);
}

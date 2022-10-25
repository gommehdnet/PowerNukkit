package cn.nukkit.level;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.level.format.generic.BaseFullChunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Since("1.4.0.0-PN")
public class ListChunkManager implements ChunkManager {

    private ChunkManager parent;
    private List<Block> blocks;

    @Since("1.4.0.0-PN")
    public ListChunkManager(ChunkManager parent) {
        this.parent = parent;
        this.blocks = new ArrayList<>();
    }

    @Override
    public BlockID getBlockIdAt(int x, int y, int z) {
        return getBlockIdAt(x, y, z, 0);
    }

    private Optional<Block> findBlockAt(int x, int y, int z, int layer) {
        return this.blocks.stream().filter(block ->
                block.getFloorX() == x
                        && block.getFloorY() == y
                        && block.getFloorZ() == z
                        && block.layer == layer
        ).findAny();
    }

    @PowerNukkitOnly
    @Override
    public BlockID getBlockIdAt(int x, int y, int z, int layer) {
        return findBlockAt(x, y, z, layer).map(Block::getId).orElseGet(() -> this.parent.getBlockIdAt(x, y, z, layer));
    }

    @Override
    public void setBlockIdAt(int x, int y, int z, BlockID id) {
        setBlockIdAt(x, y, z, 0, id);
    }

    @PowerNukkitOnly
    @Override
    public void setBlockIdAt(int x, int y, int z, int layer, BlockID id) {
        Optional<Block> optionalBlock = this.blocks.stream().filter(block -> block.getFloorX() == x && block.getFloorY() == y && block.getFloorZ() == z && block.layer == layer).findAny();
        Block block = optionalBlock.orElse(Block.get(this.getBlockIdAt(x, y, z, layer), this.getBlockDataAt(x, y, z, layer), new Position(x, y, z), layer));
        this.blocks.remove(block);
        this.blocks.add(Block.get(this.getBlockIdAt(x, y, z, layer), this.getBlockDataAt(x, y, z, layer), new Position(x, y, z), layer));
    }

    @Override
    public void setBlockAt(int x, int y, int z, BlockID id) {
        this.blocks.removeIf(block -> block.getFloorX() == x && block.getFloorY() == y && block.getFloorZ() == z && block.layer == 0);
        this.blocks.add(Block.get(id, this.getBlockDataAt(x, y, z), new Position(x, y, z), 0));
    }

    @PowerNukkitOnly
    @Override
    public boolean setBlockAtLayer(int x, int y, int z, int layer, BlockID id) {
        boolean removed = this.blocks.removeIf(block -> block.getFloorX() == x && block.getFloorY() == y && block.getFloorZ() == z && block.layer == layer);
        this.blocks.add(Block.get(id, this.getBlockDataAt(x, y, z), new Position(x, y, z), layer));
        return !removed;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public boolean setBlockStateAt(int x, int y, int z, int layer, BlockState state) {
        boolean removed = this.blocks.removeIf(block -> block.getFloorX() == x && block.getFloorY() == y && block.getFloorZ() == z && block.layer == layer);
        this.blocks.add(state.getBlock(new Position(x, y, z), layer));
        return !removed;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockState getBlockStateAt(int x, int y, int z, int layer) {
        return findBlockAt(x, y, z, layer).map(Block::getCurrentState).orElseGet(() -> parent.getBlockStateAt(x, y, z, layer));
    }

    @Override
    public int getBlockDataAt(int x, int y, int z) {
        return getBlockDataAt(x, y, z, 0);
    }

    @PowerNukkitOnly
    @Override
    public int getBlockDataAt(int x, int y, int z, int layer) {
        Optional<Block> optionalBlock = this.blocks.stream().filter(block -> block.getFloorX() == x && block.getFloorY() == y && block.getFloorZ() == z && block.layer == layer).findAny();
        return optionalBlock.map(Block::getDamage).orElseGet(() -> this.parent.getBlockDataAt(x, y, z, layer));
    }

    @Override
    public void setBlockDataAt(int x, int y, int z, int data) {
        setBlockDataAt(x, y, z, 0, data);
    }

    @PowerNukkitOnly
    @Override
    public void setBlockDataAt(int x, int y, int z, int layer, int data) {
        Optional<Block> optionalBlock = this.blocks.stream().filter(block -> block.getFloorX() == x && block.getFloorY() == y && block.getFloorZ() == z && block.layer == layer).findAny();
        Block block = optionalBlock.orElse(Block.get(this.getBlockIdAt(x, y, z, layer), this.getBlockDataAt(x, y, z, layer), new Position(x, y, z), layer));
        this.blocks.remove(block);
        block.setDamage(data);
        this.blocks.add(block);
    }

    @Override
    public BaseFullChunk getChunk(int chunkX, int chunkZ) {
        return this.parent.getChunk(chunkX, chunkZ);
    }

    @Override
    public void setChunk(int chunkX, int chunkZ) {
        this.parent.setChunk(chunkX, chunkZ);
    }

    @Override
    public void setChunk(int chunkX, int chunkZ, BaseFullChunk chunk) {
        this.parent.setChunk(chunkX, chunkZ, chunk);
    }

    @Override
    public long getSeed() {
        return this.parent.getSeed();
    }

    @Since("1.4.0.0-PN")
    public List<Block> getBlocks() {
        return this.blocks;
    }

}

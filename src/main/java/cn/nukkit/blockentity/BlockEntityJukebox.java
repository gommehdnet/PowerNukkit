package cn.nukkit.blockentity;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.block.BlockID;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemMusicDisc;
import cn.nukkit.level.Sound;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.LevelSoundEventPacket;

import java.util.Objects;

/**
 * @author CreeperFace
 */
public class BlockEntityJukebox extends BlockEntitySpawnable {

    private Item recordItem;

    public BlockEntityJukebox(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    protected void initBlockEntity() {
        if (namedTag.contains("RecordItem")) {
            this.recordItem = NBTIO.getItemHelper(namedTag.getCompound("RecordItem"));
        } else {
            this.recordItem = Item.get(ItemID.AIR);
        }

        super.initBlockEntity();
    }

    @Override
    public boolean isBlockEntityValid() {
        return this.getLevel().getBlockIdAt(getFloorX(), getFloorY(), getFloorZ()) == BlockID.JUKEBOX;
    }

    public void setRecordItem(Item recordItem) {
        Objects.requireNonNull(recordItem, "Record item cannot be null");
        this.recordItem = recordItem;
    }

    public Item getRecordItem() {
        return recordItem;
    }

    @PowerNukkitDifference(info = "Using new method to play sounds", since = "1.4.0.0-PN")
    public void play() {
        if (this.recordItem instanceof ItemMusicDisc) {
            if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_13)) {
                this.getLevel().addSound(this, Sound.RECORD_13);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_CAT)) {
                this.getLevel().addSound(this, Sound.RECORD_CAT);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_BLOCKS)) {
                this.getLevel().addSound(this, Sound.RECORD_BLOCKS);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_CHIRP)) {
                this.getLevel().addSound(this, Sound.RECORD_CHIRP);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_FAR)) {
                this.getLevel().addSound(this, Sound.RECORD_FAR);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_MALL)) {
                this.getLevel().addSound(this, Sound.RECORD_MALL);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_MELLOHI)) {
                this.getLevel().addSound(this, Sound.RECORD_MELLOHI);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_STAL)) {
                this.getLevel().addSound(this, Sound.RECORD_STAL);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_STRAD)) {
                this.getLevel().addSound(this, Sound.RECORD_STRAD);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_WARD)) {
                this.getLevel().addSound(this, Sound.RECORD_WARD);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_11)) {
                this.getLevel().addSound(this, Sound.RECORD_11);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_WAIT)) {
                this.getLevel().addSound(this, Sound.RECORD_WAIT);
            } else if (this.recordItem.getIdentifier().equals(ItemID.MUSIC_DISC_PIGSTEP)) {
                this.getLevel().addSound(this, Sound.RECORD_PIGSTEP);
            }
        }
    }

    //TODO: Transfer the stop sound to the new sound method
    public void stop() {
        this.getLevel().addLevelSoundEvent(this, LevelSoundEventPacket.SOUND_STOP_RECORD);
    }

    public void dropItem() {
        if (this.recordItem.getIdentifier() != ItemID.AIR) {
            stop();
            this.level.dropItem(this.up(), this.recordItem);
            this.recordItem = Item.get(ItemID.AIR);
        }
    }

    @Override
    public void saveNBT() {
        super.saveNBT();
        this.namedTag.putCompound("RecordItem", NBTIO.putItemHelper(this.recordItem));
    }

    @Override
    public CompoundTag getSpawnCompound() {
        return getDefaultCompound(this, JUKEBOX)
                .putCompound("RecordItem", NBTIO.putItemHelper(this.recordItem));
    }

    @Override
    public void onBreak() {
        this.dropItem();
    }
}

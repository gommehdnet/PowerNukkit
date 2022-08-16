package cn.nukkit.entity.passive;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.EntityInteractable;
import cn.nukkit.entity.EntityLiving;
import cn.nukkit.entity.data.ByteEntityData;
import cn.nukkit.entity.data.IntEntityData;
import cn.nukkit.entity.data.StringEntityData;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.form.window.FormWindowDialogue;
import cn.nukkit.item.Item;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author good777LUCKY
 */
@Since("1.4.0.0-PN")
@PowerNukkitOnly
public class EntityNPCEntity extends EntityLiving implements EntityNPC, EntityInteractable {

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public static final int NETWORK_ID = 51;

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public EntityNPCEntity(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public float getHeight() {
        return 2.1f;
    }

    @Override
    public boolean canDoInteraction() {
        return true;
    }

    @Override
    public String getInteractButtonText() {
        return "action.interact.edit";
    }

    @PowerNukkitOnly
    @Since("1.5.1.0-PN")
    @Override
    public String getOriginalName() {
        return "NPC";
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.setMaxHealth(Integer.MAX_VALUE); // Should be Float max value
        this.setHealth(20);
        this.setNameTagVisible(true);
        this.setNameTagAlwaysVisible(true);
        this.setDataProperty(new ByteEntityData(EntityNPCEntity.DATA_HAS_NPC_COMPONENT, 0x01));

        if (this.namedTag.getString("CustomName").isEmpty()) {
            this.setNameTag("NPC");
        }

        this.setDataProperty(new StringEntityData(EntityNPCEntity.DATA_NPC_SKIN_ID, "{\"picker_offsets\":{\"scale\":[1.70,1.70,1.70],\"translate\":[0,20,0]},\"portrait_offsets\":{\"scale\":[1.750,1.750,1.750],\"translate\":[-7,50,0]},\"skin_list\":[{\"variant\":0},{\"variant\":1},{\"variant\":2},{\"variant\":3},{\"variant\":4},{\"variant\":5},{\"variant\":6},{\"variant\":7},{\"variant\":8},{\"variant\":9},{\"variant\":10},{\"variant\":11},{\"variant\":12},{\"variant\":13},{\"variant\":14},{\"variant\":15},{\"variant\":16},{\"variant\":17},{\"variant\":18},{\"variant\":19},{\"variant\":20},{\"variant\":21},{\"variant\":22},{\"variant\":23},{\"variant\":24},{\"variant\":25},{\"variant\":26},{\"variant\":27},{\"variant\":28},{\"variant\":29},{\"variant\":30},{\"variant\":31},{\"variant\":32},{\"variant\":33},{\"variant\":34}]}"));
        this.variant(Variant.values()[this.namedTag.getInt("Variant")]);
    }

    public void variant(Variant variant) {
        this.setDataProperty(new IntEntityData(EntityNPCEntity.DATA_VARIANT, variant.ordinal()));
    }

    public Variant variant() {
        return Variant.values()[this.getDataPropertyInt(EntityNPCEntity.DATA_VARIANT)];
    }

    @Override
    public void saveNBT() {
        super.saveNBT();

        this.namedTag.putInt("Variant", this.variant().ordinal());
        this.namedTag.putString("Dialogue", this.getDataPropertyString(EntityNPCEntity.DATA_INTERACTIVE_TAG));
    }

    @PowerNukkitDifference(info = "Using new method to play sounds", since = "1.4.0.0-PN")
    @Override
    public boolean attack(EntityDamageEvent source) {
        if (source instanceof EntityDamageByEntityEvent && ((EntityDamageByEntityEvent) source).getDamager() instanceof Player) {
            Player player = (Player) ((EntityDamageByEntityEvent) source).getDamager();

            if (player.getGamemode() == 1) {
                this.close();
            }
        }

        return false;
    }

    @Override
    public boolean onInteract(Player player, Item item) {
        if (player.getOpenDialogue().isPresent() && player.getOpenDialogue().get().entity().getId() == this.getId()) {
            player.getOpenDialogue().get().create(player);
        } else {
            new FormWindowDialogue()
                    .title(this.getNameTag())
                    .dialogue(this.namedTag.getString("Dialogue"))
                    .entity(this)
                    .create(player);
        }

        return true;
    }

    public enum Variant {
        NPC_1,
        NPC_2,
        NPC_3,
        NPC_4,
        NPC_5,
        NPC_6,
        NPC_7,
        NPC_8,
        NPC_9,
        NPC_10,
        NPC_SCIENTIST_1,
        NPC_SCIENTIST_2,
        NPC_SCIENTIST_3,
        NPC_SCIENTIST_4,
        NPC_SCIENTIST_5,
        NPC_SCIENTIST_6,
        NPC_SCIENTIST_7,
        NPC_SCIENTIST_8,
        NPC_SCIENTIST_9,
        NPC_SCIENTIST_10,
        NPC_APIARY_1,
        NPC_APIARY_2,
        NPC_APIARY_3,
        NPC_APIARY_4,
        NPC_APIARY_5,
        NPC_TEACHER_1,
        NPC_TEACHER_2,
        NPC_TEACHER_3,
        NPC_TEACHER_4,
        NPC_TEACHER_5,
        NPC_CONSTRUCTION_1,
        NPC_CONSTRUCTION_2,
        NPC_CONSTRUCTION_3,
        NPC_CONSTRUCTION_4,
        NPC_CONSTRUCTION_5
    }
}
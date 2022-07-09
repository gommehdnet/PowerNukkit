package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.AbilityLayer;
import cn.nukkit.network.protocol.types.CommandPermission;
import cn.nukkit.network.protocol.types.PlayerAbilityHolder;
import cn.nukkit.network.protocol.types.PlayerPermission;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class UpdateAbilitiesPacket extends DataPacket implements PlayerAbilityHolder {

    private long uniqueEntityId;
    private PlayerPermission playerPermission;
    private CommandPermission commandPermission;
    private List<AbilityLayer> abilityLayers = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.UPDATE_ABILITIES_PACKET;
    }

    @Override
    public void decode() {
        this.getPlayerAbilities(this);
    }

    @Override
    public void encode() {
        this.reset();
        this.putPlayerAbilities(this);
    }

    @Override
    public long getUniqueEntityId() {
        return this.uniqueEntityId;
    }

    @Override
    public void setUniqueEntityId(long uniqueEntityId) {
        this.uniqueEntityId = uniqueEntityId;
    }

    @Override
    public PlayerPermission getPlayerPermission() {
        return this.playerPermission;
    }

    @Override
    public void setPlayerPermission(PlayerPermission playerPermission) {
        this.playerPermission = playerPermission;
    }

    @Override
    public CommandPermission getCommandPermission() {
        return this.commandPermission;
    }

    @Override
    public void setCommandPermission(CommandPermission commandPermission) {
        this.commandPermission = commandPermission;
    }

    @Override
    public List<AbilityLayer> getAbilityLayers() {
        return this.abilityLayers;
    }

    @Override
    public void setAbilityLayers(List<AbilityLayer> abilityLayers) {
        this.abilityLayers = abilityLayers;
    }
}
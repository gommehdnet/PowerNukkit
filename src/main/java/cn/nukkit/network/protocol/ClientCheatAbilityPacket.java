package cn.nukkit.network.protocol;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.network.protocol.types.AbilityLayer;
import cn.nukkit.network.protocol.types.PlayerAbilityHolder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ClientCheatAbilityPacket extends DataPacket implements PlayerAbilityHolder {

    public long uniqueEntityId;
    public int playerPermission = Player.PERMISSION_MEMBER;
    public int commandPermission = AdventureSettings.PERMISSION_NORMAL;
    public List<AbilityLayer> abilityLayers = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.CLIENT_CHEAT_ABILITY_PACKET;
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
    public int getPlayerPermission() {
        return this.playerPermission;
    }

    @Override
    public void setPlayerPermission(int playerPermission) {
        this.playerPermission = playerPermission;
    }

    @Override
    public int getCommandPermission() {
        return this.commandPermission;
    }

    @Override
    public void setCommandPermission(int commandPermission) {
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
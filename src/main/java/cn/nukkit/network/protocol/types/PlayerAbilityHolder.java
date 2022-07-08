package cn.nukkit.network.protocol.types;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public interface PlayerAbilityHolder {

    long getUniqueEntityId();

    void setUniqueEntityId(long uniqueEntityId);

    PlayerPermission getPlayerPermission();

    void setPlayerPermission(PlayerPermission playerPermission);

    CommandPermission getCommandPermission();

    void setCommandPermission(CommandPermission commandPermission);

    List<AbilityLayer> getAbilityLayers();

    void setAbilityLayers(final List<AbilityLayer> abilityLayers);
}
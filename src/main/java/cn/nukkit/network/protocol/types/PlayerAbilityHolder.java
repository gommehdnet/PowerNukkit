package cn.nukkit.network.protocol.types;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public interface PlayerAbilityHolder {

    long getUniqueEntityId();

    void setUniqueEntityId(long uniqueEntityId);

    int getPlayerPermission();

    void setPlayerPermission(int playerPermission);

    int getCommandPermission();

    void setCommandPermission(int commandPermission);

    List<AbilityLayer> getAbilityLayers();

    void setAbilityLayers(final List<AbilityLayer> abilityLayers);
}
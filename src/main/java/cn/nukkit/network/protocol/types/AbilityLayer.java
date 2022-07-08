package cn.nukkit.network.protocol.types;

import lombok.Data;

/**
 * @author Kaooot
 * @version 1.0
 */
@Data
public class AbilityLayer {

    private Type layerType;
    private int abilitiesSet;
    private int abilityValues;
    private float flySpeed;
    private float walkSpeed;

    public enum Type {
        CACHE,
        BASE,
        SPECTATOR,
        COMMANDS
    }
}
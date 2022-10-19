package cn.nukkit.network.protocol.types;

import lombok.Data;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author Kaooot
 * @version 1.0
 */
@Data
public class AbilityLayer {

    private Type layerType;
    private Set<Ability> abilitiesSet = EnumSet.noneOf(Ability.class);
    private Set<Ability> abilityValues = EnumSet.noneOf(Ability.class);
    private float flySpeed;
    private float walkSpeed;

    public enum Type {
        CACHE,
        BASE,
        SPECTATOR,
        COMMANDS,
        EDITOR
    }
}
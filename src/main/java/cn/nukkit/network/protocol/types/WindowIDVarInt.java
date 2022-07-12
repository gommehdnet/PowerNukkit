package cn.nukkit.network.protocol.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Kaooot
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum WindowIDVarInt {

    DROP_CONTENTS(-100),
    BEACON(-24),
    TRADING_OUTPUT(-23),
    TRADING_USE_INPUTS(-22),
    TRADING_INPUT_2(-21),
    TRADING_INPUT_1(-20),
    ENCHANT_OUTPUT(-17),
    ENCHANT_MATERIAL(-16),
    ENCHANT_INPUT(-15),
    ANVIL_OUTPUT(-13),
    ANVIL_RESULT(-12),
    ANVIL_MATERIAL(-11),
    CONTAINER_INPUT(-10),
    CRAFTING_USE_INGREDIENT(-5),
    CRAFTING_RESULT(-4),
    CRAFTING_REMOVE_INGREDIENT(-3),
    CRAFTING_ADD_INGREDIENT(-2),
    NONE(-1),
    INVENTORY(0),
    FIRST(1),
    LAST(100),
    OFFHAND(119),
    ARMOR(120),
    CREATIVE(121),
    HOTBAR(122),
    FIXED_INVENTORY(123),
    UI(124);

    private final int id;

    public static WindowIDVarInt byId(int id) {
        for (WindowIDVarInt windowIDVarInt : WindowIDVarInt.values()) {
            if (windowIDVarInt.getId() == id) {
                return windowIDVarInt;
            }
        }

        return null;
    }
}
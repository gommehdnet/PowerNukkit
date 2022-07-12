package cn.nukkit.network.protocol.types;

import cn.nukkit.math.BlockVector3;
import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class BlockAction {

    Action action;
    BlockVector3 position;
    int face;

    public enum Action {
        START_BREAK,
        ABORT_BREAK,
        STOP_BREAK,
        GET_UPDATED_BLOCK,
        DROP_ITEM,
        START_SLEEPING,
        STOP_SLEEPING,
        RESPAWN,
        JUMP,
        START_SPRINT,
        STOP_SPRINT,
        START_SNEAK,
        STOP_SNEAK,
        CREATIVE_PLAYER_DESTROY_BLOCK,
        DIMENSION_CHANGE_ACK,
        START_GLIDE,
        STOP_GLIDE,
        BUILD_DENIED,
        CRACK_BREAK,
        CHANGE_SKIN,
        SET_ENCHANTMENT_SEED,
        SWIMMING,
        STOP_SWIMMING,
        START_SPIN_ATTACK,
        STOP_SPIN_ATTACK,
        INTERACT_BLOCK,
        PREDICT_BREAK,
        CONTINUE_BREAK,
        START_ITEM_USE_ON,
        STOP_ITEM_USE_ON
    }
}
package cn.nukkit.network.protocol.types;

/**
 * @author Kaooot
 * @version 1.0
 */
public enum ItemStackRequestAction {

    TAKE,
    PLACE,
    SWAP,
    DROP,
    DESTROY,
    CONSUME,
    CREATE,
    PLACE_IN_CONTAINER,
    TAKE_OUT_CONTAINER,
    LAB_TABLE_COMBINE,
    BEACON_PAYMENT,
    MINE_BLOCK,
    CRAFT_RECIPE,
    CRAFT_RECIPE_AUTO,
    CRAFT_CREATIVE,
    OPTIONAL,
    CRAFT_GRINDSTONE_REQUEST,
    CRAFT_LOOM_REQUEST,
    NON_IMPLEMENTED,
    RESULTS_DEPRECATED
}
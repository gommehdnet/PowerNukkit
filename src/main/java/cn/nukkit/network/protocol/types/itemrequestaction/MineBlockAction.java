package cn.nukkit.network.protocol.types.itemrequestaction;

import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class MineBlockAction implements ItemStackRequestAction {

    int hotbarSlot;
    int predictedDurability;
    int stackNetworkId;
}
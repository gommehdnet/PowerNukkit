package cn.nukkit.network.protocol.types;

import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class ContainerSlot {

    byte slot;
    byte hotbarSlot;
    byte count;
    int stackNetworkId;
    String customName;
    int durability;
}
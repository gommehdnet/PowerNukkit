package cn.nukkit.network.protocol.types;

import lombok.Value;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class ItemStackResponseContainerInfo {

    ContainerSlotType slotType;
    List<ContainerSlot> slots;
}
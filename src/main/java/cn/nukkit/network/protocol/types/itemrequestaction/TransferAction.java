package cn.nukkit.network.protocol.types.itemrequestaction;

import cn.nukkit.network.protocol.types.StackRequestSlotInfo;

/**
 * @author Kaooot
 * @version 1.0
 */
public interface TransferAction extends ItemStackRequestAction {

    byte getCount();

    StackRequestSlotInfo getSource();

    StackRequestSlotInfo getDestination();
}
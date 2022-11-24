package cn.nukkit.network.protocol.types.itemrequestaction;

import cn.nukkit.network.protocol.types.StackRequestSlotInfo;
import cn.nukkit.network.protocol.types.itemrequestaction.ItemStackRequestAction;
import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class PlaceAction implements TransferAction {

    byte count;
    StackRequestSlotInfo source;
    StackRequestSlotInfo destination;
}
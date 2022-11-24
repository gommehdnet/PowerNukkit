package cn.nukkit.network.protocol.types.itemrequestaction;

import cn.nukkit.network.protocol.types.StackRequestSlotInfo;
import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class TakeAction implements TransferAction {

    byte count;
    StackRequestSlotInfo source;
    StackRequestSlotInfo destination;
}
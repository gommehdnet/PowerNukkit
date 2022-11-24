package cn.nukkit.network.protocol.types.itemrequestaction;

import cn.nukkit.network.protocol.types.StackRequestSlotInfo;
import cn.nukkit.network.protocol.types.itemrequestaction.ItemStackRequestAction;
import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class SwapAction implements ItemStackRequestAction {

    StackRequestSlotInfo source;
    StackRequestSlotInfo destination;
}
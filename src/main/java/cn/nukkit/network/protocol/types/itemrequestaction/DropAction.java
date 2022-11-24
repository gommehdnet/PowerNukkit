package cn.nukkit.network.protocol.types.itemrequestaction;

import cn.nukkit.network.protocol.types.StackRequestSlotInfo;
import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class DropAction implements ItemStackRequestAction {

    byte count;
    StackRequestSlotInfo source;
    boolean randomly;
}
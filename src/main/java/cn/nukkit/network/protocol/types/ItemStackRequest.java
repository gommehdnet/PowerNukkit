package cn.nukkit.network.protocol.types;

import cn.nukkit.network.protocol.types.itemrequestaction.ItemStackRequestAction;
import lombok.Value;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class ItemStackRequest {

    int requestId;
    List<ItemStackRequestAction> actions;
    List<String> filters;
    ItemStackRequestFilterCause filterCause;
}
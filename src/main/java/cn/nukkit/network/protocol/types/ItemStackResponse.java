package cn.nukkit.network.protocol.types;

import lombok.Value;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class ItemStackResponse {

    ItemStackResponseStatus status;
    int requestId;
    List<ItemStackResponseContainerInfo> containers;
}
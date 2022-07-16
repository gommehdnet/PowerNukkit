package cn.nukkit.network.protocol.types;

import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class AttributeModifierData {

    String id;
    String name;
    float amount;
    AttributeOperation operation;
    int operand;
    boolean serializable;
}
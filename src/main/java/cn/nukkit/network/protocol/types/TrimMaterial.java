package cn.nukkit.network.protocol.types;

import lombok.Data;

/**
 * @author Kaooot
 * @version 1.0
 */
@Data
public class TrimMaterial {

    private final String materialId;
    private final String color;
    private final String itemName;
}
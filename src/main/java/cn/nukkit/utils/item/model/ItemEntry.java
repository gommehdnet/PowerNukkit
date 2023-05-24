package cn.nukkit.utils.item.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Kaooot
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class ItemEntry {

    private String name;
    private int id;
    private Integer meta;
}
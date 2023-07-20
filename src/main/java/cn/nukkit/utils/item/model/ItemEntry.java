package cn.nukkit.utils.item.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * @author Kaooot
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class ItemEntry implements Cloneable {

    private String name;
    private int id;
    private Map<Integer, String> remappedMetas;

    @Override
    public ItemEntry clone() {
        try {
            return (ItemEntry) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
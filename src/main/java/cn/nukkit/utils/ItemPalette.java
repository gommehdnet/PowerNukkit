package cn.nukkit.utils;

import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPalette {

    @Value
    public static class ItemEntry {
        String identifier;
        short runtimeId;
        boolean componentBased;
    }
}
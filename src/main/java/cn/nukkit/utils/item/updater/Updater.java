package cn.nukkit.utils.item.updater;

import cn.nukkit.utils.item.model.ItemEntry;

/**
 * @author Kaooot
 * @version 1.0
 */
public interface Updater {

    /**
     * Updates the given {@link ItemEntry}
     *
     * @param itemEntry which should be updated
     */
    void update(ItemEntry itemEntry);
}
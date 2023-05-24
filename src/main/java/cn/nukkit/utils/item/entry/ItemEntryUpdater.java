package cn.nukkit.utils.item.entry;

import cn.nukkit.utils.item.updater.RemappedMetasUpdater;
import cn.nukkit.utils.item.updater.RenamedIdsUpdater;
import cn.nukkit.utils.item.updater.Updater;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
@Getter
public class ItemEntryUpdater {

    int version;
    Set<Updater> updaters;

    public static ItemEntryUpdater fromJson(int version, JsonObject jsonObject) {
        final Set<Updater> updaters = new HashSet<>();

        for (String key : jsonObject.keySet()) {
            if (key.equalsIgnoreCase("renamedIds")) {
                updaters.add(RenamedIdsUpdater.build(jsonObject.getAsJsonObject("renamedIds")));

                continue;
            }

            if (key.equalsIgnoreCase("remappedMetas")) {
                updaters.add(RemappedMetasUpdater.build(jsonObject.getAsJsonObject("remappedMetas")));
            }
        }

        return new ItemEntryUpdater(version, updaters);
    }
}
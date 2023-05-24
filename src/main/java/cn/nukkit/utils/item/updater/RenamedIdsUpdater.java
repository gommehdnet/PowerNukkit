package cn.nukkit.utils.item.updater;

import cn.nukkit.utils.item.model.ItemEntry;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RenamedIdsUpdater implements Updater {
    Map<String, String> renamedIds;

    public static RenamedIdsUpdater build(JsonObject jsonObject) {
        final Map<String, String> renamedIds = new HashMap<>();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            renamedIds.put(entry.getKey(), entry.getValue().getAsString());
        }

        return new RenamedIdsUpdater(renamedIds);
    }

    @Override
    public void update(ItemEntry itemEntry) {
        if (!this.renamedIds.containsKey(itemEntry.getName())) {
            return;
        }

        itemEntry.setName(this.renamedIds.get(itemEntry.getName()));
    }
}
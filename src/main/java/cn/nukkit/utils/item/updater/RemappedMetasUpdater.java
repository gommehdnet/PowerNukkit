package cn.nukkit.utils.item.updater;

import cn.nukkit.utils.item.model.ItemEntry;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
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
public class RemappedMetasUpdater implements Updater {

    Map<String, Int2ObjectMap<String>> remappedMetas;

    public static RemappedMetasUpdater build(JsonObject jsonObject) {
        final Map<String, Int2ObjectMap<String>> remappedMetas = new HashMap<>();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            final Int2ObjectMap<String> metas = new Int2ObjectOpenHashMap<>();

            for (Map.Entry<String, JsonElement> remappedMetaEntry : entry.getValue().getAsJsonObject().entrySet()) {
                metas.put(Integer.parseInt(remappedMetaEntry.getKey()), remappedMetaEntry.getValue().getAsString());
            }

            remappedMetas.put(entry.getKey(), metas);
        }

        return new RemappedMetasUpdater(remappedMetas);
    }

    @Override
    public void update(ItemEntry itemEntry) {
        if (!this.remappedMetas.containsKey(itemEntry.getName())) {
            return;
        }

        final Int2ObjectMap<String> remappedMetas = this.remappedMetas.get(itemEntry.getName());

        if (!remappedMetas.containsKey(itemEntry.getMeta().intValue())) {
            return;
        }

        itemEntry.setName(remappedMetas.get(itemEntry.getMeta().intValue()));
        itemEntry.setMeta(0);
    }
}
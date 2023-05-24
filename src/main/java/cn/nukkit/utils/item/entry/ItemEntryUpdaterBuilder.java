package cn.nukkit.utils.item.entry;

import cn.nukkit.network.protocol.Protocol;
import cn.nukkit.utils.item.model.ItemEntry;
import cn.nukkit.utils.item.updater.Updater;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEntryUpdaterBuilder {

    private static final Gson GSON = new Gson();
    private static final List<ItemEntryUpdater> UPDATERS;
    private static final Map<Protocol, String> FILE_NAMES = new HashMap<>();

    static {
        UPDATERS = Arrays.asList(
                build(Protocol.V1_19_70, "0091_1.19.60_to_1.19.70.26_beta.json"),
                build(Protocol.V1_19_80, "0101_1.19.70_to_1.19.80.24_beta.json")
        );
        FILE_NAMES.put(Protocol.V1_19_70, "0091_1.19.60_to_1.19.70.26_beta.json");
        FILE_NAMES.put(Protocol.V1_19_80, "0101_1.19.70_to_1.19.80.24_beta.json");
    }

    public static ItemEntry update(ItemEntry itemEntry, int targetVersion) {
        for (ItemEntryUpdater updater : ItemEntryUpdaterBuilder.UPDATERS) {
            if (updater.getVersion() > targetVersion) {
                continue;
            }

            for (Updater u : updater.getUpdaters()) {
                u.update(itemEntry);
            }
        }

        return itemEntry;
    }

    private static ItemEntryUpdater build(Protocol protocol, String fileName) {
        try (final InputStream inputStream = ItemEntryUpdaterBuilder.class.getClassLoader().getResourceAsStream("BedrockItemUpgradeSchema/id_meta_upgrade_schema/" + fileName)) {
            if (inputStream != null) {
                return ItemEntryUpdater.fromJson(protocol.version(), ItemEntryUpdaterBuilder.GSON.fromJson(new InputStreamReader(inputStream), JsonObject.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Could not retrieve ItemEntryUpdater from file " + fileName);
    }
}
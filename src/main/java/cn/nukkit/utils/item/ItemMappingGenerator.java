package cn.nukkit.utils.item;

import cn.nukkit.network.protocol.Protocol;
import cn.nukkit.utils.item.entry.ItemEntryUpdaterBuilder;
import cn.nukkit.utils.item.model.ItemEntry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMappingGenerator {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }

        final File itemPaletteDir = new File("src/main/resources/bedrock/resource/item_palette/");
        final Int2ObjectMap<List<ItemEntry>> itemsMap = new Int2ObjectOpenHashMap<>();
        final File[] files = itemPaletteDir.listFiles();

        Arrays.sort(Objects.requireNonNull(files), File::compareTo);

        for (File file : files) {
            final Protocol protocol = Protocol.byMinecraftVersion(file.getName()
                    .split("\\.")[1]
                    .split("\\.")[0]
                    .replaceAll("_", "."));

            if (!protocol.equals(Protocol.UNKNOWN)) {
                final List<ItemEntry> items = new ObjectArrayList<>();

                try (FileReader fileReader = new FileReader(file)) {
                    final JsonArray jsonItems = ItemMappingGenerator.GSON.fromJson(fileReader, JsonArray.class);

                    for (int i = 0; i < jsonItems.size(); i++) {
                        final JsonObject jsonObject = jsonItems.get(i).getAsJsonObject();

                        if (jsonObject.has("name") && jsonObject.has("id")) {
                            items.add(new ItemEntry(jsonObject.get("name").getAsString(), jsonObject.get("id").getAsInt(), -1));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                itemsMap.put(protocol.version(), items);

                System.out.println("Successfully loaded items of " + protocol.minecraftVersion() +
                        " (" + protocol.version() + ")");
            }
        }

        final Protocol sourceProtocol = Protocol.byMinecraftVersion(args[0]);
        final Protocol targetProtocol = Protocol.byMinecraftVersion(args[1]);
        final List<ItemEntry> sourcePalette = itemsMap.get(sourceProtocol.version());
        final List<ItemEntry> targetPalette = itemsMap.get(targetProtocol.version());

        final Map<ItemEntry, ItemEntry> mapping = new HashMap<>();

        for (ItemEntry itemEntry : sourcePalette) {
            final ItemEntry target = ItemEntryUpdaterBuilder.update(itemEntry, targetProtocol.version());

            if (!targetPalette.contains(target)) {
                System.out.println("Cannot find targetItemEntry for " + itemEntry);

                return;
            }

            mapping.put(itemEntry, target);
        }
    }

        /*final int sourceProtocol = Protocol.oldest().version();
        final Map<String, Integer> sourceItems = itemsMap.get(sourceProtocol);
        final Int2ObjectMap<List<MappedEntry>> mapped = new Int2ObjectOpenHashMap<>();

        for (Map.Entry<String, Integer> entry : sourceItems.entrySet()) {
            for (Protocol protocol : Protocol.VALUES) {
                if (!itemsMap.containsKey(protocol.version()) || protocol.version() == sourceProtocol) {
                    continue;
                }

                final UpgradeSchema upgradeSchema = ItemMappingGenerator.getUpgradeSchema(protocol);

                for (Map.Entry<String, Integer> targetEntry : itemsMap.get(protocol.version()).entrySet()) {
                    // renamed id or different network ids
                    if ((upgradeSchema.renamedIds.containsKey(entry.getKey()) &&
                            upgradeSchema.renamedIds.get(entry.getKey()).equalsIgnoreCase(targetEntry.getKey())) ||
                            (entry.getKey().equalsIgnoreCase(targetEntry.getKey()) &&
                                    targetEntry.getValue().intValue() != entry.getValue().intValue())) {
                        final List<MappedEntry> mappedEntries = mapped.getOrDefault(protocol.version(), new ArrayList<>());

                        mappedEntries.add(new MappedEntry(new ItemEntry(entry.getKey(), entry.getValue(), null),
                                new ItemEntry(targetEntry.getKey(), targetEntry.getValue(),
                                        upgradeSchema.remappedMetas.getOrDefault(entry.getKey(), null))));

                        mapped.put(protocol.version(), mappedEntries);

                        break;
                    }
                }
            }
        }

        for (Map.Entry<Integer, List<MappedEntry>> entry : mapped.int2ObjectEntrySet()) {
            final String filePath = "src/main/resources/bedrock/mapping/item_palette/item_mapping_"
                    + sourceProtocol + "_to_" + entry.getKey() + ".json";

            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                fileOutputStream.write(ItemMappingGenerator.GSON.toJson(mapped.get(entry.getKey()))
                        .getBytes(StandardCharsets.UTF_8));

                System.out.println("Generated item mapping (" + sourceProtocol + " => " + entry.getKey() + ")");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Value
    public static class ItemEntry {
        String name;
        int id;
        Int2ObjectMap<String> remappedMetas;
    }

    @Value
    public static class MappedEntry {
        ItemEntry source;
        ItemEntry target;
    }

    @Value
    private static class UpgradeSchema {
        Map<String, String> renamedIds;
        Map<String, Int2ObjectMap<String>> remappedMetas;
    }

    private static UpgradeSchema getUpgradeSchema(Protocol protocol) {
        final Map<String, String> renamedIds = new HashMap<>();
        final Map<String, Int2ObjectMap<String>> remappedMetas = new HashMap<>();

        for (Protocol value : Protocol.VALUES) {
            if (value.version() <= protocol.version() && ItemMappingGenerator.UPGRADE_SCHEMAS.containsKey(protocol)) {
                try (final InputStream inputStream = Files.newInputStream(Paths.get("src/main/resources/BedrockItemUpgradeSchema/id_meta_upgrade_schema/" +
                        ItemMappingGenerator.UPGRADE_SCHEMAS.get(protocol)))) {
                    final JsonObject jsonObject = ItemMappingGenerator.GSON.fromJson(new InputStreamReader(inputStream), JsonObject.class);

                    if (jsonObject.has("remappedMetas")) {
                        final JsonObject remappedMetasObject = jsonObject.getAsJsonObject("remappedMetas");

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return new UpgradeSchema(renamedIds, remappedMetas);
    }

    private interface Updater {
        void update(Map.Entry<String, Integer> entry);
    }*/
}
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
import lombok.Value;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
                            items.add(new ItemEntry(jsonObject.get("name").getAsString(), jsonObject.get("id").getAsInt(), null));
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

            if (targetPalette.stream().noneMatch(i -> i.getId() == target.getId())) {
                System.out.println("Cannot find targetItemEntry for " + itemEntry);

                continue;
            }

            final ItemEntry finalEntry = itemEntry.clone();

            // do not allow remapped metas on source
            finalEntry.setRemappedMetas(null);

            mapping.put(finalEntry, target);
        }

        try (final FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/bedrock/mapping/item_palette/item_mapping_" + sourceProtocol.version() + "_to_" + targetProtocol.version() + ".json")) {
            final List<MappedItemEntry> entries = new ArrayList<>();

            for (Map.Entry<ItemEntry, ItemEntry> entry : mapping.entrySet()) {
                final ItemEntry target = entry.getValue().clone();
                final Map<Integer, String> remappedMetas = entry.getValue().getRemappedMetas();

                // do not allow remapped metas on target because we use the remapped metas of the MappedItemEntry
                target.setRemappedMetas(null);

                // update networkId of target
                itemsMap.get(targetProtocol.version()).stream()
                        .filter(e -> e.getName().equalsIgnoreCase(target.getName()))
                        .findAny()
                        .ifPresent(e -> target.setId(e.getId()));

                entries.add(new MappedItemEntry(entry.getKey(), target, remappedMetas));
            }

            fileOutputStream.write(ItemMappingGenerator.GSON.toJson(entries).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Value
    public static class MappedItemEntry {
        ItemEntry source;
        ItemEntry target;
        Map<Integer, String> remappedMetas;
    }
}
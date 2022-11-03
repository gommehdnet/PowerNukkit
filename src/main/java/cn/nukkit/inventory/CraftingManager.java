package cn.nukkit.inventory;

import cn.nukkit.Server;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.network.protocol.CraftingDataPacket;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.utils.BinaryStream;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.Utils;
import io.netty.util.collection.CharObjectHashMap;
import io.netty.util.internal.EmptyArrays;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.*;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@Log4j2
public class CraftingManager {

    public final Collection<Recipe> recipes = new ArrayDeque<>();

    @Since("1.5.0.0-PN")
    public static DataPacket packet = null;


    protected final Map<Integer, Map<UUID, ShapedRecipe>> shapedRecipes = new Int2ObjectOpenHashMap<>();

    public final Map<Integer, FurnaceRecipe> furnaceRecipes = new Int2ObjectOpenHashMap<>();
    @PowerNukkitOnly
    public final Map<Integer, BlastFurnaceRecipe> blastFurnaceRecipes = new Int2ObjectOpenHashMap<>();
    @PowerNukkitOnly
    public final Map<Integer, SmokerRecipe> smokerRecipes = new Int2ObjectOpenHashMap<>();
    @PowerNukkitOnly
    public final Map<Integer, CampfireRecipe> campfireRecipes = new Int2ObjectOpenHashMap<>();

    @Since("1.4.0.0-PN")
    public final Map<UUID, MultiRecipe> multiRecipes = new HashMap<>();

    public final Map<Integer, BrewingRecipe> brewingRecipes = new Int2ObjectOpenHashMap<>();
    public final Map<Integer, ContainerRecipe> containerRecipes = new Int2ObjectOpenHashMap<>();
    @PowerNukkitOnly
    public final Map<Integer, StonecutterRecipe> stonecutterRecipes = new Int2ObjectOpenHashMap<>();

    private static int RECIPE_COUNT = 0;
    protected final Map<Integer, Map<UUID, ShapelessRecipe>> shapelessRecipes = new Int2ObjectOpenHashMap<>();
    @PowerNukkitOnly
    protected final Map<Integer, Map<UUID, CartographyRecipe>> cartographyRecipes = new Int2ObjectOpenHashMap<>();

    private final Int2ObjectOpenHashMap<Map<UUID, SmithingRecipe>> smithingRecipes = new Int2ObjectOpenHashMap<>();

    public static final Comparator<Item> recipeComparator = (i1, i2) -> {
        if (i1.getIdentifier().getNetworkId() > i2.getIdentifier().getNetworkId()) {
            return 1;
        } else if (i1.getIdentifier().getNetworkId() < i2.getIdentifier().getNetworkId()) {
            return -1;
        } else if (i1.getDamage() > i2.getDamage()) {
            return 1;
        } else if (i1.getDamage() < i2.getDamage()) {
            return -1;
        } else return Integer.compare(i1.getCount(), i2.getCount());
    };

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static DataPacket getCraftingPacket() {
        return packet;
    }

    public CraftingManager() {
        Config recipesConfig = new Config(Config.JSON);
        try (InputStream recipesStream = Server.class.getClassLoader().getResourceAsStream("recipes.json")) {
            recipesConfig.load(Objects.requireNonNull(recipesStream, "Unable to find recipes.json"));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        this.loadRecipes(recipesConfig);

        String path = Server.getInstance().getDataPath() + "custom_recipes.json";
        File filePath = new File(path);

        if (filePath.exists()) {
            Config customRecipes = new Config(filePath, Config.JSON);
            this.loadRecipes(customRecipes);
        }
        this.rebuildPacket();

        log.info("Loaded {} recipes.", this.recipes.size());
    }

    @SuppressWarnings("unchecked")
    private void loadRecipes(Config config) {
        List<Map> recipes = config.getMapList("recipes");
        log.info("Loading recipes...");

        toNextRecipe:
        for (Map<String, Object> recipe : recipes) {
            try {
                final int type = ((Number) recipe.get("type")).intValue();

                switch (type) {
                    case 0:
                    case 5:
                        String block = (String) recipe.get("block");
                        List<Map> input = (List<Map>) recipe.get("input");
                        List<Map> output = (List<Map>) recipe.get("output");

                        if (type == 5) {
                            block = "shulker_box";
                        }

                        if (!"crafting_table".equals(block) && !"stonecutter".equals(block)
                                && !"cartography_table".equalsIgnoreCase(block) && !"shulker_box".equalsIgnoreCase(block)
                                && !"smithing_table".equalsIgnoreCase(block)) {
                            // Ignore other recipes than crafting table, stonecutter, smithing table and cartography table
                            continue;
                        }

                        // TODO: handle multiple result items
                        if (output.size() > 1) {
                            continue;
                        }

                        Map<String, Object> first = output.get(0);

                        final List<Item> sorted = new ArrayList<>();

                        for (Map<String, Object> ingredient : input) {
                            final Item recipeItem = this.parseRecipeItem(ingredient);

                            if (recipeItem.isNull()) {
                                continue toNextRecipe;
                            }

                            sorted.add(recipeItem);
                        }

                        // Bake sorted list
                        sorted.sort(recipeComparator);

                        Item result = this.parseRecipeItem(first);

                        if (result.isNull()) {
                            continue toNextRecipe;
                        }

                        String id = (String) recipe.get("id");
                        int priority = Utils.toInt(recipe.get("priority"));

                        switch (block) {
                            case "crafting_table":
                                this.registerRecipe(new ShapelessRecipe(id, priority, result, sorted));

                                break;
                            case "shulker_box":
                                this.registerRecipe(new ShulkerBoxRecipe(id, priority, result, sorted));

                                break;
                            case "stonecutter":
                                this.registerRecipe(new StonecutterRecipe(id, priority, result, sorted.get(0)));

                                break;
                            case "cartography_table":
                                this.registerRecipe(new CartographyRecipe(id, priority, result, sorted));

                                break;
                            case "smithing_table":
                                this.registerRecipe(new SmithingRecipe(id, priority, sorted, result));

                                break;
                        }

                        break;
                    case 1:
                        block = (String) recipe.get("block");

                        if (!"crafting_table".equals(block)) {
                            // Ignore other recipes than crafting table ones
                            continue;
                        }

                        output = (List<Map>) recipe.get("output");

                        first = output.remove(0);

                        final String[] shape = ((List<String>) recipe.get("shape")).toArray(EmptyArrays.EMPTY_STRINGS);
                        final Map<Character, Item> ingredients = new CharObjectHashMap<>();
                        final List<Item> extraResults = new ArrayList<>();

                        final Map<String, Map<String, Object>> shapedInput = (Map) recipe.get("input");

                        for (Map.Entry<String, Map<String, Object>> entry : shapedInput.entrySet()) {
                            final String s = entry.getKey();
                            final Item ingredient = this.parseRecipeItem(entry.getValue());

                            if (ingredient.isNull()) {
                                continue toNextRecipe;
                            }

                            ingredients.put(s.charAt(0), ingredient);
                        }

                        for (Map<String, Object> data : output) {
                            final Item extraResult = this.parseRecipeItem(data);

                            if (extraResult.isNull()) {
                                continue toNextRecipe;
                            }

                            extraResults.add(extraResult);
                        }

                        final Item primaryResult = this.parseRecipeItem(first);

                        if (primaryResult.isNull()) {
                            continue toNextRecipe;
                        }

                        id = (String) recipe.get("id");
                        priority = Utils.toInt(recipe.get("priority"));

                        this.registerRecipe(new ShapedRecipe(id, priority, primaryResult, shape, ingredients, extraResults));

                        break;
                    case 2:
                    case 3:
                        block = (String) recipe.get("block");

                        if (!"furnace".equals(block) && !"blast_furnace".equals(block)
                                && !"smoker".equals(block) && !"campfire".equals(block)) {
                            // Ignore other recipes than furnaces, blast furnaces, smokers and campfire
                            continue;
                        }

                        final Map<String, Object> resultMap = (Map) recipe.get("output");

                        final Item resultItem = this.parseRecipeItem(resultMap);

                        if (resultItem.isNull()) {
                            continue toNextRecipe;
                        }

                        final Map<String, Object> inputMap = (Map) recipe.get("input");

                        final Item ingredient = this.parseRecipeItem(inputMap);

                        if (ingredient.isNull()) {
                            continue toNextRecipe;
                        }

                        switch (block) {
                            case "furnace":
                                this.registerRecipe(new FurnaceRecipe(resultItem, ingredient));

                                break;
                            case "blast_furnace":
                                this.registerRecipe(new BlastFurnaceRecipe(resultItem, ingredient));

                                break;
                            case "smoker":
                                this.registerRecipe(new SmokerRecipe(resultItem, ingredient));

                                break;
                            case "campfire":
                                this.registerRecipe(new CampfireRecipe(resultItem, ingredient));

                                break;
                        }

                        break;
                    case 4:
                        this.registerRecipe(new MultiRecipe(UUID.fromString((String) recipe.get("uuid"))));

                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                log.error("Exception during registering recipe", e);
            }
        }

        // Load brewing recipes
        final List<Map> potionMixes = config.getMapList("potionMixes");

        for (Map potionMix : potionMixes) {
            final String inputId = potionMix.get("inputId").toString();
            final int inputMeta = ((Number) potionMix.get("inputMeta")).intValue();
            final String reagentId = potionMix.get("reagentId").toString();
            final int reagentMeta = ((Number) potionMix.get("reagentMeta")).intValue();
            final String outputId = potionMix.get("outputId").toString();
            final int outputMeta = ((Number) potionMix.get("outputMeta")).intValue();

            final Item input = Item.get(ItemID.byIdentifier(inputId), inputMeta);
            final Item reagent = Item.get(ItemID.byIdentifier(reagentId), reagentMeta);
            final Item output = Item.get(ItemID.byIdentifier(outputId), outputMeta);

            this.registerBrewingRecipe(new BrewingRecipe(input, reagent, output));
        }

        final List<Map> containerMixes = config.getMapList("containerMixes");

        for (Map containerMix : containerMixes) {
            final String inputId = containerMix.get("inputId").toString();
            final String reagentId = containerMix.get("reagentId").toString();
            final String outputId = containerMix.get("outputId").toString();

            this.registerContainerRecipe(new ContainerRecipe(Item.get(ItemID.byIdentifier(inputId)), Item.get(ItemID.byIdentifier(reagentId)), Item.get(ItemID.byIdentifier(outputId))));
        }

        // Allow to rename without crafting
        this.registerCartographyRecipe(new CartographyRecipe(Item.get(ItemID.EMPTY_MAP), Collections.singletonList(Item.get(ItemID.EMPTY_MAP))));
        this.registerCartographyRecipe(new CartographyRecipe(Item.get(ItemID.EMPTY_MAP, 0, 2), Collections.singletonList(Item.get(ItemID.EMPTY_MAP, 0, 2))));
        this.registerCartographyRecipe(new CartographyRecipe(Item.get(ItemID.FILLED_MAP), Collections.singletonList(Item.get(ItemID.FILLED_MAP))));
        this.registerCartographyRecipe(new CartographyRecipe(Item.get(ItemID.FILLED_MAP, 0, 3), Collections.singletonList(Item.get(ItemID.FILLED_MAP, 0, 3))));
        this.registerCartographyRecipe(new CartographyRecipe(Item.get(ItemID.FILLED_MAP, 0, 4), Collections.singletonList(Item.get(ItemID.FILLED_MAP, 0, 4))));
        this.registerCartographyRecipe(new CartographyRecipe(Item.get(ItemID.FILLED_MAP, 0, 5), Collections.singletonList(Item.get(ItemID.FILLED_MAP, 0, 5))));
    }

    private Item parseRecipeItem(Map<String, Object> data) {
        byte[] nbt = new byte[0];

        if (data.containsKey("nbt_b64")) {
            nbt = Base64.getDecoder().decode(data.get("nbt_b64").toString());
        }

        final String identifier = data.get("id").toString();

        Item item = Item.get(ItemID.byIdentifier(identifier));

        item.setCompoundTag(nbt);

        if (data.containsKey("count")) {
            final int count = ((Number) data.get("count")).intValue();

            item.setCount(count);
        }

        if (data.containsKey("damage")) {
            final short damage = ((Number) data.get("damage")).shortValue();

            if (damage == Short.MAX_VALUE) {
                item = item.createFuzzyCraftingRecipe();
            }
        }

        return item;
    }

    public void rebuildPacket() {
        CraftingDataPacket pk = new CraftingDataPacket();
        pk.cleanRecipes = true;

        for (Recipe recipe : this.getRecipes()) {
            if (recipe instanceof ShapedRecipe) {
                pk.addShapedRecipe((ShapedRecipe) recipe);
            } else if (recipe instanceof ShapelessRecipe) {
                pk.addShapelessRecipe((ShapelessRecipe) recipe);
            }
        }

        for (Map<UUID, CartographyRecipe> map : cartographyRecipes.values()) {
            for (CartographyRecipe recipe : map.values()) {
                pk.addCartographyRecipe(recipe);
            }
        }

        for (FurnaceRecipe recipe : this.getFurnaceRecipes().values()) {
            pk.addFurnaceRecipe(recipe);
        }

        for (MultiRecipe recipe : this.multiRecipes.values()) {
            pk.addMultiRecipe(recipe);
        }

        for (SmokerRecipe recipe : smokerRecipes.values()) {
            pk.addSmokerRecipe(recipe);
        }

        for (BlastFurnaceRecipe recipe : blastFurnaceRecipes.values()) {
            pk.addBlastFurnaceRecipe(recipe);
        }

        for (CampfireRecipe recipe : campfireRecipes.values()) {
            pk.addCampfireRecipeRecipe(recipe);
        }

        for (BrewingRecipe recipe : brewingRecipes.values()) {
            pk.addBrewingRecipe(recipe);
        }

        for (ContainerRecipe recipe : containerRecipes.values()) {
            pk.addContainerRecipe(recipe);
        }

        for (StonecutterRecipe recipe : stonecutterRecipes.values()) {
            pk.addStonecutterRecipe(recipe);
        }

        //pk.tryEncode();
        // TODO: find out whats wrong with compression
        //packet = pk.compress(Deflater.BEST_COMPRESSION);
        packet = pk;
    }

    public Collection<Recipe> getRecipes() {
        return recipes;
    }

    public Map<Integer, FurnaceRecipe> getFurnaceRecipes() {
        return furnaceRecipes;
    }

    public FurnaceRecipe matchFurnaceRecipe(Item input) {
        FurnaceRecipe recipe = this.furnaceRecipes.get(getItemHash(input));
        if (recipe == null) recipe = this.furnaceRecipes.get(getItemHash(input.getIdentifier()));
        return recipe;
    }

    @PowerNukkitOnly
    public CampfireRecipe matchCampfireRecipe(Item input) {
        CampfireRecipe recipe = this.campfireRecipes.get(getItemHash(input));
        if (recipe == null) recipe = this.campfireRecipes.get(getItemHash(input.getIdentifier()));
        return recipe;
    }

    @PowerNukkitOnly
    public BlastFurnaceRecipe matchBlastFurnaceRecipe(Item input) {
        BlastFurnaceRecipe recipe = this.blastFurnaceRecipes.get(getItemHash(input));
        if (recipe == null) recipe = this.blastFurnaceRecipes.get(getItemHash(input.getIdentifier()));
        return recipe;
    }

    @PowerNukkitOnly
    public SmokerRecipe matchSmokerRecipe(Item input) {
        SmokerRecipe recipe = this.smokerRecipes.get(getItemHash(input));
        if (recipe == null) recipe = this.smokerRecipes.get(getItemHash(input.getIdentifier()));
        return recipe;
    }

    private static UUID getMultiItemHash(Collection<Item> items) {
        BinaryStream stream = new BinaryStream();
        for (Item item : items) {
            stream.putVarInt(getFullItemHash(item));
        }
        return UUID.nameUUIDFromBytes(stream.getBuffer());
    }

    private static int getFullItemHash(Item item) {
        return 31 * getItemHash(item) + item.getCount();
    }

    @PowerNukkitOnly
    public void registerStonecutterRecipe(StonecutterRecipe recipe) {
        this.stonecutterRecipes.put(getItemHash(recipe.getResult()), recipe);
    }

    public void registerFurnaceRecipe(FurnaceRecipe recipe) {
        Item input = recipe.getInput();
        this.furnaceRecipes.put(getItemHash(input), recipe);
    }

    @PowerNukkitOnly
    public void registerBlastFurnaceRecipe(BlastFurnaceRecipe recipe) {
        Item input = recipe.getInput();
        this.blastFurnaceRecipes.put(getItemHash(input), recipe);
    }

    @PowerNukkitOnly
    public void registerSmokerRecipe(SmokerRecipe recipe) {
        Item input = recipe.getInput();
        this.smokerRecipes.put(getItemHash(input), recipe);
    }

    @PowerNukkitOnly
    public void registerCampfireRecipe(CampfireRecipe recipe) {
        Item input = recipe.getInput();
        this.campfireRecipes.put(getItemHash(input), recipe);
    }

    private static int getItemHash(Item item) {
        return getItemHash(item.getIdentifier());
    }

    private static int getItemHash(ItemID itemID) {
        return itemID.getNetworkId() << 8;
    }

    public void registerShapedRecipe(ShapedRecipe recipe) {
        int resultHash = getItemHash(recipe.getResult());
        Map<UUID, ShapedRecipe> map = shapedRecipes.computeIfAbsent(resultHash, k -> new HashMap<>());
        List<Item> inputList = new LinkedList<>(recipe.getIngredientsAggregate());
        map.put(getMultiItemHash(inputList), recipe);
    }


    public void registerRecipe(Recipe recipe) {
        UUID id = null;
        if (recipe instanceof CraftingRecipe || recipe instanceof StonecutterRecipe) {
            id = Utils.dataToUUID(String.valueOf(++RECIPE_COUNT), String.valueOf(recipe.getResult().getIdentifier()), String.valueOf(recipe.getResult().getDamage()), String.valueOf(recipe.getResult().getCount()), Arrays.toString(recipe.getResult().getCompoundTag()));
        }
        if (recipe instanceof CraftingRecipe) {
            ((CraftingRecipe) recipe).setId(id);
            this.recipes.add(recipe);
        } else if (recipe instanceof StonecutterRecipe) {
            ((StonecutterRecipe) recipe).setId(id);
        }

        recipe.registerToCraftingManager(this);
    }

    @PowerNukkitOnly
    public void registerCartographyRecipe(CartographyRecipe recipe) {
        List<Item> list = recipe.getIngredientList();
        list.sort(recipeComparator);

        UUID hash = getMultiItemHash(list);

        int resultHash = getItemHash(recipe.getResult());
        Map<UUID, CartographyRecipe> map = cartographyRecipes.computeIfAbsent(resultHash, k -> new HashMap<>());

        map.put(hash, recipe);
    }

    public void registerShapelessRecipe(ShapelessRecipe recipe) {
        List<Item> list = recipe.getIngredientsAggregate();

        UUID hash = getMultiItemHash(list);

        int resultHash = getItemHash(recipe.getResult());
        Map<UUID, ShapelessRecipe> map = shapelessRecipes.computeIfAbsent(resultHash, k -> new HashMap<>());

        map.put(hash, recipe);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public void registerSmithingRecipe(@Nonnull SmithingRecipe recipe) {
        List<Item> list = recipe.getIngredientsAggregate();

        UUID hash = getMultiItemHash(list);

        int resultHash = getItemHash(recipe.getResult());
        Map<UUID, SmithingRecipe> map = smithingRecipes.computeIfAbsent(resultHash, k -> new HashMap<>());

        map.put(hash, recipe);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nullable
    public SmithingRecipe matchSmithingRecipe(Item equipment, Item ingredient) {
        List<Item> inputList = new ArrayList<>(2);
        inputList.add(equipment.decrement(equipment.count - 1));
        inputList.add(ingredient.decrement(ingredient.count - 1));
        return matchSmithingRecipe(inputList);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nullable
    public SmithingRecipe matchSmithingRecipe(@Nonnull List<Item> inputList) {
        inputList.sort(recipeComparator);
        UUID inputHash = getMultiItemHash(inputList);

        return smithingRecipes.values().stream().flatMap(map -> map.entrySet().stream())
                .filter(entry -> entry.getKey().equals(inputHash))
                .map(Map.Entry::getValue)
                .findFirst().orElseGet(() ->
                        smithingRecipes.values().stream().flatMap(map -> map.values().stream())
                                .filter(recipe -> recipe.matchItems(inputList))
                                .findFirst().orElse(null)
                );
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nullable
    public SmithingRecipe matchSmithingRecipe(@Nonnull Item equipment, @Nonnull Item ingredient, @Nonnull Item primaryOutput) {
        List<Item> inputList = new ArrayList<>(2);
        inputList.add(equipment);
        inputList.add(ingredient);
        return matchSmithingRecipe(inputList, primaryOutput);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public SmithingRecipe matchSmithingRecipe(@Nonnull List<Item> inputList, @Nonnull Item primaryOutput) {
        int outputHash = getItemHash(primaryOutput);
        if (!this.smithingRecipes.containsKey(outputHash)) {
            return null;
        }

        inputList.sort(recipeComparator);

        UUID inputHash = getMultiItemHash(inputList);

        Map<UUID, SmithingRecipe> recipeMap = smithingRecipes.get(outputHash);

        if (recipeMap != null) {
            SmithingRecipe recipe = recipeMap.get(inputHash);

            if (recipe != null && (recipe.matchItems(inputList) || matchItemsAccumulation(recipe, inputList, primaryOutput))) {
                return recipe;
            }

            for (SmithingRecipe smithingRecipe : recipeMap.values()) {
                if (smithingRecipe.matchItems(inputList) || matchItemsAccumulation(smithingRecipe, inputList, primaryOutput)) {
                    return smithingRecipe;
                }
            }
        }

        return null;
    }

    private static int getPotionHash(Item ingredient, Item potion) {
        int ingredientHash = ((ingredient.getIdentifier().getNetworkId() & 0x3FF) << 6) | (ingredient.getDamage() & 0x3F);
        int potionHash = ((potion.getIdentifier().getNetworkId() & 0x3FF) << 6) | (potion.getDamage() & 0x3F);
        return ingredientHash << 16 | potionHash;
    }

    private static int getContainerHash(ItemID ingredientId, ItemID containerId) {
        return (ingredientId.getNetworkId() << 9) | containerId.getNetworkId();
    }

    public void registerBrewingRecipe(BrewingRecipe recipe) {
        Item input = recipe.getIngredient();
        Item potion = recipe.getInput();

        int potionHash = getPotionHash(input, potion);
        if (this.brewingRecipes.containsKey(potionHash)) {
            log.warn("The brewing recipe {} is being replaced by {}", brewingRecipes.get(potionHash), recipe);
        }
        this.brewingRecipes.put(potionHash, recipe);
    }

    public void registerContainerRecipe(ContainerRecipe recipe) {
        Item input = recipe.getIngredient();
        Item potion = recipe.getInput();

        this.containerRecipes.put(getContainerHash(input.getIdentifier(), potion.getIdentifier()), recipe);
    }

    public BrewingRecipe matchBrewingRecipe(Item input, Item potion) {
        return this.brewingRecipes.get(getPotionHash(input, potion));
    }

    public ContainerRecipe matchContainerRecipe(Item input, Item potion) {
        return this.containerRecipes.get(getContainerHash(input.getIdentifier(), potion.getIdentifier()));
    }

    @PowerNukkitOnly
    public StonecutterRecipe matchStonecutterRecipe(Item output) {
        return this.stonecutterRecipes.get(getItemHash(output));
    }

    @PowerNukkitOnly
    public CartographyRecipe matchCartographyRecipe(List<Item> inputList, Item primaryOutput, List<Item> extraOutputList) {
        int outputHash = getItemHash(primaryOutput);

        if (cartographyRecipes.containsKey(outputHash)) {
            inputList.sort(recipeComparator);

            UUID inputHash = getMultiItemHash(inputList);

            Map<UUID, CartographyRecipe> recipes = cartographyRecipes.get(outputHash);

            if (recipes == null) {
                return null;
            }

            CartographyRecipe recipe = recipes.get(inputHash);

            if (recipe != null && recipe.matchItems(inputList, extraOutputList) || matchItemsAccumulation(recipe, inputList, primaryOutput, extraOutputList)) {
                return recipe;
            }

            for (CartographyRecipe cartographyRecipe : recipes.values()) {
                if (cartographyRecipe.matchItems(inputList, extraOutputList) || matchItemsAccumulation(cartographyRecipe, inputList, primaryOutput, extraOutputList)) {
                    return cartographyRecipe;
                }
            }
        }

        return null;
    }

    public CraftingRecipe matchRecipe(List<Item> inputList, Item primaryOutput, List<Item> extraOutputList) {
        //TODO: try to match special recipes before anything else (first they need to be implemented!)

        int outputHash = getItemHash(primaryOutput);
        if (this.shapedRecipes.containsKey(outputHash)) {
            inputList.sort(recipeComparator);

            UUID inputHash = getMultiItemHash(inputList);

            Map<UUID, ShapedRecipe> recipeMap = shapedRecipes.get(outputHash);

            if (recipeMap != null) {
                ShapedRecipe recipe = recipeMap.get(inputHash);

                if (recipe != null && (recipe.matchItems(inputList, extraOutputList) || matchItemsAccumulation(recipe, inputList, primaryOutput, extraOutputList))) {
                    return recipe;
                }

                for (ShapedRecipe shapedRecipe : recipeMap.values()) {
                    if (shapedRecipe.matchItems(inputList, extraOutputList) || matchItemsAccumulation(shapedRecipe, inputList, primaryOutput, extraOutputList)) {
                        return shapedRecipe;
                    }
                }
            }
        }

        if (shapelessRecipes.containsKey(outputHash)) {
            inputList.sort(recipeComparator);

            UUID inputHash = getMultiItemHash(inputList);

            Map<UUID, ShapelessRecipe> recipes = shapelessRecipes.get(outputHash);

            if (recipes == null) {
                return null;
            }

            ShapelessRecipe recipe = recipes.get(inputHash);

            if (recipe != null && (recipe.matchItems(inputList, extraOutputList) || matchItemsAccumulation(recipe, inputList, primaryOutput, extraOutputList))) {
                return recipe;
            }

            for (ShapelessRecipe shapelessRecipe : recipes.values()) {
                if (shapelessRecipe.matchItems(inputList, extraOutputList) || matchItemsAccumulation(shapelessRecipe, inputList, primaryOutput, extraOutputList)) {
                    return shapelessRecipe;
                }
            }
        }

        return null;
    }

    private boolean matchItemsAccumulation(SmithingRecipe recipe, List<Item> inputList, Item primaryOutput) {
        Item recipeResult = recipe.getResult();
        if (primaryOutput.equals(recipeResult, recipeResult.hasMeta(), recipeResult.hasCompoundTag()) && primaryOutput.getCount() % recipeResult.getCount() == 0) {
            int multiplier = primaryOutput.getCount() / recipeResult.getCount();
            return recipe.matchItems(inputList, multiplier);
        }
        return false;
    }

    private boolean matchItemsAccumulation(CraftingRecipe recipe, List<Item> inputList, Item primaryOutput, List<Item> extraOutputList) {
        Item recipeResult = recipe.getResult();
        if (primaryOutput.equals(recipeResult, recipeResult.hasMeta(), recipeResult.hasCompoundTag()) && primaryOutput.getCount() % recipeResult.getCount() == 0) {
            int multiplier = primaryOutput.getCount() / recipeResult.getCount();
            return recipe.matchItems(inputList, extraOutputList, multiplier);
        }
        return false;
    }

    @Since("1.4.0.0-PN")
    public void registerMultiRecipe(MultiRecipe recipe) {
        this.multiRecipes.put(recipe.getId(), recipe);
    }

    public static class Entry {
        final int resultItemId;
        final int resultMeta;
        final int ingredientItemId;
        final int ingredientMeta;
        final String recipeShape;
        final int resultAmount;

        public Entry(int resultItemId, int resultMeta, int ingredientItemId, int ingredientMeta, String recipeShape, int resultAmount) {
            this.resultItemId = resultItemId;
            this.resultMeta = resultMeta;
            this.ingredientItemId = ingredientItemId;
            this.ingredientMeta = ingredientMeta;
            this.recipeShape = recipeShape;
            this.resultAmount = resultAmount;
        }
    }
}

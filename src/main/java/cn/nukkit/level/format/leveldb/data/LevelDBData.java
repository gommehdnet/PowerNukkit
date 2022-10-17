package cn.nukkit.level.format.leveldb.data;

import cn.nukkit.level.GameRule;
import cn.nukkit.level.GameRules;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.IntTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.utils.BinaryStream;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.util.*;

@Data
@Log4j2
public class LevelDBData {

    private static final Map<GameRule, Field> GAME_RULE_FIELDS = new HashMap<>();

    static {
        for (Field field : LevelDBData.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(GameRuleKey.class)) {
                field.setAccessible(true);
                GAME_RULE_FIELDS.put(field.getAnnotation(GameRuleKey.class).value(), field);
            }
        }
    }


    private final File dataFile;
    private CompoundTag compoundTag = new CompoundTag();

    private final Abilities abilities = new Abilities();
    private final Experiments experiments = new Experiments();
    private final List<Integer> lastOpenedWithVersion = new ArrayList<>();
    private final List<Integer> minimumCompatibleClientVersion = new ArrayList<>();
    @DataKey("bonusChestEnabled")
    private boolean bonusChestEnabled = false;
    @DataKey("bonusChestSpawned")
    private boolean bonusChestSpawned = false;
    @DataKey("commandblockoutput")
    @GameRuleKey(GameRule.COMMAND_BLOCK_OUTPUT)
    private boolean commandBlockOutput = false;
    @DataKey("CenterMapsToOrigin")
    private boolean centerMapsToOrigin = false;
    @DataKey("commandblocksenabled")
    @GameRuleKey(GameRule.COMMAND_BLOCKS_ENABLED)
    private boolean commandBlocksEnabled = false;
    @DataKey("commandsEnabled")
    private boolean commandsEnabled = false;
    @DataKey("ConfirmedPlatformLockedContent")
    private boolean confirmedPlatformLockedContent = false;
    @DataKey("dodaylightcycle")
    @GameRuleKey(GameRule.DO_DAYLIGHT_CYCLE)
    private boolean doDaylightCycle = true;
    @DataKey("doentitydrops")
    @GameRuleKey(GameRule.DO_ENTITY_DROPS)
    private boolean doEntityDrops = true;
    @DataKey("dofiretick")
    @GameRuleKey(GameRule.DO_FIRE_TICK)
    private boolean doFireTick = true;
    @DataKey("doimmediaterespawn")
    @GameRuleKey(GameRule.DO_IMMEDIATE_RESPAWN)
    private boolean doImmediateRespawn = false;
    @DataKey("doinsomnia")
    @GameRuleKey(GameRule.DO_INSOMNIA)
    private boolean doInsomnia = true;
    @DataKey("domobloot")
    @GameRuleKey(GameRule.DO_MOB_LOOT)
    private boolean doMobLoot = true;
    @DataKey("domobspawning")
    @GameRuleKey(GameRule.DO_MOB_SPAWNING)
    private boolean doMobSpawning = true;
    @DataKey("dotiledrops")
    @GameRuleKey(GameRule.DO_TILE_DROPS)
    private boolean doTileDrops = true;
    @DataKey("doweathercycle")
    @GameRuleKey(GameRule.DO_WEATHER_CYCLE)
    private boolean doWeatherCycle = true;
    @DataKey("drowningdamage")
    @GameRuleKey(GameRule.DROWNING_DAMAGE)
    private boolean drowningDamage = true;
    @DataKey("educationFeaturesEnabled")
    private boolean educationFeaturesEnabled = true;
    @DataKey("falldamage")
    @GameRuleKey(GameRule.FALL_DAMAGE)
    private boolean fallDamage = true;
    @DataKey("firedamage")
    @GameRuleKey(GameRule.FIRE_DAMAGE)
    private boolean fireDamage = true;
    @DataKey("freezedamage")
    @GameRuleKey(GameRule.FREEZE_DAMAGE)
    private boolean freezeDamage = true;
    @DataKey("ForceGameType")
    private boolean forceGameType = false;
    @DataKey("hasBeenLoadedInCreative")
    private boolean hasBeenLoadedInCreative = false;
    @DataKey("hasLockedBehaviorPack")
    private boolean hasLockedBehaviorPack = false;
    @DataKey("hasLockedResourcePack")
    private boolean hasLockedResourcePack = false;
    @DataKey("immutableWorld")
    private boolean immutableWorld = false;
    @DataKey("isFromLockedTemplate")
    private boolean isFromLockedTemplate = false;
    @DataKey("isFromWorldTemplate")
    private boolean isFromWorldTemplate = false;
    @DataKey("isSingleUseWorld")
    private boolean isSingleUseWorld = false;
    @DataKey("isWorldTemplateOptionLocked")
    private boolean isWorldTemplateOptionLocked = false;
    @DataKey("keepinventory")
    @GameRuleKey(GameRule.KEEP_INVENTORY)
    private boolean keepInventory = false;
    @DataKey("LANBroadcast")
    private boolean LANBroadcast = false;
    @DataKey("LANBroadcastIntent")
    private boolean LANBroadcastIntent = false;
    @DataKey("mobgriefing")
    @GameRuleKey(GameRule.MOB_GRIEFING)
    private boolean mobGriefing = true;
    @DataKey("MultiplayerGame")
    private boolean multiplayerGame = false;
    @DataKey("MultiplayerGameIntent")
    private boolean multiplayerGameIntent = false;
    @DataKey("naturalregeneration")
    @GameRuleKey(GameRule.NATURAL_REGENERATION)
    private boolean naturalRegeneration = true;
    @DataKey("pvp")
    @GameRuleKey(GameRule.PVP)
    private boolean pvp = true;
    @DataKey("requiresCopiedPackRemovalCheck")
    private boolean requiresCopiedPackRemovalCheck = false;
    @DataKey("sendcommandfeedback")
    @GameRuleKey(GameRule.SEND_COMMAND_FEEDBACK)
    private boolean sendCommandFeedback = true;
    @DataKey("showcoordinates")
    @GameRuleKey(GameRule.SHOW_COORDINATES)
    private boolean showCoordinates = true;
    @DataKey("showdeathmessages")
    @GameRuleKey(GameRule.SHOW_DEATH_MESSAGES)
    private boolean showDeathMessages = true;
    @DataKey("showtags")
    @GameRuleKey(GameRule.SHOW_TAGS)
    private boolean showTags = true;
    @DataKey("spawnMobs")
    private boolean spawnMobs = true;
    @DataKey("SpawnV1Villagers")
    private boolean spawnV1Villagers = false;
    @DataKey("startWithMapEnabled")
    private boolean startWithMapEnabled = false;
    @DataKey("texturePacksRequired")
    private boolean texturePacksRequired = false;
    @DataKey("tntexplodes")
    @GameRuleKey(GameRule.TNT_EXPLODES)
    private boolean tntExplodes = true;
    @DataKey("useMsaGamertagsOnly")
    private boolean useMsaGamertagsOnly = false;
    @DataKey("Difficulty")
    private int difficulty = 1;
    @DataKey("eduOffer")
    private int eduOffer = 0;
    @DataKey("functioncommandlimit")
    @GameRuleKey(GameRule.FUNCTION_COMMAND_LIMIT)
    private int functionCommandLimit = 0;
    @DataKey("Dimension")
    private int dimension = 0;
    @DataKey("GameType")
    private int gameType = 0;
    @DataKey("Generator")
    private int generator = 1;
    @DataKey("lightningTime")
    private int lightningTime = 0;
    @DataKey("LimitedWorldOriginX")
    private int limitedWorldOriginX = 0;
    @DataKey("LimitedWorldOriginY")
    private int limitedWorldOriginY = 0;
    @DataKey("LimitedWorldOriginZ")
    private int limitedWorldOriginZ = 0;
    @DataKey("LimitedWorldWidth")
    private int limitedWorldWidth = 16;
    @DataKey("LimitedWorldDepth")
    private int limitedWorldDepth = 16;
    @DataKey("maxcommandchainlength")
    @GameRuleKey(GameRule.MAX_COMMAND_CHAIN_LENGTH)
    private int maxCommandChainLength = 65536;
    @DataKey("NetherScale")
    private int netherScale = 8;
    @DataKey("NetworkVersion")
    private int networkVersion = 0;
    @DataKey("Platform")
    private int platform = 2;
    @DataKey("PlatformBroadcastIntent")
    private int platformBroadcastIntent = 0;
    @DataKey("rainTime")
    private int rainTime = 0;
    @DataKey("randomtickspeed")
    @GameRuleKey(GameRule.RANDOM_TICK_SPEED)
    private int randomTickSpeed = 1;
    @DataKey("serverChunkTickRange")
    private int serverChunkTickRange = 10;
    @DataKey("spawnradius")
    @GameRuleKey(GameRule.SPAWN_RADIUS)
    private int spawnRadius = 10;
    @DataKey("SpawnX")
    private int spawnX = 0;
    @DataKey("SpawnY")
    private int spawnY = 64;
    @DataKey("SpawnZ")
    private int spawnZ = 0;
    @DataKey("StorageVersion")
    private int storageVersion = 8;
    @DataKey("XBLBroadcastIntent")
    private int XBLBroadcastIntent = 3;
    @DataKey("currentTick")
    private long currentTick = 0;
    @DataKey("LastPlayed")
    private long lastPlayed = 0;
    @DataKey("RandomSeed")
    private long randomSeed = 0;
    @DataKey("Time")
    private long time = 0;
    @DataKey("worldStartCount")
    private long worldStartCount = 0;
    @DataKey("lightningLevel")
    private float lightningLevel = 0.0F;
    @DataKey("rainLevel")
    private float rainLevel = 0.0F;
    @DataKey("baseGameVersion")
    private String baseGameVersion = "";
    @DataKey("FlatWorldLayers")
    private String flatWorldLayers = "{\"biome_id\":1,\"block_layers\":[{\"block_data\":0,\"block_id\":7,\"count\":1},{\"block_data\":0,\"block_id\":3,\"count\":2},{\"block_data\":0,\"block_id\":2,\"count\":1}],\"encoding_version\":3,\"structure_options\":null}";
    @DataKey("InventoryVersion")
    private String inventoryVersion = "";
    @DataKey("LevelName")
    private String levelName = "";
    @DataKey("prid")
    private String prid = "";

    public LevelDBData(File dataFile) {
        this.dataFile = dataFile;
    }


    public void load() throws IOException {
        if (!this.dataFile.exists()) {
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(this.dataFile);
        fileInputStream.skip(8);
        compoundTag = (CompoundTag) NBTIO.readTag(fileInputStream, ByteOrder.LITTLE_ENDIAN, false);

        if (compoundTag.getCompound("abilities") != null) {
            abilities.load(compoundTag.getCompound("abilities"));
        }
        if (compoundTag.getCompound("experiments") != null) {
            experiments.load(compoundTag.getCompound("experiments"));
        }

        if (compoundTag.getList("lastOpenedWithVersion") != null) {
            lastOpenedWithVersion.clear();
            for (IntTag openedWithVersion : compoundTag.getList("lastOpenedWithVersion", IntTag.class).getAll()) {
                lastOpenedWithVersion.add(openedWithVersion.data);
            }
        }

        if (compoundTag.getList("MinimumCompatibleClientVersion") != null) {
            minimumCompatibleClientVersion.clear();
            for (IntTag minimumCompatibleVersion : compoundTag.getList("MinimumCompatibleClientVersion", IntTag.class).getAll()) {
                minimumCompatibleClientVersion.add(minimumCompatibleVersion.data);
            }
        }

        loadFields(this, compoundTag);
    }


    public void save() throws IOException {
        abilities.save(compoundTag.getCompound("abilities"));
        experiments.save(compoundTag.getCompound("experiments"));

        ListTag<IntTag> lastOpenedWithVersionList = new ListTag<>("lastOpenedWithVersion");
        for (Integer integer : lastOpenedWithVersion) {
            lastOpenedWithVersionList.add(new IntTag("", integer));
        }
        compoundTag.putList(lastOpenedWithVersionList);

        ListTag<IntTag> minimumCompatibleClientVersionList = new ListTag<>("MinimumCompatibleClientVersion");
        for (Integer integer : minimumCompatibleClientVersion) {
            minimumCompatibleClientVersionList.add(new IntTag("", integer));
        }
        compoundTag.putList(minimumCompatibleClientVersionList);

        saveFields(this, compoundTag);
        this.dataFile.getParentFile().mkdirs();

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(this.dataFile);
                ByteArrayOutputStream payloadStream = new ByteArrayOutputStream();) {
            BinaryStream outputStream = new BinaryStream();

            NBTIO.write(compoundTag, payloadStream, ByteOrder.LITTLE_ENDIAN, false);
            outputStream.putLInt(8);
            outputStream.putLInt(payloadStream.size());
            outputStream.put(payloadStream.toByteArray());
            fileOutputStream.write(outputStream.getBuffer());
            fileOutputStream.flush();

        }

        Files.write(new File(dataFile.getParent(), "levelname.txt").toPath(), Arrays.asList(levelName));

    }

    public GameRules getGameRules() {
        GameRules gameRules = GameRules.getDefault();

        for (GameRule gameRule : GAME_RULE_FIELDS.keySet()) {
            Field field = GAME_RULE_FIELDS.get(gameRule);
            try {
                Object value = field.get(this);
                if (field.getType() == boolean.class) {
                    gameRules.setGameRule(gameRule, (boolean) value);
                } else if (field.getType() == int.class) {
                    gameRules.setGameRule(gameRule, (int) value);
                } else if (field.getType() == float.class) {
                    gameRules.setGameRule(gameRule, (float) value);
                } else {
                    log.warn("Invalid GameRule Value Type " + field.getType().getName() + " for " + gameRule.getName());
                }
            } catch (IllegalAccessException e) {
                log.error("Failed to get value of field " + field.getName(), e);
            }

        }

        return gameRules;
    }

    public void setGameRuleFields(GameRules gameRules) throws IllegalAccessException {
        for (GameRule gameRule : gameRules.getGameRules().keySet()) {
            if (GAME_RULE_FIELDS.containsKey(gameRule)) {
                Field field = GAME_RULE_FIELDS.get(gameRule);
                if (field.getType() == boolean.class) {
                    field.set(this, gameRules.getBoolean(gameRule));
                } else if (field.getType() == int.class) {
                    field.set(this, gameRules.getInteger(gameRule));
                } else if (field.getType() == float.class) {
                    field.set(this, gameRules.getFloat(gameRule));
                } else {
                    log.warn("Invalid GameRule Value Type " + field.getType().getName() + " for " + gameRule.getName());
                }
            }
        }
    }

    @Data
    public static class Abilities {
        @DataKey("attackmobs")
        private boolean attackMobs = true;
        @DataKey("attackplayers")
        private boolean attackPlayers = true;
        @DataKey("build")
        private boolean build = true;
        @DataKey("doorsandswitches")
        private boolean doorsAndSwitches = true;
        @DataKey("flying")
        private boolean flying = true;
        @DataKey("instabuild")
        private boolean instaBuild = true;
        @DataKey("invulnerable")
        private boolean invulnerable = true;
        @DataKey("lightning")
        private boolean lightning = true;
        @DataKey("mayfly")
        private boolean mayfly = true;
        @DataKey("mine")
        private boolean mine = true;
        @DataKey("op")
        private boolean op = true;
        @DataKey("opencontainers")
        private boolean openContainers = true;
        @DataKey("teleport")
        private boolean teleport = true;
        @DataKey("permissionLevel")
        private int permissionsLevel = 0;
        @DataKey("playerPermissionLevel")
        private int playerPermissionsLevel = 0;
        @DataKey("flySpeed")
        private float flySpeed = 0.05F;
        @DataKey("walkSpeed")
        private float walkSpeed = 0.1F;

        public void load(CompoundTag abilities) {
            loadFields(this, abilities);
        }

        public void save(CompoundTag abilities) {
            saveFields(this, abilities);
        }


    }

    @Data
    public static class Experiments {

        @DataKey("experiments_ever_used")
        private boolean experimentsEverUsed = false;
        @DataKey("saved_with_toggled_experiments")
        private boolean savedWithToggledExperiments = false;

        public void load(CompoundTag experiments) {
            loadFields(this, experiments);
        }

        public void save(CompoundTag experiments) {
            saveFields(this, experiments);
        }

    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface DataKey {
        String value();
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface GameRuleKey {
        GameRule value();
    }


    private static void loadFields(Object object, CompoundTag compoundTag) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(DataKey.class)) {
                field.setAccessible(true);
                DataKey dataKey = field.getAnnotation(DataKey.class);
                String key = dataKey.value();
                if (compoundTag.contains(key)) {
                    try {
                        if (field.getType() == boolean.class) {
                            field.setBoolean(object, compoundTag.getBoolean(dataKey.value()));
                        } else if (field.getType() == int.class) {
                            field.setInt(object, compoundTag.getInt(dataKey.value()));
                        } else if (field.getType() == long.class) {
                            field.setLong(object, compoundTag.getLong(dataKey.value()));
                        } else if (field.getType() == float.class) {
                            field.setFloat(object, compoundTag.getFloat(dataKey.value()));
                        } else if (field.getType() == String.class) {
                            field.set(object, compoundTag.getString(dataKey.value()));
                        }
                    } catch (IllegalAccessException e) {
                        System.err.println("Failed to load field " + field.getName() + " from " + object.getClass().getSimpleName());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void saveFields(Object object, CompoundTag compoundTag) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(DataKey.class)) {
                field.setAccessible(true);
                DataKey dataKey = field.getAnnotation(DataKey.class);
                String key = dataKey.value();
                try {
                    if (field.getType() == boolean.class) {
                        compoundTag.putBoolean(key, field.getBoolean(object));
                    } else if (field.getType() == int.class) {
                        compoundTag.putInt(key, field.getInt(object));
                    } else if (field.getType() == long.class) {
                        compoundTag.putLong(key, field.getLong(object));
                    } else if (field.getType() == float.class) {
                        compoundTag.putFloat(key, field.getFloat(object));
                    } else if (field.getType() == String.class) {
                        compoundTag.putString(key, compoundTag.getString(dataKey.value()));
                    }
                } catch (IllegalAccessException e) {
                    System.err.println("Failed to save field " + field.getName() + " from " + object.getClass().getSimpleName());
                    e.printStackTrace();
                }

            }
        }
    }


}

package cn.nukkit.network.protocol.types;

/**
 * @author Kaooot
 * @version 1.0
 */
public enum CommandOriginType {

    PLAYER,
    BLOCK,
    MINECART_BLOCK,
    DEV_CONSOLE,
    TEST,
    AUTOMATION_PLAYER,
    CLIENT_AUTOMATION,
    DEDICATED_SERVER,
    ENTITY,
    VIRTUAL,
    GAME_ARGUMENT,
    ENTITY_SERVER,
    PRECOMPILED,
    GAME_DIRECTOR_ENTITY_SERVER,
    SCRIPT,
    EXECUTOR
}
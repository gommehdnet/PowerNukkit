package cn.nukkit.network.protocol.types;

/**
 * @author Kaooot
 * @version 1.0
 */
public enum ItemStackRequestFilterCause {

    SERVER_CHAT_PUBLIC,
    SERVER_CHAT_WHISPER,
    SIGN_TEXT,
    ANVIL_TEXT,
    BOOK_AND_QUILL_TEXT,
    COMMAND_BLOCK_TEXT,
    BLOCK_ACTOR_DATA_TEXT,
    JOIN_EVENT_TEXT,
    LEAVE_EVENT_TEXT,
    SLASH_COMMAND_CHAT,
    CARTOGRAPHY_TEXT,
    SLASH_COMMAND_NON_CHAT
}
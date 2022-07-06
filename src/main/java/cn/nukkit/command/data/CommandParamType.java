package cn.nukkit.command.data;

import cn.nukkit.utils.BedrockMappingUtil;

/**
 * @author CreeperFace
 */
public enum CommandParamType {
    INT,
    FLOAT,
    VALUE,
    WILDCARD_INT,
    TARGET,
    WILDCARD_TARGET,
    STRING,
    BLOCK_POSITION,
    POSITION,
    MESSAGE,
    RAWTEXT,
    JSON,
    TEXT, // backwards compatibility
    COMMAND,
    FILE_PATH,
    OPERATOR;

    public int getId(int protocol) {
        return BedrockMappingUtil.translateCommandParameter(protocol, this.name().toLowerCase());
    }
}
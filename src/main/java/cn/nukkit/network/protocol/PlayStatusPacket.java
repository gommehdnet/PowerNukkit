package cn.nukkit.network.protocol;

import lombok.ToString;

/**
 * @since 15-10-13
 */
@ToString
public class PlayStatusPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.PLAY_STATUS_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public static final int LOGIN_SUCCESS = 0;
    public static final int LOGIN_FAILED_CLIENT = 1;
    public static final int LOGIN_FAILED_SERVER = 2;
    public static final int PLAYER_SPAWN = 3;
    public static final int LOGIN_FAILED_INVALID_TENANT = 4;
    public static final int LOGIN_FAILED_EDITION_MISMATCH_EDU_TO_VANILLA = 5;
    public static final int LOGIN_FAILED_EDITION_MISMATCH_VANILLA_TO_EDU = 6;
    public static final int FAILED_SERVER_FULL_SUB_CLIENT = 7;
    public static final int EDITOR_TO_VANILLA_MISMATCH = 8;
    public static final int VANILLA_TO_EDITOR_MISMATCH = 9;

    public int status;

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putInt(this.status);
    }

}

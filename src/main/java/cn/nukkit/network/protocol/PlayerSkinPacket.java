package cn.nukkit.network.protocol;

import cn.nukkit.entity.data.Skin;
import lombok.ToString;

import java.util.UUID;

@ToString
public class PlayerSkinPacket extends DataPacket {

    public UUID uuid;
    public Skin skin;
    public String newSkinName;
    public String oldSkinName;

    @Override
    public byte pid() {
        return ProtocolInfo.PLAYER_SKIN_PACKET;
    }

    @Override
    public void decode() {
        uuid = getUUID();
        skin = getSkin(this.gameVersion);
        newSkinName = getString();
        oldSkinName = getString();
        if (!feof()) { // -facepalm-
            //skin.setTrusted(getBoolean());
            getBoolean();
        }

        skin.setTrusted(true);
    }

    @Override
    public void encode() {
        reset();
        putUUID(uuid);
        putSkin(skin, this.gameVersion);
        putString(newSkinName);
        putString(oldSkinName);
        putBoolean(skin.isTrusted());
    }
}

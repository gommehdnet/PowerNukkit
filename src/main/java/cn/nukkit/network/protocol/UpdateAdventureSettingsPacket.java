package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class UpdateAdventureSettingsPacket extends DataPacket {

    public boolean noPvM;
    public boolean noMvP;
    public boolean immutableWorld;
    public boolean showNameTags;
    public boolean autoJump;

    @Override
    public byte pid() {
        return ProtocolInfo.UPDATE_ADVENTURE_SETTINGS_PACKET;
    }

    @Override
    public void decode() {
        this.noPvM = this.getBoolean();
        this.noMvP = this.getBoolean();
        this.immutableWorld = this.getBoolean();
        this.showNameTags = this.getBoolean();
        this.autoJump = this.getBoolean();
    }

    @Override
    public void encode() {
        this.reset();
        this.putBoolean(this.noPvM);
        this.putBoolean(this.noMvP);
        this.putBoolean(this.immutableWorld);
        this.putBoolean(this.showNameTags);
        this.putBoolean(this.autoJump);
    }
}
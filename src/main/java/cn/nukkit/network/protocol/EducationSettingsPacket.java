package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class EducationSettingsPacket extends DataPacket {

    public String codeBuilderUri;
    public String codeBuilderTitle;
    public boolean canResizeCodeBuilder;
    public boolean disableLegacyTitle;
    public String postProcessFilter;
    public String screenshotBorderPath;
    public boolean entityCapabilities;
    public boolean overrideUri;
    public boolean quizAttached;
    public boolean externalLinkSettings;

    @Override
    public byte pid() {
        return ProtocolInfo.EDUCATION_SETTINGS_PACKET;
    }

    @Override
    public void decode() {
        this.codeBuilderUri = this.getString();
        this.codeBuilderTitle = this.getString();
        this.canResizeCodeBuilder = this.getBoolean();
        this.disableLegacyTitle = this.getBoolean();
        this.postProcessFilter = this.getString();
        this.screenshotBorderPath = this.getString();
        this.entityCapabilities = this.getBoolean();
        this.overrideUri = this.getBoolean();
        this.quizAttached = this.getBoolean();
        this.externalLinkSettings = this.getBoolean();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.codeBuilderUri);
        this.putString(this.codeBuilderTitle);
        this.putBoolean(this.canResizeCodeBuilder);
        this.putBoolean(this.disableLegacyTitle);
        this.putString(this.postProcessFilter);
        this.putString(this.screenshotBorderPath);
        this.putBoolean(this.entityCapabilities);
        this.putBoolean(this.overrideUri);
        this.putBoolean(this.quizAttached);
        this.putBoolean(this.externalLinkSettings);
    }
}
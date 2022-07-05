package cn.nukkit.network.protocol;

import cn.nukkit.math.Vector3f;
import cn.nukkit.network.protocol.types.ClientboundDebugRendererType;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ClientboundDebugRendererPacket extends DataPacket {

    public ClientboundDebugRendererType debugMarkerType;
    public String markerText;
    public Vector3f markerPosition;
    public float markerColorRed;
    public float markerColorGreen;
    public float markerColorBlue;
    public float markerColorAlpha;
    public long markerDuration;

    @Override
    public byte pid() {
        return ProtocolInfo.CLIENTBOUND_DEBUG_RENDERER_PACKET;
    }

    @Override
    public void decode() {
        this.debugMarkerType = ClientboundDebugRendererType.values()[(int) this.getUnsignedVarInt()];
        this.markerText = this.getString();
        this.markerPosition = this.getVector3f();
        this.markerColorRed = this.getFloat();
        this.markerColorGreen = this.getFloat();
        this.markerColorBlue = this.getFloat();
        this.markerColorAlpha = this.getFloat();
        this.markerDuration = this.getLLong();
    }

    @Override
    public void encode() {
        this.putUnsignedVarInt(this.debugMarkerType.ordinal());
        this.putString(this.markerText);
        this.putVector3f(this.markerPosition);
        this.putFloat(this.markerColorRed);
        this.putFloat(this.markerColorGreen);
        this.putFloat(this.markerColorBlue);
        this.putFloat(this.markerColorAlpha);
        this.putLLong(this.markerDuration);
    }
}
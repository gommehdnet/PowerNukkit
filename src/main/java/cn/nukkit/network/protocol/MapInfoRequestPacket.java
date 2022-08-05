package cn.nukkit.network.protocol;

import cn.nukkit.math.Vector2;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.ToString;

import java.util.List;

/**
 * @author CreeperFace
 * @since 5.3.2017
 */
@ToString
public class MapInfoRequestPacket extends DataPacket {

    public long mapId;
    public List<Vector2> requestedPixels = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.MAP_INFO_REQUEST_PACKET;
    }

    @Override
    public void decode() {
        this.mapId = this.getEntityUniqueId();

        if (this.protocolVersion >= Protocol.V1_19_20.version()) {
            final int requestedPixelsLength = this.getLInt();

            for (int i = 0; i < requestedPixelsLength; i++) {
                final int x = this.getLInt();
                final int y = this.getLShort();

                this.requestedPixels.add(new Vector2(x, y));
            }
        }
    }

    @Override
    public void encode() {
        this.putEntityUniqueId(this.mapId);

        if (this.protocolVersion >= Protocol.V1_19_20.version()) {
            this.putLInt(this.requestedPixels.size());

            for (Vector2 pixel : this.requestedPixels) {
                this.putLInt((int) pixel.x);
                this.putLShort((int) pixel.y);
            }
        }
    }
}
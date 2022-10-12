package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.MapPixel;
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
    public List<MapPixel> pixels = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.MAP_INFO_REQUEST_PACKET;
    }

    @Override
    public void decode() {
        this.mapId = this.getEntityUniqueId();

        final int pixelsLength = this.getLInt();

        for (int i = 0; i < pixelsLength; i++) {
            final int pixel = this.getLInt();
            final int index = this.getLShort();

            this.pixels.add(new MapPixel(pixel, index));
        }
    }

    @Override
    public void encode() {
        this.putEntityUniqueId(this.mapId);

        this.putLInt(this.pixels.size());

        for (MapPixel pixel : this.pixels) {
            this.putLInt(pixel.getPixel());
            this.putLShort(pixel.getIndex());
        }
    }
}
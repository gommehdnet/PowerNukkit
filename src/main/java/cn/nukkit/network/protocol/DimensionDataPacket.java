package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.DimensionData;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class DimensionDataPacket extends DataPacket {

    public List<DimensionData> dimensions = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.DIMENSION_DATA_PACKET;
    }

    @Override
    public void decode() {
        final int dimensionsLength = this.getVarInt();

        for (int i = 0; i < dimensionsLength; i++) {
            this.dimensions.add(new DimensionData(this.getString(), this.getVarInt(), this.getVarInt(), DimensionData.Generator.values()[this.getVarInt()]));
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putVarInt(this.dimensions.size());

        for (DimensionData dimension : this.dimensions) {
            this.putString(dimension.getId());
            this.putVarInt(dimension.getMaxHeight());
            this.putVarInt(dimension.getMinHeight());
            this.putVarInt(dimension.getGenerator().ordinal());
        }
    }
}
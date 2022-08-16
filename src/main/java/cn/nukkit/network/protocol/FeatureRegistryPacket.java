package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.FeatureData;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class FeatureRegistryPacket extends DataPacket {

    public List<FeatureData> features = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.FEATURE_REGISTRY_PACKET;
    }

    @Override
    public void decode() {
        int featureDataLength = (int) this.getUnsignedVarInt();

        for (int i = 0; i < featureDataLength; i++) {
            this.features.add(new FeatureData(this.getString(), this.getString()));
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarInt(this.features.size());

        for (FeatureData featureData : this.features) {
            this.putString(featureData.getName());
            this.putString(featureData.getJson());
        }
    }
}
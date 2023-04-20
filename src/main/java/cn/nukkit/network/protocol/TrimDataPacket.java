package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.TrimMaterial;
import cn.nukkit.network.protocol.types.TrimPattern;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class TrimDataPacket extends DataPacket {

    public final List<TrimPattern> patterns = new ObjectArrayList<>();
    public final List<TrimMaterial> materials = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.TRIM_DATA_PACKET;
    }

    @Override
    public void decode() {
        final int patterns = (int) this.getUnsignedVarInt();

        for (int i = 0; i < patterns; i++) {
            final String itemName = this.getString();
            final String patternId = this.getString();

            this.patterns.add(new TrimPattern(itemName, patternId));
        }

        final int materials = (int) this.getUnsignedVarInt();

        for (int i = 0; i < materials; i++) {
            final String materialId = this.getString();
            final String color = this.getString();
            final String itemName = this.getString();

            this.materials.add(new TrimMaterial(materialId, color, itemName));
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarInt(this.patterns.size());

        for (TrimPattern pattern : this.patterns) {
            this.putString(pattern.getItemName());
            this.putString(pattern.getPatternId());
        }

        for (TrimMaterial material : this.materials) {
            this.putString(material.getMaterialId());
            this.putString(material.getColor());
            this.putString(material.getItemName());
        }
    }
}
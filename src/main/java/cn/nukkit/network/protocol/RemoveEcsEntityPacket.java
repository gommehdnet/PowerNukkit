package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class RemoveEcsEntityPacket extends DataPacket {

    public long networkId;

    @Override
    public byte pid() {
        return ProtocolInfo.REMOVE_ECS_ENTITY_PACKET;
    }

    @Override
    public void decode() {
        this.networkId = this.getUnsignedVarLong();
    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarLong(this.networkId);
    }
}
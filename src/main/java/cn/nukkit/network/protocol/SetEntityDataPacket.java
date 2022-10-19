package cn.nukkit.network.protocol;

import cn.nukkit.api.Since;
import cn.nukkit.entity.data.EntityMetadata;
import cn.nukkit.network.protocol.types.EntityProperties;
import cn.nukkit.utils.Binary;
import lombok.ToString;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@ToString
public class SetEntityDataPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.SET_ENTITY_DATA_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public long eid;
    public EntityMetadata metadata;
    @Since("1.4.0.0-PN")
    public long frame;
    private final EntityProperties entityProperties = new EntityProperties();

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putEntityRuntimeId(this.eid);
        this.put(Binary.writeMetadata(this.metadata));

        if (this.protocolVersion >= Protocol.V1_19_40.version()) {
            this.putEntityProperties(this.entityProperties);
        }

        this.putUnsignedVarLong(this.frame);
    }
}

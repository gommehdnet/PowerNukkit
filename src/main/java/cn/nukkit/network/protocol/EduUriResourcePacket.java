package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.EducationSharedResourceURI;

/**
 * @author Kaooot
 * @version 1.0
 */
public class EduUriResourcePacket extends DataPacket {

    public EducationSharedResourceURI resource;

    @Override
    public byte pid() {
        return ProtocolInfo.EDU_URI_RESOURCE_PACKET;
    }

    @Override
    public void decode() {
        this.resource = new EducationSharedResourceURI(this.getString(), this.getString());
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.resource.getButtonName());
        this.putString(this.resource.getLinkUri());
    }
}
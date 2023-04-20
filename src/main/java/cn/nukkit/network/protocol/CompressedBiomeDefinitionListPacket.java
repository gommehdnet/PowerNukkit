package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class CompressedBiomeDefinitionListPacket extends DataPacket {

    public byte[] definitions;
    public String dictionaryLookup;

    @Override
    public byte pid() {
        return ProtocolInfo.COMPRESSED_BIOME_DEFINITION_LIST_PACKET;
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.put(this.definitions);
        this.putString(this.dictionaryLookup);
    }
}
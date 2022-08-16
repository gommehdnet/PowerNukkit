package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.CommandOriginData;
import cn.nukkit.network.protocol.types.CommandOutput;
import cn.nukkit.network.protocol.types.CommandOutputType;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class CommandOutputPacket extends DataPacket {

    public CommandOriginData origin;
    public CommandOutputType outputType;
    public int successCount;
    public List<CommandOutput> outputs = new ArrayList<>();
    public String dataSet = "";

    @Override
    public byte pid() {
        return ProtocolInfo.COMMAND_OUTPUT_PACKET;
    }

    @Override
    public void decode() {
        this.origin = this.getCommandOrigin();
        this.outputType = CommandOutputType.values()[this.getByte()];
        this.successCount = (int) this.getUnsignedVarInt();

        final int outputLength = (int) this.getUnsignedVarInt();

        for (int i = 0; i < outputLength; i++) {
            final boolean success = this.getBoolean();
            final String messageId = this.getString();
            final int parametersLength = (int) this.getUnsignedVarInt();

            final List<String> parameters = new ObjectArrayList<>();

            for (int j = 0; j < parametersLength; j++) {
                parameters.add(this.getString());
            }

            this.outputs.add(new CommandOutput(success, messageId, parameters));
        }

        if (this.outputType.equals(CommandOutputType.DATA_SET)) {
            this.dataSet = this.getString();
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putCommandOrigin(this.origin);
        this.putByte((byte) this.outputType.ordinal());
        this.putUnsignedVarInt(this.successCount);

        this.putUnsignedVarInt(this.outputs.size());

        for (CommandOutput output : this.outputs) {
            this.putBoolean(output.isSuccess());
            this.putString(output.getMessageId());

            this.putUnsignedVarInt(output.getParameters().size());

            for (String parameter : output.getParameters()) {
                this.putString(parameter);
            }
        }

        if (this.outputType.equals(CommandOutputType.DATA_SET)) {
            this.putString(this.dataSet);
        }
    }
}
package cn.nukkit.network.protocol;

import lombok.ToString;

@ToString
public class AddBehaviorTreePacket extends DataPacket {

    public String behaviorTree;

    @Override
    public byte pid() {
        return ProtocolInfo.ADD_BEHAVIOR_TREE_PACKET;
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.behaviorTree);
    }
}
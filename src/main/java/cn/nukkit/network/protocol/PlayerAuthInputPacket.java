package cn.nukkit.network.protocol;

import cn.nukkit.math.Vector3f;
import cn.nukkit.network.protocol.types.*;
import cn.nukkit.network.protocol.types.transaction.Transaction;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * @author Kaooot
 * @version 1.0
 */
public class PlayerAuthInputPacket extends DataPacket {

    public float yaw;
    public float pitch;
    public Vector3f position;
    public Vector3f rotation;
    public Set<PlayerAuthInputData> inputData = EnumSet.noneOf(PlayerAuthInputData.class);
    public PlayerAuthInputMode inputMode;
    public PlayerAuthPlayMode playMode;
    public AuthInteractionModel interactionModel;
    public Vector3f vrGazeDirection;
    public long tick;
    public Vector3f delta;
    public Transaction transaction;
    public ItemStackRequest itemStackRequest;
    public List<BlockAction> blockActions = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.PLAYER_AUTH_INPUT_PACKET;
    }

    @Override
    public void decode() {
        this.pitch = this.getLFloat();
        this.yaw = this.getLFloat();
        this.position = this.getVector3f();
        this.rotation = this.getVector3f();

        long inputFlag = this.getUnsignedVarLong();

        for (PlayerAuthInputData playerAuthInputData : PlayerAuthInputData.values()) {
            if ((inputFlag & (1L << playerAuthInputData.ordinal())) != 0) {
                this.inputData.add(playerAuthInputData);
            }
        }

        this.inputMode = PlayerAuthInputMode.values()[(int) this.getUnsignedVarInt()];
        this.playMode = PlayerAuthPlayMode.values()[(int) this.getUnsignedVarInt()];
        this.interactionModel = AuthInteractionModel.values()[(int) this.getUnsignedVarInt()];

        if (this.playMode.equals(PlayerAuthPlayMode.REALITY)) {
            this.vrGazeDirection = this.getVector3f();
        }

        this.tick = this.getUnsignedVarLong();
        this.delta = this.getVector3f();

        if (this.inputData.contains(PlayerAuthInputData.PERFORM_ITEM_STACK_REQUEST)) {
            this.itemStackRequest = this.getItemStackRequest(this.protocolVersion);
        }

        if (this.inputData.contains(PlayerAuthInputData.PERFORM_BLOCK_ACTIONS)) {
            final int blockActionsLength = this.getVarInt();

            for (int i = 0; i < blockActionsLength; i++) {
                final BlockAction.Action action = BlockAction.Action.values()[this.getVarInt()];

                switch (action) {
                    case START_BREAK:
                    case ABORT_BREAK:
                    case CRACK_BREAK:
                    case PREDICT_BREAK:
                    case CONTINUE_BREAK:
                        this.blockActions.add(new BlockAction(action, this.getSignedBlockPosition(), this.getVarInt()));

                        break;
                }
            }
        }
    }

    @Override
    public void encode() {

    }
}
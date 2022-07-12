package cn.nukkit.network.protocol;

import cn.nukkit.math.BlockVector3;
import cn.nukkit.math.Vector3f;
import cn.nukkit.network.protocol.types.*;
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
        this.yaw = this.getLFloat();
        this.pitch = this.getLFloat();
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

        if (this.playMode.equals(PlayerAuthPlayMode.REALITY)) {
            this.vrGazeDirection = this.getVector3f();
        }

        this.tick = this.getUnsignedVarLong();
        this.delta = this.getVector3f();

        if (this.inputData.contains(PlayerAuthInputData.PERFORM_ITEM_INTERACTION)) {
            this.transaction = this.getTransaction(this.protocolVersion);
        }

        if (this.inputData.contains(PlayerAuthInputData.PERFORM_ITEM_STACK_REQUEST)) {
            this.itemStackRequest = this.getItemStackRequest();
        }

        if (this.inputData.contains(PlayerAuthInputData.PERFORM_BLOCK_ACTIONS)) {
            final int blockActionsLength = (int) this.getUnsignedVarInt();

            for (int i = 0; i < blockActionsLength; i++) {
                final BlockAction.Action action = BlockAction.Action.values()[(int) this.getUnsignedVarInt()];
                BlockVector3 position = null;
                int face = -1;

                if (action.equals(BlockAction.Action.START_BREAK) || action.equals(BlockAction.Action.ABORT_BREAK) || action.equals(BlockAction.Action.CRACK_BREAK) || action.equals(BlockAction.Action.PREDICT_BREAK) || action.equals(BlockAction.Action.CONTINUE_BREAK)) {
                    position = this.getBlockVector3();
                    face = (int) this.getUnsignedVarInt();
                }

                this.blockActions.add(new BlockAction(action, position, face));
            }
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putLFloat(this.pitch);
        this.putLFloat(this.yaw);
        this.putVector3f(this.position);
        this.putVector3f(this.rotation);

        long inputFlag = 0L;

        for (final PlayerAuthInputData playerAuthInputData : this.inputData) {
            inputFlag |= (1L << playerAuthInputData.ordinal());
        }

        this.putUnsignedVarLong(inputFlag);

        this.putUnsignedVarInt(this.inputMode.ordinal());
        this.putUnsignedVarInt(this.playMode.ordinal());

        if (this.playMode.equals(PlayerAuthPlayMode.REALITY)) {
            this.putVector3f(this.vrGazeDirection);
        }

        this.putUnsignedVarLong(this.tick);
        this.putVector3f(this.delta);

        if (this.inputData.contains(PlayerAuthInputData.PERFORM_ITEM_INTERACTION)) {
            this.putTransaction(this.transaction, this.protocolVersion);
        }

        if (this.inputData.contains(PlayerAuthInputData.PERFORM_ITEM_STACK_REQUEST)) {
            this.putItemStackRequest(this.itemStackRequest);
        }

        if (this.inputData.contains(PlayerAuthInputData.PERFORM_BLOCK_ACTIONS)) {
            this.putUnsignedVarInt(this.blockActions.size());

            for (BlockAction blockAction : this.blockActions) {
                this.putUnsignedVarInt(blockAction.getAction().ordinal());

                if (blockAction.getAction().equals(BlockAction.Action.START_BREAK) || blockAction.getAction().equals(BlockAction.Action.ABORT_BREAK) || blockAction.getAction().equals(BlockAction.Action.CRACK_BREAK) || blockAction.getAction().equals(BlockAction.Action.PREDICT_BREAK) || blockAction.getAction().equals(BlockAction.Action.CONTINUE_BREAK)) {
                    this.putBlockVector3(blockAction.getPosition());
                    this.putUnsignedVarInt(blockAction.getFace());
                }
            }
        }
    }
}
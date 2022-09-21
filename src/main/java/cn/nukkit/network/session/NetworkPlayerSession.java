package cn.nukkit.network.session;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.types.CompressionAlgorithm;

/**
 * @author Kaooot
 * @version 1.0
 */
public interface NetworkPlayerSession {

    void sendPacket(DataPacket packet);

    void sendPacketImmediately(DataPacket packet, Runnable callback);

    void disconnect(String reason);

    Player getPlayer();

    void setCompression(CompressionAlgorithm compression);

    CompressionAlgorithm getCompression();
}
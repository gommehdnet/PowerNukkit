package cn.nukkit.utils;

import com.nukkitx.network.VarInts;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ForgeUtil {

    public static final byte[] fakeChunkDataOverworld;
    public static final byte[] fakeChunkDataNether;
    public static final byte[] fakeChunkDataEnd;

    static {
        // biomes count = max dimension height >> 4
        fakeChunkDataOverworld = ForgeUtil.createChunkData(24); // 384
        fakeChunkDataNether = ForgeUtil.createChunkData(8); // 128
        fakeChunkDataEnd = ForgeUtil.createChunkData(16); // 256
    }

    private static byte[] createChunkData(int biomeSections) {
        final ByteBuf buffer = Unpooled.buffer();

        buffer.writeByte(8); // section version
        buffer.writeByte(0); // zero block storages

        for (int i = 0; i < biomeSections; i++) {
            ForgeUtil.writePalette(buffer); // paletted biomes - 1.18
        }

        buffer.writeByte(0); // Borders

        byte[] data = new byte[buffer.readableBytes()];

        buffer.readBytes(data);

        return data;
    }

    private static void writePalette(ByteBuf buffer) {
        buffer.writeByte((1 << 1) | 1);  // runtime flag and palette id
        buffer.writeZero(512); // 128 * 4
        VarInts.writeInt(buffer, 1); // Palette size
        VarInts.writeInt(buffer, 0);
    }
}
package cn.nukkit.level.format.leveldb;

import cn.nukkit.level.Level;
import cn.nukkit.level.format.leveldb.data.LevelDBData;
import cn.nukkit.level.format.leveldb.data.LevelDBKeys;
import io.netty.buffer.ByteBuf;
import net.daporkchop.ldbjni.LevelDB;
import net.daporkchop.ldbjni.direct.DirectDB;
import org.iq80.leveldb.Options;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Base64;

public class BaseTests {
    public static void main(String[] args) throws IOException {
        /*System.out.println();
        LevelDBData levelDBData = new LevelDBData(new File("/Users/kaifi/Desktop/map_test/worlds/world/level.dat"));
        levelDBData.load();
        System.out.println(levelDBData);*/

        /*LevelDBFormat levelDBFormat = new LevelDBFormat(null, "./test_world");

        LevelDBChunk levelDBChunk = levelDBFormat.loadChunkI(Level.chunkHash(0, 0), 0, 0, true);*/

        /*DirectDB db = LevelDB.PROVIDER.open(new File("hns_map_converted/db/"), new Options().createIfMissing(true));

        db.iterator().forEachRemaining((entry) -> {
            System.out.println(new String(entry.getKey()) +  " -> " + entry.getValue());
        });*/

        DirectDB db = LevelDB.PROVIDER.open(new File("/Users/kaifi/Desktop/map_test/worlds/world/db"), new Options().createIfMissing(true));

        db.forEach(entry -> {
            byte[] key = entry.getKey();
            byte[] data = entry.getValue();
            ByteBuffer wrapped = ByteBuffer.wrap(key);
            int x = new BigInteger(reverseByteArray(Arrays.copyOfRange(key, 0, 4))).intValue();
            int z = new BigInteger(reverseByteArray(Arrays.copyOfRange(key, 4, 8))).intValue();
            if (key.length == 10) {
                byte subChunk = key[9];
                if (x == 2 && z == -2 && data.length > 570) {
                    System.out.println(Base64.getEncoder().encodeToString(key));
                    System.out.println(x + "," + subChunk +"," + z + " " + data.length);
                    try {
                        LevelDBChunkSection.read(data, subChunk);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        /*
        int dimension = 0;
        byte chunkVersion = db.get(LevelDBKeys.CHUNK_VERSION.getKey(0, 0))[0];
        System.out.println("ChunkVersion " + chunkVersion);


        if (dimension == 0) {
            for (int subChunkIndex = -4; subChunkIndex < 20; subChunkIndex++) {
                System.out.println("Loading subchunk " + subChunkIndex);
                 loadSubChunk(db, 0, 0, dimension, subChunkIndex + 4);
            }
        }*/
    }

    private static LevelDBChunkSection loadSubChunk(DirectDB db, int x, int z, int dimension, int subChunkIndex) throws IOException {
        byte[] subChunkData = db.get(LevelDBKeys.SUB_CHUNK_PREFIX.getSubKey(x, z, (byte) subChunkIndex));
        System.out.println("Subchunk data " + (subChunkData != null ? subChunkData.length : "null"));
        if (subChunkData == null) {
            subChunkData = new byte[]{9, 0, 0};
        }
        return LevelDBChunkSection.read(subChunkData, subChunkIndex);
    }

    private static byte[] reverseByteArray(byte[] input) {
        byte[] output = new byte[input.length];

        for (int i = 0; i < input.length; i++) {
            output[output.length - 1 - i] = input[i];
        }

        return output;
    }

}

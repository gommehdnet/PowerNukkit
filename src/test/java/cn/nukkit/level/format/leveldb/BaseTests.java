package cn.nukkit.level.format.leveldb;

import cn.nukkit.level.format.leveldb.data.LevelDBData;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    public static void main(String[] args) throws IOException {
        System.out.println();
        LevelDBData levelDBData = new LevelDBData(new File("/Users/kaifi/Desktop/map_test/worlds/world/level.dat"));
        levelDBData.load();
        System.out.println(levelDBData);

        /*DirectDB db = LevelDB.PROVIDER.open(new File("hns_map_converted/db/"), new Options().createIfMissing(true));

        db.iterator().forEachRemaining((entry) -> {
            System.out.println(new String(entry.getKey()) +  " -> " + entry.getValue());
        });*/
    }


}

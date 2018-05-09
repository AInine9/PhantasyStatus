package hugu1026.com.github.phantasystatus.manager;

import java.util.HashMap;

public class ExpDropManager {

    private static final HashMap<String, Long> MobExpDropList = new HashMap<>();

    static { //TODO remove test mob
        MobExpDropList.put("ゾンビ", 1L);
        MobExpDropList.put("テスト", 2L);
    }

    public static long SearchMobExpAmount(String name) {
        return MobExpDropList.getOrDefault(name, 0L);
    }
}

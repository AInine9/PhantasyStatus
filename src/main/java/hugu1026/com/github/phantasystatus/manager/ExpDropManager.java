package hugu1026.com.github.phantasystatus.manager;

import java.util.HashMap;

public class ExpDropManager {

    private static final HashMap<String, Integer> MobExpDropList = new HashMap<>();

    static {
        MobExpDropList.put("ゾンビ", 1);
        MobExpDropList.put("テスト", 2);
    }

    public static int SearchMobExpAmount(String name) {
        return MobExpDropList.get(name);
    }
}

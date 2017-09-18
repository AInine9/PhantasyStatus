package hugu1026.com.github.phantasystatus.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerDataUtil {

    public static void createPlayerDataYml(Player player) {
        String playerUUID = String.valueOf(player.getUniqueId());
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PhantasyStatus").getDataFolder(), File.separator + "player_data");
        File file = new File(userdata, File.separator + playerUUID + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                playerData.createSection("name");
                playerData.createSection("status");
                playerData.createSection("point");

                playerData.set("name", player.getName());
                playerData.set("status.level", 1);
                playerData.set("status.exp", 0);
                playerData.set("status.HP", 20);
                playerData.set("status.attack", 10);
                playerData.set("status.defend", 10);
                playerData.set("status.magic", 10);
                playerData.set("point.all", 5);
                playerData.set("point.health", 0);
                playerData.set("point.attack", 0);
                playerData.set("point.defend", 0);
                playerData.set("point.magic", 0);

                playerData.save(file);
            } catch (IOException expection) {
                expection.printStackTrace();
            }
        }
    }

    public static File getPlayerFile(Player player) {
        String playerUUID = String.valueOf(player.getUniqueId());
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PhantasyStatus").getDataFolder(), File.separator + "player_data");
        File playerFile = new File(userdata, File.separator + playerUUID + ".yml");
        return playerFile;
    }
}

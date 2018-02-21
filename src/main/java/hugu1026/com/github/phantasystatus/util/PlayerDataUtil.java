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
        File userData = new File(Bukkit.getServer().getPluginManager().getPlugin("PhantasyStatus").getDataFolder(), File.separator + "player_data");
        File file = new File(userData, File.separator + playerUUID + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                playerData.createSection("name");
                playerData.createSection("panel");
                playerData.createSection("status");
                playerData.createSection("point");
                playerData.createSection("magicAmountLimit");

                playerData.set("name", player.getName());
                playerData.set("panel", 1);
                playerData.set("status.level", 1);
                playerData.set("status.totalExp", 0);
                playerData.set("status.reqExp", 4);
                playerData.set("status.HP", 20);
                playerData.set("status.attack", 10);
                playerData.set("status.defend", 10);
                playerData.set("status.magic", 10);
                playerData.set("status.mana", 50);
                playerData.set("status.addition.HP", 0);
                playerData.set("status.addition.attack", 0);
                playerData.set("status.addition.defend", 0);
                playerData.set("status.addition.magic", 0);
                playerData.set("status.addition.mana", 0);
                playerData.set("point.all", 5);
                playerData.set("point.health", 0);
                playerData.set("point.attack", 0);
                playerData.set("point.defend", 0);
                playerData.set("point.magic", 0);
                playerData.set("magicAmountLimit", 3);

                playerData.save(file);
            } catch (IOException expection) {
                expection.printStackTrace();
            }
        }
    }

    public static File getPlayerFile(Player player) {
        String playerUUID = String.valueOf(player.getUniqueId());
        File userData = new File(Bukkit.getServer().getPluginManager().getPlugin("PhantasyStatus").getDataFolder(), File.separator + "player_data");
        File playerFile = new File(userData, File.separator + playerUUID + ".yml");
        return playerFile;
    }

    public static FileConfiguration getPlayerData(Player player) {
        String playerUUID = String.valueOf(player.getUniqueId());
        File userData = new File(Bukkit.getServer().getPluginManager().getPlugin("PhantasyStatus").getDataFolder(), File.separator + "player_data");
        File file = new File(userData, File.separator + playerUUID + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(file);
        return playerData;
    }

    public static void savePlayerData(File playerFile, FileConfiguration playerData, Player player) {
        try {
            playerData.save(playerFile);
        } catch (IOException exception) {
            Bukkit.getServer().getLogger().severe(player.getDisplayName() + "のデータを保存できませんでした");
            exception.printStackTrace();
        }
    }

    public static int getPlayerHP(Player player) {
        FileConfiguration playerData = getPlayerData(player);

        return playerData.getInt("status.HP");
    }

    public static int getPlayerMAX_HP(Player player) {
        FileConfiguration playerData = getPlayerData(player);

        return playerData.getInt("status.addition.hp") + 20;
    }

    public static int getPlayerLEVEL(Player player) {
        FileConfiguration playerData = getPlayerData(player);

        return playerData.getInt("status.level");
    }

    public static int getPlayerATTACK(Player player) {
        FileConfiguration playerData = getPlayerData(player);

        return playerData.getInt("status.attack");
    }

    public static int getPlayerDEFEND(Player player) {
        FileConfiguration playerData = getPlayerData(player);

        return playerData.getInt("status.defend");
    }

    public static int getPlayerMAGIC(Player player) {
        FileConfiguration playerData = getPlayerData(player);

        return playerData.getInt("status.magic");
    }

    public static int getPlayerMANA(Player player) {
        FileConfiguration playerData = getPlayerData(player);

        return playerData.getInt("status.mana");
    }

    public static int getPlayerMAX_MANA(Player player) {
        FileConfiguration playerData = getPlayerData(player);

        return playerData.getInt("status.addition.mana") + 50;
    }

    public static int getMagicAmountLimit(Player player) {
        FileConfiguration playerData = getPlayerData(player);

        return playerData.getInt("magicAmountLimit");
    }

    public static void setMagicAmountLimit(Player player, int amount) {
        File playerFile = PlayerDataUtil.getPlayerFile(player);
        FileConfiguration playerData = PlayerDataUtil.getPlayerData(player);

        playerData.set("magicAmountLimit", amount);
        savePlayerData(playerFile, playerData, player);
    }
}

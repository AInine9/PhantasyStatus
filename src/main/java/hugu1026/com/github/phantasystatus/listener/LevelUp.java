package hugu1026.com.github.phantasystatus.listener;

import hugu1026.com.github.phantasystatus.event.LevelUpEvent;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;

public class LevelUp implements Listener{

    @EventHandler
    public void LevelUp(LevelUpEvent event) {

        long[] expTable = event.getExpTable();
        Player player = event.getPlayer();

        File playerFile = PlayerDataUtil.getPlayerFile(player);
        FileConfiguration playerData = PlayerDataUtil.getPlayerData(player);

        int playerLevel = playerData.getInt("status.level");

        playerData.set("status.level", playerLevel + 1);
        playerData.set("point.all", playerData.getInt("point.all") + 5);
        player.sendMessage(ChatColor.BLUE + "レベルが " + playerLevel +1 + " になった！ステータスポイントを入手した！");

        switch (playerLevel + 1) {
            case 30:
                playerData.set("panel", 2);
                break;
            case 60:
                playerData.set("panel", 3);
                break;
            case 80:
                playerData.set("panel", 4);
                break;
        }

        if(!(playerLevel == event.getMaxLevel() - 1)) {

            if(playerData.getInt("status.reqExp") == 0) {
                playerData.set("status.reqExp", expTable[playerLevel + 1]);
                PlayerDataUtil.savePlayerData(playerFile, playerData, player);

            } else {
                playerData.set("status.reqExp", expTable[playerLevel + 1] + playerData.getInt("status.reqExp"));
                PlayerDataUtil.savePlayerData(playerFile, playerData, player);

                if(playerData.getInt("status.reqExp") <= 0) {
                    LevelUpEvent levelUpEvent = new LevelUpEvent(player);
                    Bukkit.getServer().getPluginManager().callEvent(levelUpEvent);
                }
            }
        } else {
            playerData.set("status.reqExp", "最大レベルです");
            PlayerDataUtil.savePlayerData(playerFile, playerData, player);
        }
    }
}

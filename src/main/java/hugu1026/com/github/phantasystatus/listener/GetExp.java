package hugu1026.com.github.phantasystatus.listener;

import hugu1026.com.github.phantasystatus.event.GetExpEvent;
import hugu1026.com.github.phantasystatus.event.LevelUpEvent;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;

public class GetExp implements Listener {

    @EventHandler
    public void GetExp(GetExpEvent event) {
        Player player = event.getGetter();
        long exp = event.getExp();

        LevelUpEvent levelUpEvent = new LevelUpEvent(player);
        int MAX_LEVEL = levelUpEvent.getMaxLevel();

        File playerFile = PlayerDataUtil.getPlayerFile(player);
        FileConfiguration playerData = PlayerDataUtil.getPlayerData(player);

        player.sendMessage(ChatColor.GOLD + "+" + exp + "経験値");
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

        playerData.set("status.totalExp", playerData.getLong("status.totalExp") + exp);

        if (playerData.getInt("status.level") == MAX_LEVEL) {
            PlayerDataUtil.savePlayerData(playerFile, playerData, player);

        } else {
            playerData.set("status.reqExp", playerData.getInt("status.reqExp") - exp);
            PlayerDataUtil.savePlayerData(playerFile, playerData, player);

            long reqExp = playerData.getInt("status.reqExp");

            if (reqExp <= 0) {
                Bukkit.getServer().getPluginManager().callEvent(levelUpEvent);
            }
        }
    }
}

package hugu1026.com.github.phantasystatus.listener;

import hugu1026.com.github.phantasystatus.event.GetExpEvent;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;

public class GetExp implements Listener {

    @EventHandler
    public void GetExp(GetExpEvent event) {
        Player player = event.getGetter();
        int exp = event.getExp();

        File playerFile = PlayerDataUtil.getPlayerFile(player);
        FileConfiguration playerData = PlayerDataUtil.getPlayerData(player);

        playerData.set("status.exp", playerData.getInt("status.exp") + exp);
        PlayerDataUtil.savePlayerData(playerFile, playerData, player);

        player.sendMessage(ChatColor.GOLD + "+" + exp + "経験値");
    }
}

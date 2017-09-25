package hugu1026.com.github.phantasystatus.status;

import hugu1026.com.github.phantasystatus.gui.StatusGui;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Health extends Status{

    public void onPushHealthIcon(Player player) {
        File playerFile = super.getPlayerFile(player);
        FileConfiguration playerData = super.getPlayerData(player);

        if(!(playerData.getInt("point.all") > 0)) return;
        playerData.set("point.all", playerData.getInt("point.all") - 1);
        playerData.set("point.health", playerData.getInt("point.health") + 1);
        playerData.set("status.HP", playerData.getInt("status.HP") + 2);

        player.sendMessage(ChatColor.GOLD + "ステータスポイントを体力に振り分けた");

        PlayerDataUtil.savePlayerData(playerFile, playerData, player);
        StatusGui statusGui = new StatusGui(player);
        statusGui.openInventory(player);
    }
}

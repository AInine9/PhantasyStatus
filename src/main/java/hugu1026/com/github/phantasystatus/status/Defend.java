package hugu1026.com.github.phantasystatus.status;

import hugu1026.com.github.phantasystatus.gui.StatusGui;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Defend extends Status{

    public void onPushDefendIcon(Player player) {
        File playerFile = super.getPlayerFile(player);
        FileConfiguration playerData = super.getPlayerData(player);

        if (!(playerData.getInt("point.all") > 0)) return;
        playerData.set("point.all", playerData.getInt("point.all") - 1);
        playerData.set("point.defend", playerData.getInt("point.defend") + 1);
        playerData.set("status.defend", playerData.getInt("status.defend") + 2);

        player.sendMessage(ChatColor.GOLD + "ステータスポイントを防御力に振り分けた");

        PlayerDataUtil.savePlayerData(playerFile, playerData, player);
        StatusGui statusGui = new StatusGui(player);
        statusGui.openInventory(player);
    }
}

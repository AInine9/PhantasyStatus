package hugu1026.com.github.phantasystatus.status;

import hugu1026.com.github.phantasystatus.gui.StatusGui;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Attack extends Status {

    public void onPushAttackIcon(Player player) {
        File playerFile = super.getPlayerFile(player);
        FileConfiguration playerData = super.getPlayerData(player);

        if (!(playerData.getInt("point.all") > 0)) return;
        playerData.set("point.all", playerData.getInt("point.all") - 1);
        playerData.set("point.attack", playerData.getInt("point.attack") + 1);
        playerData.set("status.attack", playerData.getInt("status.attack") + 2);

        player.sendMessage(ChatColor.GOLD + "ステータスポイントを攻撃力に振り分けた");

        PlayerDataUtil.savePlayerData(playerFile, playerData, player);
        StatusGui statusGui = new StatusGui(player);
        statusGui.openInventory(player);
    }
}

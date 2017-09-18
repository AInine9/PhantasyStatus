package hugu1026.com.github.phantasystatus.status;

import hugu1026.com.github.phantasystatus.gui.StatusGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Health extends Status{

    public void onPushHealthIcon(Player player) {
        File playerFile = super.getPlayerFile(player);
        FileConfiguration playerData = super.getPlayerData(player);

        if(!(playerData.getInt("point.all") > 0)) return;
        playerData.set("point.all", playerData.getInt("point.all") - 1);
        playerData.set("point.health", playerData.getInt("point.health") + 1);

        player.sendMessage(ChatColor.GOLD + "ステータスポイントを体力に振り分けた");

        try {
            playerData.save(playerFile);
        } catch (IOException expection) {
            Bukkit.getServer().getLogger().severe(player.getDisplayName() + "のデータを保存できませんでした");
            expection.printStackTrace();
        }
        StatusGui statusGui = new StatusGui(player);
        statusGui.openInventory(player);
    }
}

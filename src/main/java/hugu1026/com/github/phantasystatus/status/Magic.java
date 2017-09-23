package hugu1026.com.github.phantasystatus.status;

import hugu1026.com.github.phantasystatus.gui.StatusGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Magic extends Status{

    public void onPushMagicIcon(Player player) {
        File playerFile = super.getPlayerFile(player);
        FileConfiguration playerData = super.getPlayerData(player);

        if (!(playerData.getInt("point.all") > 0)) return;
        playerData.set("point.all", playerData.getInt("point.all") - 1);
        playerData.set("point.magic", playerData.getInt("point.magic") + 1);
        playerData.set("status.magic", playerData.getInt("status.magic") + 1);

        player.sendMessage(ChatColor.GOLD + "ステータスポイントを魔力に振り分けた");

        try {
            playerData.save(playerFile);
        } catch (IOException exception) {
            Bukkit.getServer().getLogger().severe(player.getDisplayName() + "のデータを保存できませんでした");
            exception.printStackTrace();
        }
        StatusGui statusGui = new StatusGui(player);
        statusGui.openInventory(player);
    }
}

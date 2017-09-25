package hugu1026.com.github.phantasystatus.status;

import hugu1026.com.github.phantasystatus.gui.StatusGui;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class Magic extends Status{

    public void onPushMagicIcon(Player player) {
        File playerFile = super.getPlayerFile(player);
        FileConfiguration playerData = super.getPlayerData(player);

        if (!(playerData.getInt("point.all") > 0)) return;
        playerData.set("point.all", playerData.getInt("point.all") - 1);
        playerData.set("point.magic", playerData.getInt("point.magic") + 1);
        playerData.set("status.magic", playerData.getInt("status.magic") + 1);

        player.sendMessage(ChatColor.GOLD + "ステータスポイントを魔力に振り分けた");

        PlayerDataUtil.savePlayerData(playerFile, playerData, player);
        StatusGui statusGui = new StatusGui(player);
        statusGui.openInventory(player);

        if(playerData.getInt("status.magic") % 2 == 0) {
            Material material = Material.PRISMARINE_SHARD;
            int amount = 1;
            String name = ChatColor.YELLOW + "スピリット";

            ItemStack spirit = new ItemStack(material, amount);
            ItemMeta itemMeta = spirit.getItemMeta();
            itemMeta.setDisplayName(name);
            spirit.setItemMeta(itemMeta);

            player.getInventory().addItem(spirit);
            player.sendMessage(ChatColor.GOLD + "スピリットを入手した");
        }
    }
}

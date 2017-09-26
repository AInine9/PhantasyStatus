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

public class Status{

    private File playerFile;
    private FileConfiguration playerData;

    public Status(Player player) {
        this.playerFile = PlayerDataUtil.getPlayerFile(player);
        this.playerData = PlayerDataUtil.getPlayerData(player);
    }

    public boolean canAddPoint() {
        return playerData.getInt("point.all") > 0;
    }

    public void onPushStatusIcon(Player player, String type) {
        playerData.set("point.all", playerData.getInt("point.all") - 1);

        switch (type) {
            case "Health":
                playerData.set("point.health", playerData.getInt("point.health") + 1);
                playerData.set("status.HP", playerData.getInt("status.HP") + 2);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを体力に振り分けた");
                break;
            case  "Attack":
                playerData.set("point.attack", playerData.getInt("point.attack") + 1);
                playerData.set("status.attack", playerData.getInt("status.attack") + 2);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを攻撃力に振り分けた");
                break;
            case "Defend":
                playerData.set("point.defend", playerData.getInt("point.defend") + 1);
                playerData.set("status.defend", playerData.getInt("status.defend") + 2);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを防御力に振り分けた");
                break;
            case  "Magic":
                playerData.set("point.magic", playerData.getInt("point.magic") + 1);
                playerData.set("status.magic", playerData.getInt("status.magic") + 1);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを魔力に振り分けた");

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

        PlayerDataUtil.savePlayerData(playerFile, playerData, player);
        StatusGui statusGui = new StatusGui(player);
        statusGui.openInventory(player);
    }
}

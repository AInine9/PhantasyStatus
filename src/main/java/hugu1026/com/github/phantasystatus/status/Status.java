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

    private int addValue_HP;
    private int addValue_Defend;
    private int addValue_Attack;
    private int addValue_Magic;

    public Status(Player player, int panel) {
        this.playerFile = PlayerDataUtil.getPlayerFile(player);
        this.playerData = PlayerDataUtil.getPlayerData(player);
        switch (panel) {
            case 1:
                this.addValue_HP = 2;
                this.addValue_Defend = 2;
                this.addValue_Attack = 2;
                this.addValue_Magic = 1;
                break;
            case 2:
                this.addValue_HP = 3;
                this.addValue_Defend = 3;
                this.addValue_Attack = 3;
                this.addValue_Magic = 2;
                break;
            case 3:
                this.addValue_HP = 4;
                this.addValue_Defend = 4;
                this.addValue_Attack = 4;
                this.addValue_Magic = 3;
                break;
            case 4:
                this.addValue_HP = 5;
                this.addValue_Defend = 5;
                this.addValue_Attack = 5;
                this.addValue_Magic = 4;
                break;
        }
    }

    public boolean canAddPoint() {
        return playerData.getInt("point.all") > 0;
    }

    public void onPushStatusIcon(Player player, String type) {
        playerData.set("point.all", playerData.getInt("point.all") - 1);

        switch (type) {
            case "Health":
                playerData.set("point.health", playerData.getInt("point.health") + 1);
                playerData.set("status.HP", playerData.getInt("status.HP") + this.addValue_HP);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを体力に振り分けた");
                break;
            case  "Attack":
                playerData.set("point.attack", playerData.getInt("point.attack") + 1);
                playerData.set("status.attack", playerData.getInt("status.attack") + this.addValue_Attack);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを攻撃力に振り分けた");
                break;
            case "Defend":
                playerData.set("point.defend", playerData.getInt("point.defend") + 1);
                playerData.set("status.defend", playerData.getInt("status.defend") + this.addValue_Defend);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを防御力に振り分けた");
                break;
            case  "Magic":
                playerData.set("point.magic", playerData.getInt("point.magic") + 1);
                playerData.set("status.magic", playerData.getInt("status.magic") + this.addValue_Magic);
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

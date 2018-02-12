package hugu1026.com.github.phantasystatus.status;

import hugu1026.com.github.phantasystatus.gui.StatusGui;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Status{

    private File playerFile;
    private FileConfiguration playerData;

    private int addValue_HP;
    private int addValue_Defend;
    private int addValue_Attack;
    private int addValue_Magic;
    private int addValue_Mana;

    public Status(Player player, int panel) {
        this.playerFile = PlayerDataUtil.getPlayerFile(player);
        this.playerData = PlayerDataUtil.getPlayerData(player);
        switch (panel) {
            case 1:
                this.addValue_HP = 2;
                this.addValue_Defend = 2;
                this.addValue_Attack = 2;
                this.addValue_Magic = 1;
                this.addValue_Mana = 2;
                break;
            case 2:
                this.addValue_HP = 3;
                this.addValue_Defend = 3;
                this.addValue_Attack = 3;
                this.addValue_Magic = 2;
                this.addValue_Mana = 3;
                break;
            case 3:
                this.addValue_HP = 4;
                this.addValue_Defend = 4;
                this.addValue_Attack = 4;
                this.addValue_Magic = 3;
                this.addValue_Mana = 4;
                break;
            case 4:
                this.addValue_HP = 5;
                this.addValue_Defend = 5;
                this.addValue_Attack = 5;
                this.addValue_Magic = 4;
                this.addValue_Mana = 5;
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
                playerData.set("status.addition.HP", playerData.getInt("status.addition.HP") + this.addValue_HP);
                playerData.set("status.HP", playerData.getInt("status.HP") + this.addValue_HP);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを体力に振り分けた");
                break;
            case  "Attack":
                playerData.set("point.attack", playerData.getInt("point.attack") + 1);
                playerData.set("status.addition.attack", playerData.getInt("status.addition.attack") + this.addValue_Attack);
                playerData.set("status.attack", playerData.getInt("status.attack") + this.addValue_Attack);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを攻撃力に振り分けた");
                break;
            case "Defend":
                playerData.set("point.defend", playerData.getInt("point.defend") + 1);
                playerData.set("status.addition.defend", playerData.getInt("status.addition.defend") + this.addValue_Defend);
                playerData.set("status.defend", playerData.getInt("status.defend") + this.addValue_Defend);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを防御力に振り分けた");
                break;
            case  "Magic":
                playerData.set("point.magic", playerData.getInt("point.magic") + 1);
                playerData.set("status.addition.magic", playerData.getInt("status.addition.magic") + this.addValue_Magic);
                playerData.set("status.magic", playerData.getInt("status.magic") + this.addValue_Magic);

                playerData.set("status.addition.mana", playerData.getInt("status.addition.mana") + this.addValue_Mana);
                playerData.set("status.mana", playerData.getInt("status.mana") + this.addValue_Mana);
                player.sendMessage(ChatColor.GOLD + "ステータスポイントを魔力に振り分けた");
        }

        PlayerDataUtil.savePlayerData(playerFile, playerData, player);
        StatusGui statusGui = new StatusGui(player);
        statusGui.openInventory(player);
    }
}

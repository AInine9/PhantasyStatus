package hugu1026.com.github.phantasystatus.gui;

import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class StatusGui extends Gui{

    private ItemStack HEALTH, ATTACK, DEFEND, MAGIC, ALL, GLASS;

    private List<String> health_lore = new ArrayList<>();
    private List<String> attack_lore = new ArrayList<>();
    private List<String> defend_lore = new ArrayList<>();
    private List<String> magic_lore = new ArrayList<>();
    private List<String> all_lore = new ArrayList<>();

    public StatusGui(Player player) {
        File playerFile = PlayerDataUtil.getPlayerFile(player);
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);

        String point_all = playerData.getString("point.all");
        String point_health = playerData.getString("point.health");
        String point_attack = playerData.getString("point.attack");
        String point_defend = playerData.getString("point.defend");
        String point_magic = playerData.getString("point.magic");

        health_lore.add(0, ChatColor.LIGHT_PURPLE + "HPに関わる");
        health_lore.add(1, ChatColor.YELLOW + point_health);
        attack_lore.add(0, ChatColor.LIGHT_PURPLE + "攻撃力に関わる");
        attack_lore.add(1, ChatColor.YELLOW + point_attack);
        defend_lore.add(0, ChatColor.LIGHT_PURPLE + "防御力に関わる");
        defend_lore.add(1, ChatColor.YELLOW + point_defend);
        magic_lore.add(0, ChatColor.LIGHT_PURPLE + "使用できる魔法が増える");
        magic_lore.add(1, ChatColor.YELLOW + point_magic);
        all_lore.add(0, ChatColor.YELLOW + point_all);

        this.HEALTH = super.createItemStack(Material.SHIELD, ChatColor.LIGHT_PURPLE + "体力", health_lore, 1);
        this.ATTACK = super.createItemStack(Material.IRON_SWORD, ChatColor.LIGHT_PURPLE + "攻撃力", attack_lore, 1);
        this.DEFEND = super.createItemStack(Material.IRON_CHESTPLATE, ChatColor.LIGHT_PURPLE + "防御力", defend_lore, 1);
        this.MAGIC = super.createItemStack(Material.ENCHANTED_BOOK, ChatColor.LIGHT_PURPLE + "魔力", magic_lore, 1);
        this.ALL = super.createItemStack(Material.PAPER, ChatColor.LIGHT_PURPLE + "残りのポイント" , all_lore, 1);
        this.GLASS = super.createItemStack(Material.STAINED_GLASS_PANE, " ", null, 1);
        super.createInventory(this, 9, "ステータス振り分け");
    }

    @Override
    public void openInventory(Player player) {
        super.setInventory(this.HEALTH, 0);
        super.setInventory(this.GLASS, 1);
        super.setInventory(this.ATTACK, 2);
        super.setInventory(this.GLASS,3);
        super.setInventory(this.DEFEND, 4);
        super.setInventory(this.GLASS,5);
        super.setInventory(this.MAGIC, 6);
        super.setInventory(this.GLASS, 7);
        super.setInventory(this.ALL, 8);
        super.openInventory(player);
    }

    public ItemStack getALL() {
        return this.ALL;
    }

    public ItemStack getHEALTH() {
        return this.HEALTH;
    }

    public ItemStack getATTACK() {
        return this.ATTACK;
    }

    public ItemStack getDEFEND() {
        return this.DEFEND;
    }

    public ItemStack getMAGIC() {
        return this.MAGIC;
    }

    public ItemStack getGLASS() {
        return this.GLASS;
    }
}

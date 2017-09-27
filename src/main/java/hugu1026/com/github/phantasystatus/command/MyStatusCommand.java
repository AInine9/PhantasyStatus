package hugu1026.com.github.phantasystatus.command;

import hugu1026.com.github.phantasystatus.PhantasyStatus;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MyStatusCommand implements CommandExecutor{
    private final PhantasyStatus plg;

    public MyStatusCommand(PhantasyStatus plg) {
        this.plg = plg;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        ChatColor chatColor = ChatColor.GOLD;

        if(cmd.getName().equalsIgnoreCase("myst")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                FileConfiguration playerData = PlayerDataUtil.getPlayerData(player);

                int level = playerData.getInt("status.level");
                int totalExp = playerData.getInt("status.totalExp");
                int reqExp = playerData.getInt("status.reqExp");
                int HP = playerData.getInt("status.HP");
                int maxHP = playerData.getInt("status.addition.HP") + 20;
                int attack = playerData.getInt("status.attack");
                int defend = playerData.getInt("status.defend");
                int magic = playerData.getInt("status.magic");
                int point = playerData.getInt("point.all");
                int panel = playerData.getInt("panel");

                player.sendMessage(chatColor + "----------ステータス----------");
                player.sendMessage(chatColor + "レベル: " + level);
                player.sendMessage(chatColor + "累計経験値: " + totalExp);
                player.sendMessage(chatColor + "次のレベルまで: " + reqExp);
                player.sendMessage(chatColor + "体力: " + HP + "/" + maxHP);
                player.sendMessage(chatColor + "攻撃力: " + attack);
                player.sendMessage(chatColor + "防御力: " + defend);
                player.sendMessage(chatColor + "魔力: " + magic);
                player.sendMessage(chatColor + "残りのステータスポイント: " + point);
                player.sendMessage(chatColor + "ステータスパネル: " + panel);
            }
        }
        return false;
    }
}

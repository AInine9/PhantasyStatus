package hugu1026.com.github.phantasystatus.command;

import hugu1026.com.github.phantasystatus.PhantasyStatus;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddMagicAmountLimitCommand implements CommandExecutor {
    private final PhantasyStatus plg;

    public AddMagicAmountLimitCommand(PhantasyStatus plg) {
        this.plg = plg;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("setmagiclimit")) {
            if (!(sender instanceof Player)) {
                if (args[0] == null || args[1] == null) return false;

                Player player = Bukkit.getPlayer(args[0]);
                int amount = Integer.parseInt(args[1]);
                PlayerDataUtil.setMagicAmountLimit(player, amount);
            }
        } return false;
    }
}

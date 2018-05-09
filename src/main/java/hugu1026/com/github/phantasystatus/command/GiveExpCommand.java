package hugu1026.com.github.phantasystatus.command;

import hugu1026.com.github.phantasystatus.PhantasyStatus;
import hugu1026.com.github.phantasystatus.event.GetExpEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveExpCommand implements CommandExecutor {
    private final PhantasyStatus plg;

    public GiveExpCommand(PhantasyStatus plg) {
        this.plg = plg;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("giveexp")) {
            if (!(sender instanceof Player)) {
                if (args[0] == null || args[1] == null) return false;
                Player player = Bukkit.getPlayer(args[0]);
                long amount = Long.parseLong(args[1]);
                GetExpEvent event = new GetExpEvent(player, amount);
                Bukkit.getServer().getPluginManager().callEvent(event);
            }
        }
        return false;
    }
}

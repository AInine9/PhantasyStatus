package hugu1026.com.github.phantasystatus.command;

import hugu1026.com.github.phantasystatus.PhantasyStatus;
import hugu1026.com.github.phantasystatus.gui.StatusGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatusCommand implements CommandExecutor {

    private final PhantasyStatus plg;

    public StatusCommand(PhantasyStatus plg) {
        this.plg = plg;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("st")) {

            if (sender instanceof Player) {
                Player player = (Player) sender;
                StatusGui gui = new StatusGui(player);
                gui.openInventory(player);
            }
        }
        return false;
    }
}

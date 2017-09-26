package hugu1026.com.github.phantasystatus.listener;

import hugu1026.com.github.phantasystatus.gui.StatusGui;
import hugu1026.com.github.phantasystatus.status.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener{

    private Player player;

    @EventHandler
    public void InventoryClick(InventoryClickEvent event) {
        if(event.getInventory() == null
                || !(event.getClickedInventory().getHolder() instanceof StatusGui)) return;

        if(!(event.getWhoClicked() instanceof Player)) return;
        this.player = (Player) event.getWhoClicked();

        event.setCancelled(true);

        Status status = new Status(player);

        if(!(status.canAddPoint())) return;

        StatusGui gui = (StatusGui) event.getInventory().getHolder();
        ItemStack clickedItem = event.getCurrentItem();

        if(clickedItem.equals(gui.getHEALTH())) {
            status.onPushStatusIcon(player, "Health");
            return;
        }

        if(clickedItem.equals(gui.getATTACK())) {
            status.onPushStatusIcon(player, "Attack");
            return;
        }

        if(clickedItem.equals(gui.getDEFEND())) {
            status.onPushStatusIcon(player, "Defend");
            return;
        }

        if(clickedItem.equals(gui.getMAGIC())) {
            status.onPushStatusIcon(player, "Magic");
        }
    }
}

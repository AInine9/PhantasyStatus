package hugu1026.com.github.phantasystatus.listener;

import hugu1026.com.github.phantasystatus.gui.StatusGui;
import hugu1026.com.github.phantasystatus.status.Status;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

    private Player player;

    @EventHandler
    public void InventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory == null) return;

        if (!(inventory.getHolder() instanceof StatusGui)) return;

        if (!(event.getWhoClicked() instanceof Player)) return;

        if (!(event.getWhoClicked() instanceof Player)) return;
        this.player = (Player) event.getWhoClicked();
        int panel = PlayerDataUtil.getPlayerData(player).getInt("panel");

        Status status = new Status(player, panel);

        if (!(status.canAddPoint())) return;

        StatusGui gui = (StatusGui) event.getInventory().getHolder();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null) {
            if (clickedItem.equals(gui.getHEALTH())) {
                status.onPushStatusIcon(player, "Health");
                return;
            }
            if (clickedItem.equals(gui.getATTACK())) {
                status.onPushStatusIcon(player, "Attack");
                return;
            }
            if (clickedItem.equals(gui.getDEFEND())) {
                status.onPushStatusIcon(player, "Defend");
                return;
            }
            if (clickedItem.equals(gui.getMAGIC())) {
                status.onPushStatusIcon(player, "Magic");
            }
            if (clickedItem.equals(gui.getGLASS())) {
                event.setCancelled(true);
            } else {
                return;
            }
            event.setCancelled(true);
        }
    }
}

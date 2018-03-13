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

        StatusGui gui = (StatusGui) event.getInventory().getHolder();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null) {
            if (clickedItem.equals(gui.getHEALTH())) {
                if (!(status.canAddPoint())) {
                    event.setCancelled(true);
                    return;
                }
                event.setCancelled(true);
                status.onPushStatusIcon(player, "Health");
                return;
            }
            if (clickedItem.equals(gui.getATTACK())) {
                if (!(status.canAddPoint())) {
                    event.setCancelled(true);
                    return;
                }
                event.setCancelled(true);
                status.onPushStatusIcon(player, "Attack");
                return;
            }
            if (clickedItem.equals(gui.getDEFEND())) {
                if (!(status.canAddPoint())) {
                    event.setCancelled(true);
                    return;
                }
                event.setCancelled(true);
                status.onPushStatusIcon(player, "Defend");
                return;
            }
            if (clickedItem.equals(gui.getMAGIC())) {
                if (!(status.canAddPoint())) {
                    event.setCancelled(true);
                    return;
                }
                event.setCancelled(true);
                status.onPushStatusIcon(player, "Magic");
            }
            if (clickedItem.equals(gui.getGLASS())) {
                event.setCancelled(true);
            }
            if (clickedItem.equals(gui.getALL())) {
                event.setCancelled(true);
            }
        }
    }
}

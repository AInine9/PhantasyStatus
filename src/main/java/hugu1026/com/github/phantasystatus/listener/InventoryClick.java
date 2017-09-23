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

        StatusGui gui = (StatusGui) event.getInventory().getHolder();
        ItemStack clickedItem = event.getCurrentItem();

        if(!(event.getWhoClicked() instanceof Player)) return;
        this.player = (Player) event.getWhoClicked();

        if(clickedItem.equals(gui.getALL())) {
            event.setCancelled(true);
            return;
        }

        if(clickedItem.equals(gui.getHEALTH())) {
            event.setCancelled(true);
            Health health = new Health();
            health.onPushHealthIcon(player);
            return;
        }

        if(clickedItem.equals(gui.getATTACK())) {
            event.setCancelled(true);
            Attack attack = new Attack();
            attack.onPushAttackIcon(player);
            return;
        }

        if(clickedItem.equals(gui.getDEFEND())) {
            event.setCancelled(true);
            Defend defend = new Defend();
            defend.onPushDefendIcon(player);
            return;
        }

        if(clickedItem.equals(gui.getMAGIC())) {
            event.setCancelled(true);
            Magic magic = new Magic();
            magic.onPushMagicIcon(player);
            return;
        }

        if(clickedItem.equals(gui.getGLASS())) {
            event.setCancelled(true);
            return;
        }
    }
}

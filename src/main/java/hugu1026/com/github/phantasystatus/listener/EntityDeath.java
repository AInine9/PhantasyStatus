package hugu1026.com.github.phantasystatus.listener;

import hugu1026.com.github.phantasystatus.event.GetExpEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener {

    @EventHandler
    public void EntityDeath(EntityDeathEvent event) {
        boolean hasCustomName = event.getEntity().getCustomName() != null;
        Entity victim = event.getEntity();
        Player killer = event.getEntity().getKiller();

        if (victim instanceof Creature
                && hasCustomName
                && killer != null) {

            int exp = 500;

            GetExpEvent getExpEvent = new GetExpEvent(killer, exp);
            Bukkit.getServer().getPluginManager().callEvent(getExpEvent);
        }
    }
}

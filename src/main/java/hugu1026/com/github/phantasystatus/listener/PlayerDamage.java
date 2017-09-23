package hugu1026.com.github.phantasystatus.listener;

import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.io.File;
import java.io.IOException;

public class PlayerDamage implements Listener{

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerDamage(EntityDamageEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        if(event.getCause().equals(EntityDamageEvent.DamageCause.CUSTOM)) return;

        Player player = (Player) event.getEntity();
        File playerFile = PlayerDataUtil.getPlayerFile(player);
        FileConfiguration playerData = PlayerDataUtil.getPlayerData(player);
        double damage = event.getFinalDamage();
        double playerHP = playerData.getInt("status.HP");
        double playerMaxHP = playerData.getInt("point.health") + 20;

        event.setCancelled(true);

        playerData.set("status.HP", playerHP - damage);
        try {
            playerData.save(playerFile);
        } catch (IOException exception) {
            Bukkit.getServer().getLogger().severe(player.getDisplayName() + "のデータを保存できませんでした");
            exception.printStackTrace();
        }

        playerHP = playerData.getInt("status.HP");
        double proportion = playerHP / playerMaxHP;

        if(1 >= proportion && proportion > 0.9) {
            player.damage(0);
        } else if(proportion > 0.8) {
            player.setHealth(18);
            player.damage(0);
        } else if(proportion > 0.7) {
            player.setHealth(16);
            player.damage(0);
        } else if(proportion > 0.6) {
            player.setHealth(14);
            player.damage(0);
        } else if(proportion > 0.5) {
            player.setHealth(12);
            player.damage(0);
        } else if(proportion > 0.4) {
            player.setHealth(10);
            player.damage(0);
        } else if(proportion > 0.3) {
            player.setHealth(8);
            player.damage(0);
        } else if(proportion > 0.2) {
            player.setHealth(6);
            player.damage(0);
        } else if(proportion > 0.1) {
            player.setHealth(4);
            player.damage(0);
        } else if(proportion > 0) {
            player.setHealth(2);
            player.damage(0);
        } else if(proportion <= 0) {
            player.damage(20);

            playerData.set("status.HP", playerData.getInt("point.health") + 20);
            try {
                playerData.save(playerFile);
            } catch (IOException exception) {
                Bukkit.getServer().getLogger().severe(player.getDisplayName() + "のデータを保存できませんでした");
                exception.printStackTrace();
            }
        }
    }
}

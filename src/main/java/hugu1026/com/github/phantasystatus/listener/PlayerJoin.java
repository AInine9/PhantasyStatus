package hugu1026.com.github.phantasystatus.listener;

import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        PlayerDataUtil.createPlayerDataYml(player);
    }
}

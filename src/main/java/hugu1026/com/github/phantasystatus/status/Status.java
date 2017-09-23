package hugu1026.com.github.phantasystatus.status;

import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Status{

    private File playerFile;
    private FileConfiguration playerData;

    public void setPlayerData(Player player) {
        this.playerData = PlayerDataUtil.getPlayerData(player);
    }

    public void setPlayerFile(Player player) {
        this.playerFile = PlayerDataUtil.getPlayerFile(player);
    }

    public FileConfiguration getPlayerData(Player player) {
        this.setPlayerData(player);
        return this.playerData;
    }

    public File getPlayerFile(Player player) {
        this.setPlayerFile(player);
        return this.playerFile;
    }
}

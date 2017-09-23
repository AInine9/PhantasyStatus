package hugu1026.com.github.phantasystatus;

import hugu1026.com.github.phantasystatus.command.StatusCommand;
import hugu1026.com.github.phantasystatus.listener.InventoryClick;
import hugu1026.com.github.phantasystatus.listener.PlayerDamage;
import hugu1026.com.github.phantasystatus.listener.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PhantasyStatus extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        this.registerEvents();
        getCommand("st").setExecutor(new StatusCommand(this));
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public void registerEvents(){
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new InventoryClick(), this);
        pm.registerEvents(new PlayerDamage(), this);
    }
}

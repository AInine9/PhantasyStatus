package hugu1026.com.github.phantasystatus.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GetExpEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private long exp;

    public GetExpEvent(Player player, long exp) {
        this.player = player;
        this.exp = exp;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Player getGetter() {
        return player;
    }

    public long getExp() {
        return exp;
    }
}

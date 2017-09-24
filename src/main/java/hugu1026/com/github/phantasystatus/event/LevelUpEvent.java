package hugu1026.com.github.phantasystatus.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LevelUpEvent extends Event{

    private static  final HandlerList handlers = new HandlerList();
    private Player player;

    private static final int MAX_LEVEL = 100;
    private static final long MAX_TOTAL_EXP = 1343254751;

    private static final long expTable[] =
            {0, 4, 5, 6, 7, 8, 10, 12, 14, 17, 20, 24, 29, 35, 42, 50, 60, 72, 86,
             103, 124, 147, 179, 215, 258, 310, 372, 446, 535, 642, 770, 924, 1109,
             1331, 1597, 1916, 2299, 2759, 3311, 3973, 4768, 5722, 6866, 8239, 9887,
             11864, 14237, 17084, 20501, 24601, 29521, 35425, 42510, 51012, 61214,
             73457, 88148, 105778, 126934, 126934, 152321, 182785, 219342, 263210,
             315852, 379022, 454826, 545791, 654949, 785939, 943127, 1131752, 1358102,
             1629722, 1955666, 2346799, 2816159, 3379391, 4055269, 4866323, 5839588,
             7007506, 8409007, 10090808, 12108970, 14530764, 17436917, 20924300,
             25109160, 30130992, 36157190, 43388628, 52066354, 62479625, 74975550,
             89970660, 107964792, 129557750, 155469300, 223875792
            };

    public LevelUpEvent(Player player) {
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public long[] getExpTable() {
        return expTable;
    }

    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    public long getMaxExp() {
        return MAX_TOTAL_EXP;
    }
}

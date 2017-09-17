package hugu1026.com.github.phantasystatus.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Gui {

    private Inventory inventory;

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(ItemStack itemStack, int slot) {
        this.inventory.setItem(slot, itemStack);
    }

    public void openInventory(Player player) {
        player.openInventory(this.getInventory());
    }

    public static ItemStack createItemStack(Material material, String name, List<String> lore, int amount) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(name);
        if(lore != null) {
            meta.setLore(lore);
        }
        itemStack.setItemMeta(meta);

        return itemStack;
    }
}

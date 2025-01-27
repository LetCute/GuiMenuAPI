package net.letcute.guimenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GuiBuilder {

    private final Inventory inventory;

    public GuiBuilder(String title, int slot) {
        this.inventory = Bukkit.createInventory(null, slot, title);
    }

    public GuiBuilder addItem(Material material, String name, List<String> lore, int slot) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        inventory.setItem(slot, item);
        return this;
    }

    public GuiBuilder addItem(ItemStack itemStack, int slot) {
        inventory.setItem(slot, itemStack);
        return this;
    }

    public void openMenu(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null.");
        }

        player.openInventory(inventory);
        return;
    }

}

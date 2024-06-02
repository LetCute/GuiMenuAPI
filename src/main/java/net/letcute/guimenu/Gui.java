package net.letcute.guimenu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Gui {

    String getTitle();

    void open(Player player);

    void action(Player player, String key);
}

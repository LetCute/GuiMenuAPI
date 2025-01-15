package net.letcute.guimenu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ListenerEvent implements Listener {

    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String guiTitle = event.getView().getTitle();
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null) {
            return;
        }
        if (GuiManager.isGui(guiTitle)) {
            Gui gui = GuiManager.getGuiByTitle(guiTitle);
            GuiDataClick guiDataClick = GuiDataClick.builder()
                    .player(player)
                    .itemStack(clickedItem)
                    .slot(event.getSlot())
                    .build();
            gui.action(guiDataClick);
            event.setCancelled(true);
        }
    }
}

package net.letcute.guimenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.SimpleFormResponse;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.ArrayList;
import java.util.List;

public class GuiBuilder {

    private final String title;
    private final Inventory inventory;
    private final List<String> nameButton;

    public GuiBuilder(String title, int slot) {
        this.title = title;
        this.inventory = Bukkit.createInventory(null, slot, title);
        this.nameButton = new ArrayList<>();
    }

    public GuiBuilder createItem(Material material, String name, List<String> lore, int slot) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        inventory.setItem(slot, item);
        nameButton.add(name);
        return this;
    }

    public void openMenu(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null.");
        }

        if (!GuiManager.isPlayerOnBedrock(player)) {
            player.openInventory(inventory);
            return;
        }

        SimpleForm.Builder formBuilder = SimpleForm.builder().title(title);
        for (String nameBtn : nameButton) {
            formBuilder.button(nameBtn);
        }

        formBuilder.responseHandler((form, responseData) -> {
            SimpleFormResponse response = form.parseResponse(responseData);
            if (response.isCorrect()) {
                int clickedButtonId = response.getClickedButtonId();
                String clickedButtonName = nameButton.get(clickedButtonId);

                if (GuiManager.isGui(title)) {
                    Gui gui = GuiManager.getGuiByTitle(title);
                    if (gui != null) {
                        gui.action(player, clickedButtonName);
                    }
                }
            }
        });

        FloodgateApi.getInstance().sendForm(player.getUniqueId(), formBuilder.build());
    }
}

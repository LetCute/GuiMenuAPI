package net.letcute.guimenu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuiDataClick {
    private Player player;
    private ItemStack itemStack;
    private int slot;

}
package net.letcute.guimenu;

import org.bukkit.entity.Player;

public interface Gui {

    String getTitle();

    void open(Player player);

    void action(GuiDataClick guiDataClick);
}

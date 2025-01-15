package net.letcute.guimenu;

import org.bukkit.plugin.java.JavaPlugin;

public final class GuiMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("GuiMenu by LetCute Enabled");
        getServer().getPluginManager().registerEvents(new ListenerEvent(), this);
    }
}

package net.letcute.guimenu;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class GuiManager {

    private static final Map<String, Gui> guiList = new HashMap<>();
    private static final Map<String, String> titleToGuiMap = new HashMap<>();

    public static void register(String name, Gui gui) {
        guiList.put(name, gui);
        titleToGuiMap.put(gui.getTitle(), name);
    }

    public static boolean isGui(String title) {
        return titleToGuiMap.containsKey(title);
    }

    public static Gui getGuiByTitle(String title) {
        String name = titleToGuiMap.get(title);
        return guiList.get(name);
    }

    public static void openGui(String name, Player player) {
        Gui gui = guiList.get(name);
        if (gui == null) {
            throw new RuntimeException("Name gui not found");
        }
        gui.open(player);
    }

}

# Minecraft GUI Menu Plugin

This library supports the creation of GUI menus for Minecraft servers using Bukkit/Spigot/Paper.

## Usage

### Register the GUI Menu

To register the GUI menu when the plugin is enabled, use the following code:

```java
public void onEnable() {
    GuiManager.register("GuiDemo", new GuiDemo("Gui Demo"));
}
```
### Create the GUI Menu Class

Create a class for the GUI menu that implements the Gui interface:
````java
public class GuiDemo implements Gui {

    private final String title;

    public GuiDemo(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void open(Player player) {
        GuiBuilder guiBuilder = new GuiBuilder(title, 54);
        guiBuilder.createItem(Material.PLAYER_HEAD, "Profile", Collections.singletonList("info player"), 11);
        guiBuilder.createItem(Material.SPRUCE_SIGN, "Shop", Collections.singletonList("shop Item"), 12);
        guiBuilder.createItem(Material.GRASS_BLOCK, "Island",  Collections.singletonList("Controller island"),13);
        guiBuilder.openMenu(player);
    }

    @Override
    public void action(Player player, String name) {
        if (name == null) return;

        switch (name) {
            case "Profile":
                player.sendMessage("profile");
                break;
            case "Shop":
                player.sendMessage("shop");
                break;
            case "Island":
                GuiManager.openGui("GuiDemo2", player);
                break;
        }
    }
}

````
### Explanation

Register the GUI: The onEnable method in your plugin registers a new GUI named "GuiDemo" with the title "Gui Demo".<br>
GUI Class:<br>
Constructor: Initializes the GUI with a title.<br>
getTitle(): Returns the title of the GUI.<br>
open(): Builds the GUI with items and opens it for the player.<br>
action(): Handles item click events within the GUI.<br>
### GUIBuilder Class

The GuiBuilder class is used to build and manage the inventory GUI:<br>
new GuiBuilder(title, 54): Creates a new GUI with the specified title and number of slots.<br>
guiBuilder.createItem(Material, "DisplayName", lore ,position): Adds an item to the GUI at the specified position.<br>
guiBuilder.openMenu(player): Opens the GUI for the specified player.<br>
Example Code Snippets<br>
#### Open Function
````java
public void open(Player player) {
    GuiBuilder guiBuilder = new GuiBuilder(title, 54);
    guiBuilder.createItem(Material.PLAYER_HEAD, "Profile", Collections.singletonList("info player"), 11);
    guiBuilder.createItem(Material.SPRUCE_SIGN, "Shop", Collections.singletonList("shop Item"), 12);
    guiBuilder.createItem(Material.GRASS_BLOCK, "Island",  Collections.singletonList("Controller island"),13);
    guiBuilder.openMenu(player);
}

````
#### Action Function

GuiManager.openGui("GuiDemo2", player);<br>
GuiDemo2 is the name of the gui registered in onEnable()
````java
@Override
public void action(Player player, ItemStack itemStack) {
    if (itemStack == null) return;

    ItemMeta meta = itemStack.getItemMeta();
    if (meta == null || !meta.hasDisplayName()) return;

    switch (meta.getDisplayName()) {
        case "Profile":
            player.sendMessage("profile");
            break;
        case "Shop":
            player.sendMessage("shop");
            break;
        case "Island":
            GuiManager.openGui("GuiDemo2", player);
            break;
    }
}

````
This setup provides a structured way to create and manage GUI menus in a Minecraft server using the Bukkit/Spigot/Paper framework.
<br>
<br>

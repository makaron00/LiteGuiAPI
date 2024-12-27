package org.makaron.ua.liteguiapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class LiteGuiAPI extends JavaPlugin {

    private InventoryAPI inventoryAPI;

    @Override
    public void onEnable() {
        inventoryAPI = new InventoryAPI();
        getServer().getPluginManager().registerEvents(new InventoryEventHandler(inventoryAPI), this);
    }

    @Override
    public void onDisable() {
    }

    public InventoryAPI getInventoryAPI() {
        return inventoryAPI;
    }
}
package org.makaron.ua.liteguiapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryAPI {

    private final Inventory pluginInventory;

    public InventoryAPI() {
        this.pluginInventory = Bukkit.createInventory(null, 54, "Plugin Inventory");
    }

    public Inventory getPluginInventory() {
        return pluginInventory;
    }

    public void addItemToPluginInventory(ItemStack item) {
        pluginInventory.addItem(item);
    }

    public void moveItemToPluginInventory(Player player, int slot) {
        Inventory playerInventory = player.getInventory();
        ItemStack item = playerInventory.getItem(slot);
        if (item != null) {
            pluginInventory.addItem(item);
            playerInventory.setItem(slot, null);
        }
    }
}
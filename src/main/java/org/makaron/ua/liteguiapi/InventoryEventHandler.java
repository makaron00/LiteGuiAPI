package org.makaron.ua.liteguiapi;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryEventHandler implements Listener {

    private final InventoryAPI inventoryAPI;

    public InventoryEventHandler(InventoryAPI inventoryAPI) {
        this.inventoryAPI = inventoryAPI;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        if (clickedInventory == null || clickedInventory.getHolder() != event.getWhoClicked()) {
            return;
        }

        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null) {
            return;
        }

        inventoryAPI.addItemToPluginInventory(clickedItem);
        clickedInventory.removeItem(clickedItem);

        event.setCancelled(true);
    }
}
package com.wenkrang.boatfly.event.GUI.table;

import com.wenkrang.boatfly.event.GUI.InventoryClose;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TableCouldPut implements Listener {
    @EventHandler
    public static void OnPlayer (InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("航空装配台")) {

            if (!(event.getRawSlot() == 10 || event.getRawSlot() == 11 || event.getRawSlot() == 12 || event.getRawSlot() == 13 || event.getRawSlot() == 14 || event.getRawSlot() == 15 || event.getRawSlot() == 40 || event.getRawSlot() == 34 || event.getRawSlot() > 54)) {

                event.setCancelled(true);
            }
        }
    }
}

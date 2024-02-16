package com.wenkrang.boatfly.event.GUI;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class Exit implements Listener {
    @EventHandler
    public static void OnPlayerCloseTheGui (InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("飞船控制面包")) {
            if (event.getRawSlot() == 19) {
                event.getWhoClicked().addScoreboardTag("CanExit");
                Objects.requireNonNull(event.getWhoClicked().getVehicle()).removePassenger(event.getWhoClicked());
                event.getWhoClicked().closeInventory();
                event.setCancelled(true);
            }

        }
    }
}

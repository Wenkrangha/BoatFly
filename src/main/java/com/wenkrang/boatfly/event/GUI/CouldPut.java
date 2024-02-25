package com.wenkrang.boatfly.event.GUI;

import com.wenkrang.boatfly.event.GUI.book.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class CouldPut implements Listener {
    @EventHandler
    public static void OnPut(InventoryClickEvent event) {
        if (!(event.getRawSlot() > event.getInventory().getSize()) && event.getView().getTitle().equalsIgnoreCase("飞船控制面板") && event.getRawSlot() != 15){
            event.setCancelled(true);
        }
        if (event.getRawSlot() == 15) {
            if (event.getWhoClicked().getVehicle() != null) {
                if (event.getWhoClicked().getVehicle().getScoreboardTags().contains("ON")) {
                    event.setCancelled(true);
                }
            }

        }
        if (event.getView().getTitle().contains("飞船配方")) {
            event.setCancelled(true);
        }
        if (event.getView().getTitle().contains("飞船配方-")) {
            if (event.getRawSlot() == 1) {
                Main.Show((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
    }
}

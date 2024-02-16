package com.wenkrang.boatfly.event.GUI;

import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class FireSafe implements Listener {
    @EventHandler
    public static void OnPlayer (InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("飞船控制面包")) {
            if (event.getRawSlot() == 29) {
                if (event.getWhoClicked().getVehicle().getScoreboardTags().contains("CanFire")) {
                    event.getWhoClicked().getVehicle().removeScoreboardTag("CanFire");
                    event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK1, 1, 30);
                } else {
                    event.getWhoClicked().getVehicle().addScoreboardTag("CanFire");
                    event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK2, 1, 30);
                }
            }
        }
    }
}

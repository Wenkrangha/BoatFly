package com.wenkrang.boatfly.event.GUI;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryClose implements Listener {
    @EventHandler
    public static void OnInventoryClose (InventoryCloseEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("飞船控制面包")) {
//            new BukkitRunnable() {
//                @Override
//                public void run() {
//                    if (event.getPlayer().getOpenInventory().getTitle().equalsIgnoreCase("飞船控制面包")) {
//                        event.getPlayer().addScoreboardTag("CanExit");
//                    }
//                }
//            }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 1);
        }
    }
}

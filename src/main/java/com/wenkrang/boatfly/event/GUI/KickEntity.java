package com.wenkrang.boatfly.event.GUI;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class KickEntity implements Listener {
    @EventHandler
    public static void OnPlayer (InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("飞船控制面包")) {
            try {
                if (event.getRawSlot() == 23) {
                    if (Objects.requireNonNull(event.getWhoClicked().getVehicle()).getPassengers().get(0) != null) {
                        if (event.getWhoClicked().getVehicle().getPassengers().get(0) instanceof Player) {
                            event.getWhoClicked().getVehicle().getPassengers().get(0).addScoreboardTag("CanExit");
                        }
                        Objects.requireNonNull(event.getWhoClicked().getVehicle()).removePassenger(event.getWhoClicked().getVehicle().getPassengers().get(0));
                    }
                    event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK1, 1, 30);
                }
                if (event.getRawSlot() == 24) {
                    if (Objects.requireNonNull(event.getWhoClicked().getVehicle()).getPassengers().get(1) != null) {
                        if (event.getWhoClicked().getVehicle().getPassengers().get(1) instanceof Player) {
                            event.getWhoClicked().getVehicle().getPassengers().get(1).addScoreboardTag("CanExit");
                        }
                        Objects.requireNonNull(event.getWhoClicked().getVehicle()).removePassenger(event.getWhoClicked().getVehicle().getPassengers().get(1));
                    }
                    event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK1, 1, 30);
                }
            }catch (Exception e){}

        }
    }
}

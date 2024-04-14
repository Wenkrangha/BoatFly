package com.wenkrang.boatfly.event.GUI;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class PutCaol implements Listener {
    @EventHandler
    public static void OnPlayer (InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("飞船控制面包")) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    try {
                        if (event.getInventory().getItem(15) != null &&
                                (Objects.requireNonNull(event.getInventory().getItem(15)).getType().equals(Material.COAL) ||
                                Objects.requireNonNull(event.getInventory().getItem(15)).getType().equals(Material.DRIED_KELP_BLOCK) ||
                                        Objects.requireNonNull(event.getInventory().getItem(15)).getType().equals(Material.CHARCOAL)) &&
                                !event.getWhoClicked().getVehicle().getScoreboardTags().contains("ON")) {
                            try {
                                for (String string : Objects.requireNonNull(event.getWhoClicked().getVehicle()).getScoreboardTags()) {
                                    if (string.contains("coal")) {
                                        event.getWhoClicked().getVehicle().removeScoreboardTag(string);
                                        event.getWhoClicked().getVehicle().addScoreboardTag("coal" + String.valueOf(Objects.requireNonNull(event.getInventory().getItem(15)).getAmount()));

                                        break;
                                    }
                                }
                            } catch (Exception e) {

                            }

                        }
                    }catch (Exception e) {}


                    if (event.getInventory().getItem(15) == null) {
                        try {
                            for (String string : Objects.requireNonNull(event.getWhoClicked().getVehicle()).getScoreboardTags()) {
                                if (string.contains("coal")) {
                                    event.getWhoClicked().getVehicle().removeScoreboardTag(string);
                                    event.getWhoClicked().getVehicle().addScoreboardTag("coal0");
                                    break;
                                }
                            }
                        }catch (Exception e) {}

                    }
                }
            }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 5);

        }
    }
}

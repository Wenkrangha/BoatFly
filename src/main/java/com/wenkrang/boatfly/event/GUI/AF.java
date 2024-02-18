package com.wenkrang.boatfly.event.GUI;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.Location;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Objects;

import static com.wenkrang.boatfly.Data.MainData.IsShutDown;

public class AF implements Listener {
    @EventHandler
    public static void OnPlayer (InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("飞船控制面包")) {
            if (event.getRawSlot() == 42) {
                if (event.isLeftClick()) {
                    for (String string : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                        if (string.contains("location")) {
                            String location = string.replace("location", "");
                            String[] split = location.split(",");
                            int x = Integer.parseInt(split[0]);
                            int z = Integer.parseInt(split[1]);
                            x += 100;
                            event.getWhoClicked().getVehicle().removeScoreboardTag(string);
                            event.getWhoClicked().getVehicle().addScoreboardTag("location"+ String.valueOf(x) + "," + String.valueOf(z));
                            ((Player) event.getWhoClicked()).setCompassTarget(new Location(event.getWhoClicked().getWorld(), x, event.getWhoClicked().getLocation().getBlockY(), z));
                            break;
                        }
                    }
                }
                if (event.isRightClick()) {
                    for (String string : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                        if (string.contains("location")) {
                            String location = string.replace("location", "");
                            String[] split = location.split(",");
                            int x = Integer.parseInt(split[0]);
                            int z = Integer.parseInt(split[1]);
                            x -= 100;
                            event.getWhoClicked().getVehicle().removeScoreboardTag(string);
                            event.getWhoClicked().getVehicle().addScoreboardTag("location"+ String.valueOf(x) + "," + String.valueOf(z));
                            ((Player) event.getWhoClicked()).setCompassTarget(new Location(event.getWhoClicked().getWorld(), x, event.getWhoClicked().getLocation().getBlockY(), z));
                            break;
                        }
                    }
                }
            }
            if (event.getRawSlot() == 43) {
                if (event.isLeftClick()) {
                    for (String string : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                        if (string.contains("location")) {
                            String location = string.replace("location", "");
                            String[] split = location.split(",");
                            int x = Integer.parseInt(split[0]);
                            int z = Integer.parseInt(split[1]);
                            z += 100;
                            event.getWhoClicked().getVehicle().removeScoreboardTag(string);
                            event.getWhoClicked().getVehicle().addScoreboardTag("location"+ String.valueOf(x) + "," + String.valueOf(z));
                            ((Player) event.getWhoClicked()).setCompassTarget(new Location(event.getWhoClicked().getWorld(), x, event.getWhoClicked().getLocation().getBlockY(), z));
                            break;
                        }
                    }
                }
                if (event.isRightClick()) {
                    for (String string : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                        if (string.contains("location")) {
                            String location = string.replace("location", "");
                            String[] split = location.split(",");
                            int x = Integer.parseInt(split[0]);
                            int z = Integer.parseInt(split[1]);
                            z -= 100;
                            event.getWhoClicked().getVehicle().removeScoreboardTag(string);
                            event.getWhoClicked().getVehicle().addScoreboardTag("location"+ String.valueOf(x) + "," + String.valueOf(z));
                            ((Player) event.getWhoClicked()).setCompassTarget(new Location(event.getWhoClicked().getWorld(), x, event.getWhoClicked().getLocation().getBlockY(), z));
                            break;
                        }
                    }
                }
            }

        }
    }
}

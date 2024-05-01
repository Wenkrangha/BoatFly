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

import static com.wenkrang.boatfly.DataSystem.MainData.IsShutDown;

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

            //自动驾驶
            if (event.getRawSlot() == 38) {
                if (event.isLeftClick()) {
                    if (event.getWhoClicked().getLocation().getBlockY() > 365) {

//                        int x = 0;
//                        int z = 0;
//                        for (String string : event.getWhoClicked().getVehicle().getScoreboardTags()) {
//                            if (string.contains("location")) {
//                                String location = string.replace("location", "");
//                                String[] split = location.split(",");
//                                x = Integer.parseInt(split[0]);
//                                z = Integer.parseInt(split[1]);
//                                break;
//                            }
//                        }
//                        Location location = new Location(event.getWhoClicked().getWorld(), x, event.getWhoClicked().getLocation().getBlockY(), z);

                        try {
                            if (!event.getWhoClicked().getVehicle().getScoreboardTags().contains("AF")) {
                                Objects.requireNonNull(event.getWhoClicked().getVehicle()).addScoreboardTag("AF");
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        if (IsShutDown || !event.getWhoClicked().getVehicle().getScoreboardTags().contains("Run") || !event.getWhoClicked().getVehicle().getScoreboardTags().contains("AF")) {
                                            cancel();
                                        }
                                        int power = 0;
                                        try {
                                            for (String string : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                                                if (string.contains("eng")) {
                                                    power = Integer.parseInt(string.replace("eng", ""));
                                                    break;
                                                }
                                            }
                                        }catch (Exception e) {}

                                        if (power > 0) {
                                            try {
                                                if (event.getWhoClicked().equals(event.getWhoClicked().getVehicle().getPassengers().get(0))) {
                                                    double temp = (double) power / 100;
                                                    double realpower = temp * 2;
                                                    if (event.getWhoClicked().getVehicle().getScoreboardTags().contains("keyun")) {
                                                        realpower = temp * 3;
                                                    }
                                                    Boat boat = (Boat) event.getWhoClicked().getVehicle();
                                                    int x = 0;
                                                    int z = 0;
                                                    for (String string : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                                                        if (string.contains("location")) {
                                                            String location = string.replace("location", "");
                                                            String[] split = location.split(",");
                                                            x = Integer.parseInt(split[0]);
                                                            z = Integer.parseInt(split[1]);
                                                            break;
                                                        }
                                                    }
                                                    Location location = new Location(event.getWhoClicked().getWorld(), x, event.getWhoClicked().getLocation().getBlockY(), z);
                                                    if (event.getWhoClicked().getLocation().distance(location) < 20) {
                                                        cancel();
                                                    }
                                                    Vector multiply = location.toVector().subtract(event.getWhoClicked().getLocation().toVector()).multiply(realpower);
                                                    multiply.setY(0);

                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {
                                                            new BukkitRunnable() {

                                                                @Override
                                                                public void run() {

                                                                    if (event.getWhoClicked().getVehicle().getScoreboardTags().contains("AF")) {
                                                                        boat.setVelocity(multiply);
                                                                    }
                                                                }
                                                            }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 0);
                                                        }
                                                    }.runTaskLaterAsynchronously(BoatFly.getPlugin(BoatFly.class), 10);
                                                }
                                            }catch (Exception e) {
                                                cancel();
                                            }


                                        }

                                    }
                                }.runTaskTimerAsynchronously(BoatFly.getPlugin(BoatFly.class), 0, 1);
                            }

                        }catch (Exception e) {}

                    }
                }


                if (event.isRightClick()) {
                    event.getWhoClicked().getVehicle().removeScoreboardTag("AF");
                }
            }


        }

    }
}

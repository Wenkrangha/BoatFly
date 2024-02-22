package com.wenkrang.boatfly.event;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Objects;

import static com.wenkrang.boatfly.Data.MainData.IsShutDown;

public class VehicleEnter implements Listener {
    @EventHandler
    public static void OnVehicleEnterEvent (VehicleEnterEvent event) {
        if (event.getVehicle().getCustomName() != null) {
            if (event.getVehicle().getCustomName().equalsIgnoreCase("§9§l飞§r船")) {
                if (!event.getVehicle().getScoreboardTags().contains("CanFly")) {
                    event.getVehicle().addScoreboardTag("CanFly");
                    event.getVehicle().addScoreboardTag("eng0");
                    event.getVehicle().addScoreboardTag("OFF");
                    event.getVehicle().addScoreboardTag("coal0");
                    event.getVehicle().addScoreboardTag("location0,0");
                }
            }
            if (event.getVehicle().getCustomName().equalsIgnoreCase("§9§l货运§r飞船")) {
                if (!event.getVehicle().getScoreboardTags().contains("CanFly")) {
                    event.getVehicle().addScoreboardTag("CanFly");
                    event.getVehicle().addScoreboardTag("eng0");
                    event.getVehicle().addScoreboardTag("OFF");
                    event.getVehicle().addScoreboardTag("coal0");
                    event.getVehicle().addScoreboardTag("location0,0");
                    event.getVehicle().addScoreboardTag("huoyun");
                }
            }
            if (event.getVehicle().getScoreboardTags().contains("CanFly") && !event.getVehicle().getScoreboardTags().contains("Run")) {
                event.getVehicle().addScoreboardTag("Run");
            }

            //起飞!!!!
            if (event.getVehicle().getScoreboardTags().contains("CanFly") || Objects.requireNonNull(event.getVehicle().getCustomName()).equalsIgnoreCase("§9§l飞§r船")) {
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        if (IsShutDown || !event.getVehicle().getScoreboardTags().contains("Run")) {
                            cancel();
                        }
                        int power = 0;
                        try {
                            for (String string : event.getVehicle().getScoreboardTags()) {
                                if (string.contains("eng")) {
                                    power = Integer.parseInt(string.replace("eng", ""));
                                    break;
                                }
                            }
                        }catch (Exception e) {}

                        if (power > 0) {
                            try {
                                if (event.getEntered().equals(event.getVehicle().getPassengers().get(0))) {
                                    double temp = (double) power / 100;
                                    double realpower = temp * 2;
                                    Boat boat = (Boat) event.getVehicle();
                                    Vector multiply = event.getEntered().getLocation().getDirection().multiply(realpower);
                                    new BukkitRunnable() {


                                        @Override
                                        public void run() {
                                            new BukkitRunnable() {

                                                @Override
                                                public void run() {

                                                    if (!event.getVehicle().getScoreboardTags().contains("AF")) {
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
                        if (event.getVehicle().getScoreboardTags().contains("AF")) {
                            Player player = (Player) event.getEntered();
                            player.sendTitle("§9A§fF" , "", 0, 5, 3);
                        }

                    }
                }.runTaskTimerAsynchronously(BoatFly.getPlugin(BoatFly.class), 0, 1);
//            new BukkitRunnable() {
//
//                @Override
//                public void run() {
//                    event.getEntered().sendMessage(event.getVehicle().getScoreboardTags().toString());
//                }
//            }.runTaskTimer(BoatFly.getPlugin(BoatFly.class), 0, 1);
            }
        }

    }
}


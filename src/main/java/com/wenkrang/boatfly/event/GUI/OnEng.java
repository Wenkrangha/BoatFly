package com.wenkrang.boatfly.event.GUI;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

import static com.wenkrang.boatfly.DataSystem.MainData.IsShutDown;

public class OnEng implements Listener {
    @EventHandler
    public static void OnPlayer (InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("飞船控制面包")) {

            if (event.getRawSlot() == 10) {

                if (Objects.requireNonNull(event.getWhoClicked().getVehicle()).getScoreboardTags().contains("OFF") && event.getWhoClicked().getOpenInventory().getItem(15) != null && event.getWhoClicked().getOpenInventory().getItem(15).getType().equals(Material.COAL)) {

                    event.getWhoClicked().getVehicle().removeScoreboardTag("OFF");
                    event.getWhoClicked().getVehicle().addScoreboardTag("ON");
                    event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK1, 1, 30);


                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK1, 1, 30);
                        }
                    }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 10);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK2, 1, 30);
                        }
                    }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 20);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK1, 1, 30);
                        }
                    }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 30);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (event.getWhoClicked().getVehicle() == null) {
                                cancel();
                            }
                            if (IsShutDown || event.getWhoClicked().getVehicle() == null || event.getWhoClicked().getVehicle().getScoreboardTags().contains("OFF") || event.getWhoClicked().getVehicle().getScoreboardTags().contains("coal0")) {
                                cancel();
                            }
                            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.EXTINGUISH, 1, 100);
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
                                event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.SMOKE, 1, 100);
                            }


                        }
                    }.runTaskTimer(BoatFly.getPlugin(BoatFly.class), 0, 2);


                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            if (event.getWhoClicked().getVehicle() == null) {
                                cancel();
                            }
                            try {
                                if (IsShutDown || event.getWhoClicked().getVehicle().getScoreboardTags().contains("OFF") && !event.getWhoClicked().getVehicle().getScoreboardTags().contains("coal0")) {
                                    cancel();
                                }
                            }catch (Exception e) {}

                            new BukkitRunnable() {

                                @Override
                                public void run() {

                                    if (event.getWhoClicked().getVehicle() != null && event.getWhoClicked().getVehicle().getScoreboardTags().contains("coal0")) {
                                        String temp = null;
                                        for (String string : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                                            if (string.contains("eng")) {
                                                temp = string;
                                                break;
                                            }
                                        }
                                        if (temp != null) {
                                            event.getWhoClicked().getVehicle().removeScoreboardTag(temp);
                                            event.getWhoClicked().getVehicle().addScoreboardTag("eng0");
                                        }
                                        event.getWhoClicked().getVehicle().removeScoreboardTag("ON");
                                        event.getWhoClicked().getVehicle().addScoreboardTag("OFF");
                                        event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK1, 1, 30);
                                    }

                                    int coal = 0;
                                    try {
                                        if (event.getWhoClicked().getVehicle() != null) {
                                            if (event.getWhoClicked().getVehicle().getScoreboardTags().contains("OFF")) {
                                                cancel();
                                            }
                                            for (String s : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                                                if (s.contains("coal")) {
                                                    coal = Integer.parseInt(s.replace("coal", ""));
                                                    break;
                                                }
                                            }
                                        }

                                    }catch (Exception e) {}

                                    if (coal != 0) {
                                        event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BLAZE_SHOOT, 1, 30);
                                        for (String s : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                                            if (s.contains("coal")) {
                                                event.getWhoClicked().getVehicle().removeScoreboardTag(s);
                                                break;
                                            }
                                        }
                                        coal -= 1;
                                        event.getWhoClicked().getVehicle().addScoreboardTag("coal" + String.valueOf(coal));
                                    } else {
                                        String temp = null;
                                        for (String string : Objects.requireNonNull(event.getWhoClicked().getVehicle()).getScoreboardTags()) {
                                            if (string.contains("eng")) {
                                                temp = string;
                                                break;
                                            }
                                        }
                                        if (temp != null) {
                                            event.getWhoClicked().getVehicle().removeScoreboardTag(temp);
                                            event.getWhoClicked().getVehicle().addScoreboardTag("eng0");
                                        }
                                        event.getWhoClicked().getVehicle().removeScoreboardTag("ON");
                                        event.getWhoClicked().getVehicle().addScoreboardTag("OFF");
                                        event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK1, 1, 30);
                                    }

                                }
                            }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 0);
                        }
                    }.runTaskTimerAsynchronously(BoatFly.getPlugin(BoatFly.class), 0, 200);
                }else if(event.getWhoClicked().getVehicle().getScoreboardTags().contains("ON")) {
                    String temp = null;
                    for (String string : event.getWhoClicked().getVehicle().getScoreboardTags()) {
                        if (string.contains("eng")) {
                            temp = string;
                            break;
                        }
                    }
                    if (temp != null) {
                        event.getWhoClicked().getVehicle().removeScoreboardTag(temp);
                        event.getWhoClicked().getVehicle().addScoreboardTag("eng0");
                    }
                    event.getWhoClicked().getVehicle().removeScoreboardTag("ON");
                    event.getWhoClicked().getVehicle().addScoreboardTag("OFF");
                    event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK1, 1, 30);
                }
            }
        }
    }
}

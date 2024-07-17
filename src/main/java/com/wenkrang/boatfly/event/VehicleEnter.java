package com.wenkrang.boatfly.event;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.lib.getSpeed;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static com.wenkrang.boatfly.DataSystem.MainData.IsShutDown;

public class VehicleEnter implements Listener {
    @EventHandler
    public static void OnVehicleEnterEvent (VehicleEnterEvent event) {
        if (event.getVehicle().getCustomName() != null) {
            if (event.getVehicle().getCustomName().equalsIgnoreCase("§9§l飞§r船")) {
                if (!event.getVehicle().getScoreboardTags().contains("CanFly")) {
                    event.getVehicle().addScoreboardTag("CanFly");
                    event.getVehicle().addScoreboardTag("eng0");
                    event.getVehicle().addScoreboardTag("real0");
                    event.getVehicle().addScoreboardTag("OFF");
                    event.getVehicle().addScoreboardTag("coal0");
                    event.getVehicle().addScoreboardTag("location0,0");
                }
            }
            if (event.getVehicle().getCustomName().equalsIgnoreCase("§9§l货运§r飞船")) {
                if (!event.getVehicle().getScoreboardTags().contains("CanFly")) {
                    event.getVehicle().addScoreboardTag("CanFly");
                    event.getVehicle().addScoreboardTag("eng0");
                    event.getVehicle().addScoreboardTag("real0");
                    event.getVehicle().addScoreboardTag("OFF");
                    event.getVehicle().addScoreboardTag("coal0");
                    event.getVehicle().addScoreboardTag("location0,0");
                    event.getVehicle().addScoreboardTag("huoyun");
                }
            }
            if (event.getVehicle().getCustomName().equalsIgnoreCase("§9§l客运§r飞船")) {
                if (!event.getVehicle().getScoreboardTags().contains("CanFly")) {
                    event.getVehicle().addScoreboardTag("CanFly");
                    event.getVehicle().addScoreboardTag("eng0");
                    event.getVehicle().addScoreboardTag("real0");
                    event.getVehicle().addScoreboardTag("OFF");
                    event.getVehicle().addScoreboardTag("coal0");
                    event.getVehicle().addScoreboardTag("location0,0");
                    event.getVehicle().addScoreboardTag("keyun");
                }
            }
            if (event.getVehicle().getScoreboardTags().contains("CanFly") && !event.getVehicle().getScoreboardTags().contains("Run")) {
                event.getVehicle().addScoreboardTag("Run");
                if (event.getEntered() instanceof Player) {

                    //速度条
                    Player player = (Player) event.getEntered();
                    BossBar bossBar = Bukkit.createBossBar("§9§l当前§r时速 : ", BarColor.YELLOW, BarStyle.SOLID);
                    bossBar.addPlayer(player);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (IsShutDown || !event.getVehicle().getScoreboardTags().contains("Run")) {
                                cancel();
                            }

                            new BukkitRunnable() {

                                @Override
                                public void run() {
                                    Location location = player.getLocation();
                                    new BukkitRunnable() {

                                        @Override
                                        public void run() {
                                            double distance = location.distance(player.getLocation());
                                            bossBar.setTitle("§9§l当前§r时速 : " + String.valueOf(new BigDecimal(distance).setScale(5, RoundingMode.HALF_UP)) + " block/s");
                                            if (distance < 50) {
                                                bossBar.setProgress(distance / 50);
                                            }else {
                                                bossBar.setProgress(1);
                                            }
                                            if (distance < 10) {
                                                bossBar.setColor(BarColor.RED);
                                            }
                                            if (distance > 10 && distance < 20) {
                                                bossBar.setColor(BarColor.YELLOW);
                                            }
                                            if (distance > 20 && distance < 40) {
                                                bossBar.setColor(BarColor.GREEN);
                                            }
                                            if (distance > 40) {
                                                bossBar.setColor(BarColor.BLUE);
                                            }
                                        }
                                    }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 20);
                                }
                            }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 0);
                            if (!event.getVehicle().getPassengers().contains(event.getEntered())) {
                                bossBar.removeAll();
                                cancel();
                            }
                        }
                    }.runTaskTimer(BoatFly.getPlugin(BoatFly.class), 0, 1);

                    //仪表盘
                    Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                    Objective objective = scoreboard.registerNewObjective(player.getName(), "dummy", "飞船仪表盘");
                    objective.setDisplaySlot(DisplaySlot.SIDEBAR);

                    player.setScoreboard(scoreboard);
                    Team team = scoreboard.registerNewTeam("1");
                    team.addEntry("1");
                    objective.getScore("1").setScore(1);
                    team.setPrefix("");
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (IsShutDown || !event.getVehicle().getScoreboardTags().contains("Run")) {
                                cancel();
                            }
                            int coal = 0;
                            for (String s : event.getVehicle().getScoreboardTags()) {
                                if (s.contains("coal")) {
                                    coal = Integer.parseInt(s.replace("coal", ""));
                                    break;
                                }
                            }
                            team.setPrefix("飞船拥有的煤炭：");
                            team.setSuffix(String.valueOf(coal));
                            if (!event.getVehicle().getPassengers().contains(event.getEntered())) {
                                scoreboard.resetScores("1");
                            }
                        }
                    }.runTaskTimer(BoatFly.getPlugin(BoatFly.class), 0, 1);
                }
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
                                    if (true) {
                                        //计算真正的速度
                                        String temp = null;
                                        for (String string : event.getVehicle().getScoreboardTags()) {
                                            if (string.contains("real")) {
                                                temp = string;
                                                break;
                                            }
                                        }
                                        if (temp == null) {
                                            event.getVehicle().addScoreboardTag("real0");
                                        }
                                    }

                                    power = getSpeed.run(event.getVehicle(), power);
                                    double temp = (double) power / 100;
                                    double realpower = temp * 2;
                                    if (event.getVehicle().getScoreboardTags().contains("keyun")) {
                                        realpower = temp * 3;
                                    }

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



////Debug Tools
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


package com.wenkrang.boatfly.event;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.lib.getSpeed;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;
import org.bukkit.util.Vector;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.wenkrang.boatfly.DataSystem.MainData.IsShutDown;

public class VehicleEnter implements Listener {
    /**
     * 初始化或更新 信息
     * @param scoreboard    计分板
     * @param infoMap       信息
     * <code>
     *         infoMap: {
     *              entry1: value1,
     *              entry2: value2,
     *              ...
     *         }
     * </code>
     * @param player        玩家
     */
    public static void registerOrUpdateInfoTeam(Scoreboard scoreboard, Map<String, String> infoMap, Player player) {
        if (infoMap.size() > 0) {

            infoMap.forEach((key, val) -> {
                Team infoTeam = scoreboard.getTeam(key + "-info-team");         //name: <entry>-info-team
                if (Objects.isNull(infoTeam)) {
                    //不存在 相应的 <entry>-info-team
                    infoTeam = scoreboard.registerNewTeam(key + "-info-team");      //创建相应的infoTeam
                    infoTeam.addEntry(key);                                               //添加需要动态绑定的Entry条目
                    infoTeam.setSuffix(val);                                              //将值作为后缀，并动态影响给其他计分项
                    return;
                } else {
                    //存在 相应的 <entry>-info-team
                    if (!infoTeam.hasEntry(key)) {
                        //不存在 对应entry
                        infoTeam.addEntry(key);
                        infoTeam.setSuffix(val);
                        return;
                    } else {
                        //存在 对应entry
                        infoTeam.setSuffix(val);
                        return;
                    }
                }
            });
        }
    }
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

                    //抬头面包
                    //复用 计分板
                    Scoreboard scoreboard = player.getScoreboard();
                    if (scoreboard.equals(Bukkit.getScoreboardManager().getMainScoreboard())) {
                        //如果玩家没有计分板、或者是再用公共计分板 则新建
                        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                    }

                    //复用 侧边计分项
                    Objective sidebarObjective = scoreboard.getObjective("side-bar");
                    if (Objects.isNull(sidebarObjective)) {
                        //没找到：初始化
                        sidebarObjective = scoreboard.registerNewObjective("side-bar", "dummy", ChatColor.GOLD + "§9§l抬头§r面包");
                        sidebarObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
                    }


                    // 设置计分板
                    player.setScoreboard(scoreboard);
                    Scoreboard finalScoreboard = scoreboard;

                    //赋值 由于准则是 health，所以这里的分数就会由服务器自动更新，无需我们手动设置getScore()
                    Objective finalSidebarObjective = sidebarObjective;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Location location = player.getLocation();
                            if (IsShutDown || !event.getVehicle().getScoreboardTags().contains("Run") || !event.getVehicle().getPassengers().contains(event.getEntered())) {
                                finalSidebarObjective.unregister();
                                cancel();
                                                           }
                            new BukkitRunnable() {

                                @Override
                                public void run() {
                                    if (!(IsShutDown || !event.getVehicle().getScoreboardTags().contains("Run") || !event.getVehicle().getPassengers().contains(event.getEntered()))) {
                                        /**
                                         * 无闪烁计分板的实现，信息并不依靠{@link Objective#unregister()} 先注销再赋值来实现，
                                         * 而是利用{@link Team#setSuffix(String)} 会 动态影响其他 同Entry计分项来实现。
                                         *
                                         * 注意要让这里getScore()传递的entry参数和下面给信息Team addEntry()传递的参数一致
                                         */
                                        //赋值 侧边计分项
                                        finalSidebarObjective.getScore("§l飞行员 ：").setScore(6);
                                        finalSidebarObjective.getScore("§9§l当前§r方向 ：").setScore(5);
                                        finalSidebarObjective.getScore("§9§l剩余§r煤炭 ：").setScore(4);
                                        finalSidebarObjective.getScore("§9§l煤炭耗尽§r倒计时(s) ：").setScore(3);
                                        finalSidebarObjective.getScore("§9§l飞行§r高度 ：").setScore(1);
                                        finalSidebarObjective.getScore("§9§l保险§r情况 ：").setScore(0);
                                        finalSidebarObjective.getScore("§9§l发动机§r情况 ：").setScore(-1);
                                        finalSidebarObjective.getScore("当前时间").setScore(-2);



                                        /**
                                         * 重点，这里注册的Team并不是为了组队，而是利用Team特性动态影响其他计分项
                                         * addEntry()传递的entry要和上面的侧边栏计分项一致。
                                         *
                                         * 一个Entry条目对应一个Team，如果一个Team里设了两个Entry，那么最后的效果是setSuffix()后这两个Entry就显示同样的后缀了。
                                         * 显然并不符合预期要求。
                                         * 由于我们在上面的侧边栏计分板里写了非常多的Entry条目，一个个拿来写就会造成代码体积疯狂膨胀，
                                         * 不仅麻烦，还影响可读性。因此建议根据业务场景抽象出合适的方法用于简化代码。
                                         */
                                        HashMap<String, String> infoMap = new HashMap<>();
                                        infoMap.put("§l飞行员 ：", player.getName());
                                        infoMap.put("§9§l当前§r方向 ：", String.valueOf(player.getLocation().getYaw()));
                                        int coal = 0;
                                        for (String s : event.getVehicle().getScoreboardTags()) {
                                            if (s.contains("coal")) {
                                                coal = Integer.parseInt(s.replace("coal", ""));
                                                break;
                                            }
                                        }
                                        infoMap.put("§9§l剩余§r煤炭 ：", String.valueOf(coal));

                                        infoMap.put("§9§l煤炭耗尽§r倒计时(s) ：", String.valueOf(coal * 200));                                         //用String.valueOf(int)
                                        infoMap.put("§9§l飞行§r高度 ：", String.valueOf(player.getLocation().getY()));
                                        if (player.getVehicle().getScoreboardTags().contains("CanFire")) {
                                            infoMap.put("§9§l保险§r情况 ：", ChatColor.RED + "ON");
                                        } else {
                                            infoMap.put("§9§l保险§r情况 ：", ChatColor.GREEN + "OFF");
                                        }

                                        if (player.getVehicle().getScoreboardTags().contains("ON")) {
                                            infoMap.put("§9§l发动机§r情况 ：", ChatColor.RED + "ON");
                                        } else {
                                            infoMap.put("§9§l发动机§r情况 ：", ChatColor.GREEN + "OFF");
                                        }
                                        infoMap.put("§9§l当前§r时间", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

                                        //初始化或更新 信息队伍
                                        registerOrUpdateInfoTeam(finalScoreboard, infoMap, player);

                                        //设置 计分板
                                        player.setScoreboard(finalScoreboard);
                                    }

                                }
                            }.runTaskTimer(BoatFly.getPlugin(BoatFly.class), 0, 20);

                        }
                    }.runTaskTimerAsynchronously(BoatFly.getPlugin(BoatFly.class), 0, 1);


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


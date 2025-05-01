package com.wenkrang.boatfly.lib;

import org.bukkit.Location;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;


public class PlaneUtil {
    //这些方法用于生成飞船
    //但现在已经不怎么用了
    //所有的Tag都在玩家乘上的时候添加
    public static void getPlane(Location location) {
        final var boat = (Boat) location.getWorld().spawnEntity(location, EntityType.valueOf(
                VersionChecker.isVersionBelow("1.21.2") ? "BOAT" : "OAK_BOAT"
        ));
        boat.addScoreboardTag("CanFly");
        boat.addScoreboardTag("eng0");
        boat.addScoreboardTag("real0");
        boat.addScoreboardTag("OFF");
        boat.addScoreboardTag("coal0");
        boat.addScoreboardTag("location0,0");
        boat.setCustomNameVisible(true);
        boat.setCustomName("§9§l飞§r船");
    }
    //货运飞船的tag
    public static void getPlaneLevel2(Location location) {
        final var boat = (Boat) location.getWorld().spawnEntity(location, EntityType.valueOf(
                VersionChecker.isVersionBelow("1.21.2") ? "BOAT" : "OAK_BOAT"
        ));
        boat.addScoreboardTag("CanFly");
        boat.addScoreboardTag("eng0");
        boat.addScoreboardTag("real0");
        boat.addScoreboardTag("OFF");
        boat.addScoreboardTag("coal0");
        boat.addScoreboardTag("location0,0");
        boat.addScoreboardTag("huoyun");
        boat.setCustomNameVisible(true);
        boat.setCustomName("§9§l货运§r飞船");
    }
    //客运飞船的tag
    public static void getPlaneLevel3(Location location) {
        final var boat = (Boat) location.getWorld().spawnEntity(location, EntityType.valueOf(
                VersionChecker.isVersionBelow("1.21.2") ? "BOAT" : "OAK_BOAT"
        ));
        boat.addScoreboardTag("CanFly");
        boat.addScoreboardTag("eng0");
        boat.addScoreboardTag("real0");
        boat.addScoreboardTag("OFF");
        boat.addScoreboardTag("coal0");
        boat.addScoreboardTag("location0,0");
        boat.addScoreboardTag("keyun");
        boat.setCustomNameVisible(true);
        boat.setCustomName("§9§l货运§r飞船");
    }
}

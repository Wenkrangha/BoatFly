package com.wenkrang.boatfly.Entity;

import org.bukkit.Location;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;


public class plane {
    //这些方法用于生成飞船
    //但现在已经不怎么用了
    //所有的Tag都在玩家乘上的时候添加
    public static void getplane(Location location) {
        Boat boat = (Boat) location.getWorld().spawnEntity(location, EntityType.BOAT);
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
    public static void getplanelevetwo(Location location) {
        org.bukkit.entity.Boat boat =  (Boat) location.getWorld().spawnEntity(location, EntityType.BOAT);
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
    public static void getplanelevethree(Location location) {
        org.bukkit.entity.Boat boat =  (Boat) location.getWorld().spawnEntity(location, EntityType.BOAT);
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

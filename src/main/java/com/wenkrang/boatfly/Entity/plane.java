package com.wenkrang.boatfly.Entity;

import org.bukkit.Location;


public class plane {
    public static void getplane(Location location) {
        org.bukkit.entity.Boat boat = location.getWorld().spawn(location, org.bukkit.entity.Boat.class);
        boat.addScoreboardTag("CanFly");
        boat.addScoreboardTag("eng0");
        boat.addScoreboardTag("OFF");
        boat.addScoreboardTag("coal0");
        boat.addScoreboardTag("location0,0");
        boat.setCustomNameVisible(true);
        boat.setCustomName("§9§l飞§r船");
    }
}

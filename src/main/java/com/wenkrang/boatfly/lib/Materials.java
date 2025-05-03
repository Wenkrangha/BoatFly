package com.wenkrang.boatfly.lib;

import org.bukkit.Material;

import java.util.HashMap;

public final class Materials {

    public static Material chestBoat;

    public static Material lightningRod;
    public static Material deepslate;

    public static Material target;
    public static Material netheriteScrap;
    public static Material netheriteIngot;
    public static Material netheriteSword;

    public static Material beeHive;
    public static Material honeyBlock;

    public static Material campfire;
    public static Material blastFurnace;
    public static Material smoker;
    public static Material smithingTable;
    public static Material sign;
    public static Material grindstone;

    public static Material none;
    public static Material off;
    public static Material on;

    private static final HashMap<String, Material> map = new HashMap<>();

    public static Material get(String key) {
        ConsoleLogger.info(map.toString());
        return map.get(key) == null ? Material.valueOf(key) : map.get(key);
    }

    public static void put(String key, Material value) {
        ConsoleLogger.info(map.toString());
        map.put(key, value);
    }
}

package com.wenkrang.boatfly.lib;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Materials extends HashMap<String, Material> {
    private Materials() {
        super();
    }

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

    public static final Map<String, Material> INSTANCE = new Materials();

    @Override
    public Material get(Object key) {
        return Objects.requireNonNullElse(super.get(key), Material.valueOf(key.toString()));
    }
}

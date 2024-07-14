package com.wenkrang.boatfly.lib;

import org.bukkit.Material;

public class Materials {
    //wild update
    public static Material chestBoat;
    //caves and cliffs
    public static Material lightningRod;
    public static Material deepslate;
    //nether update
    public static Material target;
    public static Material netheriteScrap;
    public static Material netheriteIngot;
    public static Material netheriteSword;
    //buzzy bees update
    public static Material beeHive;
    public static Material honeyBlock;
    //village and pillage update
    public static Material campfire;
    public static Material blastFurnace;
    public static Material smoker;
    public static Material smithingTable;
    public static Material sign;
    public static Material grindstone;
    //???
    public static Material none;
    public static Material off;
    public static Material on;
    public static void init() {
        try {
            chestBoat = Material.OAK_CHEST_BOAT;
        } catch (NoSuchFieldError e) {
            ConsoleLoger.info("服务器版本低于1.19，正在回退新内容");
            chestBoat = Material.OAK_BOAT;
        }
        try {
            lightningRod = Material.LIGHTNING_ROD;
            deepslate = Material.DEEPSLATE;
        } catch (NoSuchFieldError e) {
            ConsoleLoger.info("服务器版本低于1.17，正在回退新内容");
            lightningRod = Material.STICK;
            deepslate = Material.STONE;
        }
        try {
            target = Material.TARGET;
            netheriteIngot = Material.NETHERITE_INGOT;
            netheriteScrap = Material.NETHERITE_SCRAP;
            netheriteSword = Material.NETHERITE_SWORD;
        } catch (NoSuchFieldError e) {
            ConsoleLoger.info("服务器版本低于1.16，正在回退新内容");
            target = Material.STONE;
            netheriteIngot = Material.DIAMOND;
            netheriteScrap = Material.IRON_NUGGET;
            netheriteSword = Material.DIAMOND_SWORD;
        }
        try {
            beeHive = Material.BEEHIVE;
            honeyBlock = Material.HONEY_BLOCK;
        } catch (NoSuchFieldError e) {
            ConsoleLoger.info("服务器版本低于1.15，正在回退新内容");
            beeHive = Material.CHEST;
            honeyBlock = Material.SLIME_BLOCK;
        }
        try {
            campfire = Material.CAMPFIRE;
            blastFurnace = Material.BLAST_FURNACE;
            smoker = Material.SMOKER;
            smithingTable = Material.SMITHING_TABLE;
            sign = Material.OAK_SIGN;
            grindstone = Material.GRINDSTONE;
        } catch (NoSuchFieldError e) {
            ConsoleLoger.info("服务器版本低于1.14，正在回退新内容");
            campfire = Material.FLINT_AND_STEEL;
            blastFurnace = Material.FURNACE;
            smoker = Material.FURNACE;
            smithingTable = Material.CRAFTING_TABLE;
            sign = Material.BOOK; //1.13尽量不用sign
            grindstone = Material.STONE;
        }
        none = Material.LIGHT_BLUE_STAINED_GLASS_PANE;
        off = Material.RED_STAINED_GLASS_PANE;
        on = Material.GREEN_STAINED_GLASS_PANE;
    }
}

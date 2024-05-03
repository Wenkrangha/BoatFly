package com.wenkrang.boatfly.item;

import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.Material;

public class Materials {
    //wild update
    public static Material chestBoat;
    //caves and cliffs
    public static Material lightningRod;
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
    public static void init() {
        try {
            try {
                chestBoat = Material.OAK_CHEST_BOAT;
            } catch (NoSuchFieldError e) {
                ConsoleLoger.info("服务器版本低于1.19，正在回退新内容");
                chestBoat = Material.OAK_BOAT;
            }
            try {
                lightningRod = Material.LIGHTNING_ROD;
            } catch (NoSuchFieldError e) {
                ConsoleLoger.info("服务器版本低于1.17，正在回退新内容");
                lightningRod = Material.STICK;
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
        } catch (NoSuchFieldError e) {
            chestBoat = Material.LEGACY_BOAT;
            none = Material.LEGACY_THIN_GLASS;
        }
    }
}

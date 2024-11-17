package com.wenkrang.boatfly.Loader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wenkrang.boatfly.UpgradeSystem.Source;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.Materials;
import com.wenkrang.boatfly.lib.UnsafeDownloader;
import com.wenkrang.boatfly.lib.VersionChecker;
import org.bukkit.Material;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;

public final class LoadMaterials {
    private LoadMaterials() {
        throw new IllegalStateException("Utility class");
    }
    public static void run() {
        try {
            var file = new File("plugins/BoatFly/MaterialLocal.json");
            if (!file.exists()) {
                var fileName = "upgrade/Materials";
                if (!VersionChecker.isVersionBelow("1.19")) {
                    fileName += "119.json";
                } else if (!VersionChecker.isVersionBelow("1.17")) {
                    fileName += "117.json";
                } else if (!VersionChecker.isVersionBelow("1.16")) {
                    fileName += "116.json";
                } else if (!VersionChecker.isVersionBelow("1.15")) {
                    fileName += "114.json";
                } else if (!VersionChecker.isVersionBelow("1.14")) {
                    throw new RuntimeException("break");
                }
                ConsoleLoger.info("正在下载Material映射文件");
                UnsafeDownloader.downloadFile(Source.getSource(false) + fileName, "plugins/BoatFly/MaterialLocal.json");
            }
            var fileReader = new FileReader("plugins/BoatFly/MaterialLocal.json");
            var bufferedReader = new BufferedReader(fileReader);
            ((JsonObject) JsonParser.parseReader(bufferedReader)).entrySet().forEach(i -> {
                if (Objects.equals(i.getKey(), "minecraft")) {
                    if (VersionChecker.isVersionBelow(i.getValue().toString())) {
                        file.delete();
                        throw new RuntimeException("break");
                    }
                } else {
                    Materials.materials.put(i.getKey(), Material.valueOf(i.getValue().toString()));
                }
            });
            Materials.chestBoat = Materials.materials.get("CHEST_BOAT");
            Materials.lightningRod = Materials.materials.get("LIGHTNING_ROD");
            Materials.deepslate = Materials.materials.get("DEEPSLATE");
            Materials.target = Materials.materials.get("TARGET");
            Materials.netheriteScrap = Materials.materials.get("NETHERITE_SCRAP");
            Materials.netheriteIngot = Materials.materials.get("NETHERITE_INGOT");
            Materials.netheriteSword = Materials.materials.get("NETHERITE_SWORD");
            Materials.beeHive = Materials.materials.get("BEE_HIVE");
            Materials.honeyBlock = Materials.materials.get("HONEY_BLOCK");
            Materials.campfire = Materials.materials.get("CAMPFIRE");
            Materials.blastFurnace = Materials.materials.get("BLAST_FURNACE");
            Materials.smoker = Materials.materials.get("SMOKER");
            Materials.smithingTable = Materials.materials.get("SMITHING_TABLE");
            Materials.sign = Materials.materials.get("SIGN");
            Materials.grindstone = Materials.materials.get("GRINDSTONE");
            Materials.none = Materials.materials.get("LIGHT_BLUE_STAINED_GLASS_PANE");
            Materials.off = Materials.materials.get("RED_STAINED_GLASS_PANE");
            Materials.on = Materials.materials.get("GREEN_STAINED_GLASS_PANE");
        } catch (Exception e) {
            Materials.offlineInit();
        }
    }
}

package com.wenkrang.boatfly.Loader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wenkrang.boatfly.UpgradeSystem.Source;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.Materials;
import com.wenkrang.boatfly.lib.UnsafeDownloader;
import com.wenkrang.boatfly.lib.VersionChecker;
import org.bukkit.Material;

import java.io.File;
import java.io.FileReader;
import java.util.Objects;

public final class LoadMaterials {
    private LoadMaterials() {
        throw new IllegalStateException("Utility class");
    }
    public static void run() {
        try {
            final var file = new File("plugins/BoatFly/MaterialLocal.json");
            if (!file.exists()) {
                var fileName = new StringBuilder().append("upgrade/Materials");
                if (!VersionChecker.isVersionBelow("1.19")) {
                    fileName.append("119.json");
                } else if (!VersionChecker.isVersionBelow("1.17")) {
                    fileName.append("117.json");
                } else if (!VersionChecker.isVersionBelow("1.16")) {
                    fileName.append("116.json");
                } else if (!VersionChecker.isVersionBelow("1.15")) {
                    fileName.append("114.json");
                } else if (!VersionChecker.isVersionBelow("1.14")) {
                    throw new RuntimeException("break");
                }
                ConsoleLoger.info("正在下载Material映射文件");
                UnsafeDownloader.downloadFile(Source.getSource(false) + fileName, "plugins/BoatFly/MaterialLocal.json");
            }
            final var fileReader = new FileReader("plugins/BoatFly/MaterialLocal.json");
            ((JsonObject) JsonParser.parseReader(fileReader)).entrySet().forEach(i -> {
                if (Objects.equals(i.getKey(), "minecraft")) {
                    if (VersionChecker.isVersionBelow(i.getValue().toString().substring(1, 5))) {
                        file.delete();
                        throw new RuntimeException("break");
                    }
                } else {
                    final var element = i.getValue().toString();
                    final var finalString = element.substring(1, element.length() - 1);
                    Materials.set(i.getKey(), Material.valueOf(finalString));
                }
            });
            fileReader.close();
            Materials.chestBoat = Materials.get("CHEST_BOAT");
            Materials.lightningRod = Materials.get("LIGHTNING_ROD");
            Materials.deepslate = Materials.get("DEEPSLATE");
            Materials.target = Materials.get("TARGET");
            Materials.netheriteScrap = Materials.get("NETHERITE_SCRAP");
            Materials.netheriteIngot = Materials.get("NETHERITE_INGOT");
            Materials.netheriteSword = Materials.get("NETHERITE_SWORD");
            Materials.beeHive = Materials.get("BEE_HIVE");
            Materials.honeyBlock = Materials.get("HONEY_BLOCK");
            Materials.campfire = Materials.get("CAMPFIRE");
            Materials.blastFurnace = Materials.get("BLAST_FURNACE");
            Materials.smoker = Materials.get("SMOKER");
            Materials.smithingTable = Materials.get("SMITHING_TABLE");
            Materials.sign = Materials.get("SIGN");
            Materials.grindstone = Materials.get("GRINDSTONE");
            Materials.none = Materials.get("LIGHT_BLUE_STAINED_GLASS_PANE");
            Materials.off = Materials.get("RED_STAINED_GLASS_PANE");
            Materials.on = Materials.get("GREEN_STAINED_GLASS_PANE");
        } catch (Exception e) {
            Materials.offlineInit();
        }
    }
}

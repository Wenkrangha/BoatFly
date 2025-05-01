package com.wenkrang.boatfly.Loader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wenkrang.boatfly.UpgradeSystem.Source;
import com.wenkrang.boatfly.lib.ConsoleLogger;
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
                ConsoleLogger.info("正在下载Material映射文件");
                UnsafeDownloader.downloadFile(Source.SourceURL + fileName, "plugins/BoatFly/MaterialLocal.json");
            }
            try (final var reader = new FileReader("plugins/BoatFly/MaterialLocal.json")) {
                ((JsonObject) JsonParser.parseReader(reader)).entrySet().forEach(i -> {
                    if (Objects.equals(i.getKey(), "minecraft")) {
                        if (VersionChecker.isVersionBelow(i.getValue().toString().substring(1, 5))) {
                            file.delete();
                            throw new RuntimeException("break");
                        }
                    } else {
                        final var element = i.getValue().toString();
                        final var finalString = element.substring(1, element.length() - 1);
                        Materials.INSTANCE.put(i.getKey(), Material.valueOf(finalString));
                    }
                });
            }
            Materials.chestBoat = Materials.INSTANCE.get("CHEST_BOAT");
            Materials.lightningRod = Materials.INSTANCE.get("LIGHTNING_ROD");
            Materials.deepslate = Materials.INSTANCE.get("DEEPSLATE");
            Materials.target = Materials.INSTANCE.get("TARGET");
            Materials.netheriteScrap = Materials.INSTANCE.get("NETHERITE_SCRAP");
            Materials.netheriteIngot = Materials.INSTANCE.get("NETHERITE_INGOT");
            Materials.netheriteSword = Materials.INSTANCE.get("NETHERITE_SWORD");
            Materials.beeHive = Materials.INSTANCE.get("BEE_HIVE");
            Materials.honeyBlock = Materials.INSTANCE.get("HONEY_BLOCK");
            Materials.campfire = Materials.INSTANCE.get("CAMPFIRE");
            Materials.blastFurnace = Materials.INSTANCE.get("BLAST_FURNACE");
            Materials.smoker = Materials.INSTANCE.get("SMOKER");
            Materials.smithingTable = Materials.INSTANCE.get("SMITHING_TABLE");
            Materials.sign = Materials.INSTANCE.get("SIGN");
            Materials.grindstone = Materials.INSTANCE.get("GRINDSTONE");
            Materials.none = Materials.INSTANCE.get("LIGHT_BLUE_STAINED_GLASS_PANE");
            Materials.off = Materials.INSTANCE.get("RED_STAINED_GLASS_PANE");
            Materials.on = Materials.INSTANCE.get("GREEN_STAINED_GLASS_PANE");
        } catch (Exception e) {
            Materials.offlineInit();
        }
    }
}

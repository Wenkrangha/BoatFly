package com.wenkrang.boatfly.loader;

import com.google.gson.reflect.TypeToken;
import com.wenkrang.boatfly.data.MainData;
import com.wenkrang.boatfly.upgrade.Source;
import com.wenkrang.boatfly.lib.ConsoleLogger;
import com.wenkrang.boatfly.lib.Materials;
import com.wenkrang.boatfly.lib.UnsafeDownloader;
import com.wenkrang.boatfly.lib.VersionChecker;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public final class LoadMaterials {
    private LoadMaterials() {
        throw new IllegalStateException("Utility class");
    }

    private static final String MATERIALS_113 = """
            {
              "minecraft": "1.13",
              "CHEST_BOAT": "OAK_BOAT",
              "LIGHTNING_ROD": "STICK",
              "DEEPSLATE": "STONE",
              "COPPER_INGOT": "IRON_INGOT",
              "TARGET": "STONE",
              "NETHERITE_SCRAP": "IRON_NUGGET",
              "NETHERITE_INGOT": "DIAMOND",
              "NETHERITE_SWORD": "DIAMOND_SWORD",
              "BEE_HIVE": "CHEST",
              "HONEY_BLOCK": "SLIME_BLOCK",
              "CAMPFIRE": "FLINT_AND_STEEL",
              "BLAST_FURNACE": "FURNACE",
              "SMOKER": "FURNACE",
              "SMITHING_TABLE": "CRAFTING_TABLE",
              "SIGN": "SIGN",
              "GRINDSTONE": "STONE",
              "LIGHT_BLUE_STAINED_GLASS_PANE": "LIGHT_BLUE_STAINED_GLASS_PANE",
              "RED_STAINED_GLASS_PANE": "RED_STAINED_GLASS_PANE",
              "GREEN_STAINED_GLASS_PANE": "GREEN_STAINED_GLASS_PANE",
              "CARTOGRAPHY_TABLE": "CRAFTING_TABLE"
            }
            """;

    private static final String MATERIALS_114 = """
            {
              "minecraft": "1.14",
              "CHEST_BOAT": "OAK_BOAT",
              "LIGHTNING_ROD": "STICK",
              "DEEPSLATE": "STONE",
              "COPPER_INGOT": "IRON_INGOT",
              "TARGET": "STONE",
              "NETHERITE_SCRAP": "IRON_NUGGET",
              "NETHERITE_INGOT": "DIAMOND",
              "NETHERITE_SWORD": "DIAMOND_SWORD",
              "BEE_HIVE": "CHEST",
              "HONEY_BLOCK": "SLIME_BLOCK",
              "CAMPFIRE": "CAMPFIRE",
              "BLAST_FURNACE": "BLAST_FURNACE",
              "SMOKER": "SMOKER",
              "SMITHING_TABLE": "SMITHING_TABLE",
              "SIGN": "OAK_SIGN",
              "GRINDSTONE": "GRINDSTONE",
              "LIGHT_BLUE_STAINED_GLASS_PANE": "LIGHT_BLUE_STAINED_GLASS_PANE",
              "RED_STAINED_GLASS_PANE": "RED_STAINED_GLASS_PANE",
              "GREEN_STAINED_GLASS_PANE": "GREEN_STAINED_GLASS_PANE",
              "CARTOGRAPHY_TABLE": "CARTOGRAPHY_TABLE"
            }
            """;

    private static final String MATERIALS_115 = """
            {
              "minecraft": "1.15",
              "CHEST_BOAT": "OAK_BOAT",
              "LIGHTNING_ROD": "STICK",
              "DEEPSLATE": "STONE",
              "COPPER_INGOT": "IRON_INGOT",
              "TARGET": "STONE",
              "NETHERITE_SCRAP": "IRON_NUGGET",
              "NETHERITE_INGOT": "DIAMOND",
              "NETHERITE_SWORD": "DIAMOND_SWORD",
              "BEE_HIVE": "BEEHIVE",
              "HONEY_BLOCK": "HONEY_BLOCK",
              "CAMPFIRE": "CAMPFIRE",
              "BLAST_FURNACE": "BLAST_FURNACE",
              "SMOKER": "SMOKER",
              "SMITHING_TABLE": "SMITHING_TABLE",
              "SIGN": "OAK_SIGN",
              "GRINDSTONE": "GRINDSTONE",
              "LIGHT_BLUE_STAINED_GLASS_PANE": "LIGHT_BLUE_STAINED_GLASS_PANE",
              "RED_STAINED_GLASS_PANE": "RED_STAINED_GLASS_PANE",
              "GREEN_STAINED_GLASS_PANE": "GREEN_STAINED_GLASS_PANE",
              "CARTOGRAPHY_TABLE": "CARTOGRAPHY_TABLE"
            }
            """;

    private static final String MATERIALS_116 = """
            {
              "minecraft": "1.16",
              "CHEST_BOAT": "OAK_BOAT",
              "LIGHTNING_ROD": "STICK",
              "DEEPSLATE": "STONE",
              "COPPER_INGOT": "IRON_INGOT",
              "TARGET": "TARGET",
              "NETHERITE_SCRAP": "NETHERITE_SCRAP",
              "NETHERITE_INGOT": "NETHERITE_INGOT",
              "NETHERITE_SWORD": "NETHERITE_SWORD",
              "BEE_HIVE": "BEEHIVE",
              "HONEY_BLOCK": "HONEY_BLOCK",
              "CAMPFIRE": "CAMPFIRE",
              "BLAST_FURNACE": "BLAST_FURNACE",
              "SMOKER": "SMOKER",
              "SMITHING_TABLE": "SMITHING_TABLE",
              "SIGN": "OAK_SIGN",
              "GRINDSTONE": "GRINDSTONE",
              "LIGHT_BLUE_STAINED_GLASS_PANE": "LIGHT_BLUE_STAINED_GLASS_PANE",
              "RED_STAINED_GLASS_PANE": "RED_STAINED_GLASS_PANE",
              "GREEN_STAINED_GLASS_PANE": "GREEN_STAINED_GLASS_PANE",
              "CARTOGRAPHY_TABLE": "CARTOGRAPHY_TABLE"
            }
            """;

    private static final String MATERIALS_117 = """
            {
              "minecraft": "1.17",
              "CHEST_BOAT": "OAK_BOAT",
              "LIGHTNING_ROD": "LIGHTNING_ROD",
              "DEEPSLATE": "DEEPSLATE",
              "COPPER_INGOT": "COPPER_INGOT",
              "TARGET": "TARGET",
              "NETHERITE_SCRAP": "NETHERITE_SCRAP",
              "NETHERITE_INGOT": "NETHERITE_INGOT",
              "NETHERITE_SWORD": "NETHERITE_SWORD",
              "BEE_HIVE": "BEEHIVE",
              "HONEY_BLOCK": "HONEY_BLOCK",
              "CAMPFIRE": "CAMPFIRE",
              "BLAST_FURNACE": "BLAST_FURNACE",
              "SMOKER": "SMOKER",
              "SMITHING_TABLE": "SMITHING_TABLE",
              "SIGN": "OAK_SIGN",
              "GRINDSTONE": "GRINDSTONE",
              "LIGHT_BLUE_STAINED_GLASS_PANE": "LIGHT_BLUE_STAINED_GLASS_PANE",
              "RED_STAINED_GLASS_PANE": "RED_STAINED_GLASS_PANE",
              "GREEN_STAINED_GLASS_PANE": "GREEN_STAINED_GLASS_PANE",
              "CARTOGRAPHY_TABLE": "CARTOGRAPHY_TABLE"
            }
            """;

    private static final String MATERIALS_119 = """
            {
              "minecraft": "1.19",
              "CHEST_BOAT": "OAK_CHEST_BOAT",
              "LIGHTNING_ROD": "LIGHTNING_ROD",
              "DEEPSLATE": "DEEPSLATE",
              "COPPER_INGOT": "COPPER_INGOT",
              "TARGET": "TARGET",
              "NETHERITE_SCRAP": "NETHERITE_SCRAP",
              "NETHERITE_INGOT": "NETHERITE_INGOT",
              "NETHERITE_SWORD": "NETHERITE_SWORD",
              "BEE_HIVE": "BEEHIVE",
              "HONEY_BLOCK": "HONEY_BLOCK",
              "CAMPFIRE": "CAMPFIRE",
              "BLAST_FURNACE": "BLAST_FURNACE",
              "SMOKER": "SMOKER",
              "SMITHING_TABLE": "SMITHING_TABLE",
              "SIGN": "OAK_SIGN",
              "GRINDSTONE": "GRINDSTONE",
              "LIGHT_BLUE_STAINED_GLASS_PANE": "LIGHT_BLUE_STAINED_GLASS_PANE",
              "RED_STAINED_GLASS_PANE": "RED_STAINED_GLASS_PANE",
              "GREEN_STAINED_GLASS_PANE": "GREEN_STAINED_GLASS_PANE",
              "CARTOGRAPHY_TABLE": "CARTOGRAPHY_TABLE"
            }
            """;

    public static void run() {
        var reader = Optional.<Reader>empty();
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
                    fileName.append("115.json");
                } else if (!VersionChecker.isVersionBelow("1.14")) {
                    fileName.append("114.json");
                } else if (!VersionChecker.isVersionBelow("1.13")) {
                    fileName.append("113.json");
                } else {
                    incorrectVersion("1.13");
                }
                ConsoleLogger.info("正在下载Material映射文件");
                UnsafeDownloader.downloadFile(Source.SourceURL + fileName, "plugins/BoatFly/MaterialLocal.json");
            }
            reader = Optional.of(new FileReader("plugins/BoatFly/MaterialLocal.json"));
        } catch (Exception e) {
            ConsoleLogger.warn("无法下载Material映射文件，改用本地加载");
            reader = Optional.of(new StringReader(switch (VersionChecker.getVersion().substring(0, 4)) {
                case "1.18", "1.17" -> MATERIALS_117;
                case "1.16" -> MATERIALS_116;
                case "1.15" -> MATERIALS_115;
                case "1.14" -> MATERIALS_114;
                case "1.13" -> MATERIALS_113;
                default /*1.19+*/ -> MATERIALS_119;
            }));
        } finally {
            HashMap<String, String> map = MainData.gson.fromJson(
                    reader.orElse(new StringReader(MATERIALS_113)),
                    new TypeToken<HashMap<String, String>>(){}.getType());

            ConsoleLogger.info(map.toString());

            if (VersionChecker.isVersionBelow(map.get("minecraft"))) {
                incorrectVersion(map.get("minecraft"));
            }

            map.entrySet()
                    .stream()
                    .filter(i -> !Objects.equals(i.getKey(), "minecraft"))
                    .forEach(i -> {
                        try {
                            Materials.put(i.getKey(), Material.valueOf(i.getValue()));
                        } catch (IllegalArgumentException e) {
                            incorrectVersion("???（" + i.getValue() + "）");
                        }
                    });

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
        }
    }

    private static void incorrectVersion(String required) {
        ConsoleLogger.error("服务端版本不正确！");
        ConsoleLogger.error("要求版本：" + required);
        ConsoleLogger.error("当前版本：" + VersionChecker.getVersion());
        Bukkit.shutdown();
    }
}

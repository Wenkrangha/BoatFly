package com.wenkrang.boatfly.Entity;

import com.wenkrang.boatfly.DataSystem.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.Materials;
import com.wenkrang.boatfly.lib.VersionChecker;
import org.bukkit.*;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HouseLocation {
    public static Location getRandomHouseLocation() {
        Random rand = new Random();
        double x = rand.nextDouble(50000000) - 25000000;
        double z = rand.nextDouble(50000000) - 25000000;
        double y = -64D;
        Location location;
        Material stone = Materials.deepslate;
        boolean cavesAndCliffsDatapackDetected;
        if (VersionChecker.isVersionBelow("1.18")) {
            if (VersionChecker.isVersionBelow("1.17")) {
                y = 0D;
            } else {
                cavesAndCliffsDatapackDetected = getAllDataPacks().contains("cave");
                if (cavesAndCliffsDatapackDetected) {
                    ConsoleLoger.info("1.17 experimental datapack detected");
                } else {
                    y = 0D;
                    stone = Material.STONE;
                }
            }
        }
        World overworld = Bukkit.getWorld("world");
        Location lc1 = new Location(overworld, x + 15, y + 3, z + 15);
        Location lc2 = new Location(overworld, x - 15, y + 3, z - 15);
        Location lc3 = new Location(overworld, x + 15, y + 3, z - 15);
        Location lc4 = new Location(overworld, x - 15, y + 3, z + 15);
        while (!((lc1.getBlock().getType().equals(stone) || lc1.getBlock().getType().equals(Material.BEDROCK)) &&
                (lc2.getBlock().getType().equals(stone) || lc2.getBlock().getType().equals(Material.BEDROCK)) &&
                (lc3.getBlock().getType().equals(stone) || lc3.getBlock().getType().equals(Material.BEDROCK)) &&
                (lc4.getBlock().getType().equals(stone) || lc4.getBlock().getType().equals(Material.BEDROCK)))) {
            x = rand.nextDouble(50000000) - 25000000;
            z = rand.nextDouble(50000000) - 25000000;
            lc1 = new Location(overworld, x + 15, y + 3, z + 15);
            lc2 = new Location(overworld, x - 15, y + 3, z - 15);
            lc3 = new Location(overworld, x + 15, y + 3, z - 15);
            lc4 = new Location(overworld, x - 15, y + 3, z + 15);
        }
        location = new Location(overworld, x, y, z);
        return location;
    }

    private static Set<String> getAllDataPacks() {
        Set<String> dataPacks = new HashSet<>();
        Plugin plugin = MainData.plugin;

        if (plugin != null && plugin.isEnabled()) {
            try {
                Field dataPackField = plugin.getClass().getDeclaredField("dataPacks");
                dataPackField.setAccessible(true);
                Object dataPackObject = dataPackField.get(plugin);
                Field dataPacksField = dataPackObject.getClass().getDeclaredField("dataPacks");
                dataPacksField.setAccessible(true);
                Object[] dataPackArray = (Object[]) dataPacksField.get(dataPackObject);

                for (Object dataPack : dataPackArray) {
                    Field nameField = dataPack.getClass().getDeclaredField("name");
                    nameField.setAccessible(true);
                    String name = (String) nameField.get(dataPack);
                    dataPacks.add(name);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                ConsoleLoger.error(e.getMessage());
            }
        }

        return dataPacks;
    }
}

package com.wenkrang.boatfly.DataSystem;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class ConfigYaml {
    private static FileConfiguration config;
    public static void load() {
        if (!new File(MainData.plugin.getDataFolder(), "config.yml").exists()) {
            MainData.plugin.saveDefaultConfig();
        }
        MainData.plugin.reloadConfig();
        config = MainData.plugin.getConfig();
    }
    public static String read(String key) {
        return config.getString(key);
    }
    public static int readInt(String key) {
        return config.getInt(key);
    }
    public static boolean readBool(String key) {
        return config.getBoolean(key);
    }
    public static void write(String key, Object value) {
        config.set(key, value);
        MainData.plugin.saveConfig();
    }
}

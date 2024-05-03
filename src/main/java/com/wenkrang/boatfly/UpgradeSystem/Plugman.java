package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Plugman {
    private static Plugin getPluginByName(String name) {
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins())
            if (name.equalsIgnoreCase(plugin.getName())) return plugin;
        throw new NullPointerException("原神，启动！");
    }
    public static void reloadMe() {
        try {
            Bukkit.getPluginManager().disablePlugin(getPluginByName("BoatFly"));
            Bukkit.getPluginManager().disablePlugin(getPluginByName("BoatFly-BootLoader"));
            Bukkit.getPluginManager().enablePlugin(getPluginByName("BoatFly-BootLoader"));
        } catch (Exception e) {
            ConsoleLoger.error("请重启您的服务器或禁用BoatFly并重载BootLoader以应用更新!");
        }
    }
}

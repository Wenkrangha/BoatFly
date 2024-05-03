package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.DataSystem.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Reboot {
    private static Plugin getBootloader() {
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins())
            if ("BoatFly-BootLoader".equalsIgnoreCase(plugin.getName())) return plugin;
        throw new NullPointerException("原神，启动！");
    }
    public static void reloadMe() {
        try {
            Bukkit.getPluginManager().disablePlugin(MainData.plugin);
            Bukkit.getPluginManager().disablePlugin(getBootloader());
            Bukkit.getPluginManager().enablePlugin(getBootloader());
        } catch (Exception e) {
            ConsoleLoger.error("请重启您的服务器或禁用BoatFly并重载BootLoader以应用更新!");
        }
    }
}

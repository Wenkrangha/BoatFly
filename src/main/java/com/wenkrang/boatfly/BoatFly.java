package com.wenkrang.boatfly;

import com.wenkrang.boatfly.DataSystem.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;

import com.wenkrang.boatfly.lib.PlugmanX.BukkitCommandWrap;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;


public final class BoatFly extends JavaPlugin {

    private static BoatFly instance = null;

    public static BoatFly getInstance() {
        return BoatFly.instance;
    }

    private List<String> ignoredPlugins = null;

    public List<String> getIgnoredPlugins() {
        return this.ignoredPlugins;
    }
    @Override
    public void onEnable() {
        MainData.plugin = getPlugin(BoatFly.class);
        MainData.PluginFile = getFile();
        // Plugin startup logic
        init.boot();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
        ConsoleLoger.info("正在关闭 BoatFly ...");
    }

    public BukkitCommandWrap getBukkitCommandWrap() {
        return new BukkitCommandWrap();
    }
}

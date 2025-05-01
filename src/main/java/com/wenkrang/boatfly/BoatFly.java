package com.wenkrang.boatfly;

import com.wenkrang.boatfly.DataSystem.MainData;
import com.wenkrang.boatfly.lib.ConsoleLogger;
import com.wenkrang.boatfly.lib.VersionChecker;

import org.bukkit.plugin.java.JavaPlugin;


public final class BoatFly extends JavaPlugin {


    @Override
    public void onEnable() {
        if (VersionChecker.isVersionBelow("1.13")) {
            ConsoleLogger.error("仅支持1.13+版本运行！");
            onDisable();
        } else {
            MainData.plugin = getPlugin(BoatFly.class);
            MainData.PluginFile = getFile();
            // Plugin startup logic
            init.boot();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
        ConsoleLogger.info("正在关闭 BoatFly ...");
    }


}

package com.wenkrang.boatfly;

import com.wenkrang.boatfly.DataSystem.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.plugin.java.JavaPlugin;


public final class BoatFly extends JavaPlugin {

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
}

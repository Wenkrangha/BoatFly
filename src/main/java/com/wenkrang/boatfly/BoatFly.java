package com.wenkrang.boatfly;

import com.wenkrang.boatfly.DataSystem.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.VersionChecker;
import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;


public final class BoatFly extends JavaPlugin {


    @Override
    public void onEnable() {
        if (VersionChecker.isVersionBelow("1.13")) {
            ConsoleLoger.error("仅支持1.13+版本运行！");
            onDisable();
        } else {
            MainData.plugin = getPlugin(BoatFly.class);
            MainData.PluginFile = getFile();
            // Plugin startup logic
            init.boot();
            if (VersionChecker.isVersionBelow("1.14") && !Bukkit.getVersion().contains("pre")) {
                ConsoleLoger.info("检测到版本低于1.14，遇到Bug请在https://github.com/Wenkrangha/BoatFly提出！");
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
        ConsoleLoger.info("正在关闭 BoatFly ...");
    }


}

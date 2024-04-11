package com.wenkrang.boatfly;

import com.wenkrang.boatfly.BootLoader.BoatFlyBoot;
import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.Loader.LoadCommand;
import com.wenkrang.boatfly.Loader.LoadEvent;
import com.wenkrang.boatfly.Loader.LoadRecipe;
import com.wenkrang.boatfly.event.GUI.book.PlayerInteract;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.plugin.java.JavaPlugin;


public final class BoatFly extends JavaPlugin {

    @Override
    public void onEnable() {
        MainData.PluginName = getName();
        MainData.plugin = getPlugin(BoatFly.class);
        MainData.PluginFile = getFile();
        // Plugin startup logic
        BoatFlyBoot.boot();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
        ConsoleLoger.info("正在关闭 BoatFly ...");
    }
}

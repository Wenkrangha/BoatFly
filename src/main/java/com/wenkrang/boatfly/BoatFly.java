package com.wenkrang.boatfly;

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
        // Plugin startup logic
        //启动插件,显示启动信息
        getServer().getConsoleSender().sendMessage("    ____              __  ________     ");
        getServer().getConsoleSender().sendMessage("   / __ )____  ____ _/ /_/ ____/ /_  __");
        getServer().getConsoleSender().sendMessage("  / __  / __ \\/ __ `/ __/ /_  / / / / /");
        getServer().getConsoleSender().sendMessage(" / /_/ / /_/ / /_/ / /_/ __/ / / /_/ / ");
        getServer().getConsoleSender().sendMessage("/_____/\\____/\\__,_/\\__/_/   /_/\\__, /  ");
        getServer().getConsoleSender().sendMessage("                              /____/   ");
        try{
            //这里将启动分为3个部分，1.加载指令 2.加载事件 3.加载合成
            LoadCommand.run();
            LoadEvent.run();
            LoadRecipe.run();
            //检测服务器版本，动态修补兼容问题
            if (PlayerInteract.isBelow1_20_4()) {
                //提醒腐竹更新服务器
                ConsoleLoger.info("您的服务器版本低于1.20.4,部分功能可能无法正常使用");
            }
            //加载完成
            getServer().getConsoleSender().sendMessage("§9§l[*] §r加载完毕,当前版本 : 1.5.3a");
        } catch (Exception e) {}
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
        ConsoleLoger.info("正在关闭 BoatFly ...");
    }
}

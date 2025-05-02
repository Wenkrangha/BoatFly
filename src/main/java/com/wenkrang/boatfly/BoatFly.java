package com.wenkrang.boatfly;

import com.wenkrang.boatfly.data.MainData;
import com.wenkrang.boatfly.loader.LoadCommand;
import com.wenkrang.boatfly.loader.LoadEvent;
import com.wenkrang.boatfly.loader.LoadMaterials;
import com.wenkrang.boatfly.loader.LoadRecipe;
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
            //启动插件,显示启动信息
            getServer().getConsoleSender().sendMessage("    ____              __  ________     ");
            getServer().getConsoleSender().sendMessage("   / __ )____  ____ _/ /_/ ____/ /_  __");
            getServer().getConsoleSender().sendMessage("  / __  / __ \\/ __ `/ __/ /_  / / / / /");
            getServer().getConsoleSender().sendMessage(" / /_/ / /_/ / /_/ / /_/ __/ / / /_/ / ");
            getServer().getConsoleSender().sendMessage("/_____/\\____/\\__,_/\\__/_/   /_/\\__, /  ");
            getServer().getConsoleSender().sendMessage("                              /____/   ");
            try {
                //这里将启动分为4个部分，1.加载指令 2.加载事件 3.加载合成 4.加载前置
                //1.加载指令
                LoadCommand.run();
                //2.加载事件
                LoadEvent.run();
                //3.加载合成
                LoadMaterials.run();
                LoadRecipe.run();
                ConsoleLogger.info("当前服务器版本：" + VersionChecker.getVersion());
                //检测服务器版本，动态修补兼容问题
                if (!VersionChecker.isFullySupported()) {
                    ConsoleLogger.warn("BoatFly未完整支持此版本服务端。");
                    ConsoleLogger.warn("遇到Bug请在https://github.com/Wenkrangha/BoatFly提出！");
                }
                if (VersionChecker.isVersionBelow("1.20.4")) {
                    //提醒腐竹更新服务器
                    ConsoleLogger.warn("建议升级至1.20.4或以上版本！");
                }
                //加载完成
                getServer().getConsoleSender().sendMessage("§9§l[*] §r加载完毕,当前版本 : " + MainData.PluginName);
            } catch (Exception e) {
                ConsoleLogger.error(e);
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
        ConsoleLogger.info("正在关闭 BoatFly ...");
    }


}

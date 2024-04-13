package com.wenkrang.boatfly;

import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.Loader.LoadCommand;
import com.wenkrang.boatfly.Loader.LoadEvent;
import com.wenkrang.boatfly.Loader.LoadRecipe;
import com.wenkrang.boatfly.event.GUI.book.PlayerInteract;
import com.wenkrang.boatfly.item.Materials;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;

import static org.bukkit.Bukkit.getServer;

public class init {
    //初始化插件
    public static void init() throws IOException {
        //复制插件至版本文件夹
        new File("./plugins/BoatFly/version").mkdirs();
        if (true) {
            ClassLoader classLoader = BoatFly.class.getClassLoader();
            URL resource = classLoader.getResource("BoatFly-" + MainData.PluginName + ".jar");
            InputStream inputStream = resource.openStream();
            Files.copy(inputStream, new File("./plugins/BoatFly/version/BoatFly-" + MainData.PluginName + ".jar").toPath());
            inputStream.close();
        }
        //储存加载器应加载的插件的版本号
        if (true) {
            File file = new File("./plugins/BoatFly/SetupNumber");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(MainData.Number));
            bufferedWriter.close();
            fileWriter.close();
        }
        //储存加载器应加载的插件的名字
        if (true) {
            File file = new File("./plugins/BoatFly/SetupName");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("BoatFly-" + MainData.PluginName + ".jar");
            bufferedWriter.close();
            fileWriter.close();
        }
        //储存加载器的路径
        if (true) {
            File file = new File("./plugins/BoatFly/Bootloader");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(MainData.PluginFile.toPath().toString());
            bufferedWriter.close();
            fileWriter.close();
        }
    }
    public static void boot() {

        //启动插件,显示启动信息
        getServer().getConsoleSender().sendMessage("    ____              __  ________     ");
        getServer().getConsoleSender().sendMessage("   / __ )____  ____ _/ /_/ ____/ /_  __");
        getServer().getConsoleSender().sendMessage("  / __  / __ \\/ __ `/ __/ /_  / / / / /");
        getServer().getConsoleSender().sendMessage(" / /_/ / /_/ / /_/ / /_/ __/ / / /_/ / ");
        getServer().getConsoleSender().sendMessage("/_____/\\____/\\__,_/\\__/_/   /_/\\__, /  ");
        getServer().getConsoleSender().sendMessage("                              /____/   ");
        try {
            //这里将启动分为3个部分，1.加载指令 2.加载事件 3.加载合成
            //1.加载指令
            LoadCommand.run();
            //2.加载事件
            LoadEvent.run();
            //3.加载合成
            Materials.init();
            LoadRecipe.run();
            //检测服务器版本，动态修补兼容问题
            if (PlayerInteract.isBelow1_20_4()) {
                //提醒腐竹更新服务器
                ConsoleLoger.info("您的服务器版本低于1.20.4,部分功能可能无法正常使用");
            }
            //加载完成
            getServer().getConsoleSender().sendMessage("§9§l[*] §r加载完毕,当前版本 : " + MainData.PluginName);
        } catch (Exception e) {}
    }
    public static void upgrade() throws IOException {
        //和init差不多
        new File("./plugins/BoatFly/SetupNumber").delete();
        new File("./plugins/BoatFly/SetupName").delete();
        new File("./plugins/BoatFly/Bootloader").delete();

        if (true) {
            ClassLoader classLoader = BoatFly.class.getClassLoader();
            URL resource = classLoader.getResource("BoatFly-" + MainData.PluginName + ".jar");
            InputStream inputStream = resource.openStream();
            Files.copy(inputStream, new File("./plugins/BoatFly/version/BoatFly-" + MainData.PluginName + ".jar").toPath());
            inputStream.close();
        }

        if (true) {
            File file = new File("./plugins/BoatFly/SetupNumber");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(MainData.Number);
            bufferedWriter.close();
            fileWriter.close();
        }

        if (true) {
            File file = new File("./plugins/BoatFly/SetupName");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("BoatFly-" + MainData.PluginName + ".jar");
            bufferedWriter.close();
            fileWriter.close();
        }

        if (true) {
            File file = new File("./plugins/BoatFly/Bootloader");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(MainData.PluginFile.toPath().toString());
            bufferedWriter.close();
            fileWriter.close();
        }
    }
}

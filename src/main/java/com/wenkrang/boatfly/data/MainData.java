package com.wenkrang.boatfly.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public class MainData {
    //这里存放各种需要用到的公共变量

    //这个是用来通知插件的各个部分卸载的变量
    //当该变量为true,所有的BoatFly线程将关闭
    public static boolean IsShutDown = false;

    //该变量用于储存插件的名字
    public static String PluginName = "1.5.8";
    //该变量用于储存该插件对象
    public static JavaPlugin plugin;
    //该变量用于储存该插件文件对象
    public static File PluginFile;
    //该变量用于储存版本号
    public static int Number = 12;
    //该变量用于储存所有BoatFly添加的配方的Key
    public static ArrayList<NamespacedKey> keys = new ArrayList<>();

    // 存储单例gson，避免重复创建实例
    public static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
}

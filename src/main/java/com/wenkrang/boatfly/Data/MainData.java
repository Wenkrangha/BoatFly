package com.wenkrang.boatfly.Data;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;

public class MainData {
    //这里存放各种需要用到的公共变量

    //这个是用来通知插件的各个部分卸载的变量
    //当该变量为true,所有的BoatFly线程将关闭
    public static boolean IsShutDown = false;

    //该变量用于储存插件的名字
    public static String PluginName = "1.5.4";

    public static Plugin plugin = null;

    public static File PluginFile = null;

    public static int Number = 2;

    public static ArrayList<NamespacedKey> keys = new ArrayList<>();
}

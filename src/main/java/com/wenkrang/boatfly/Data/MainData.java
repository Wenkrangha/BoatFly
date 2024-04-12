package com.wenkrang.boatfly.Data;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class MainData {
    //这里存放各种需要用到的公共变量

    //这个是用来通知插件的各个部分卸载的变量
    //当该变量为true,所有的BoatFly线程将关闭
    public static boolean IsShutDown = false;

    //该变量用于储存插件的名字
    public static String PluginName = "1.5.3a";

    public static Plugin plugin = null;

    public static File PluginFile = null;

    public static String Number = "1";
}

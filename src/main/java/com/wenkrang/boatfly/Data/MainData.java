package com.wenkrang.boatfly.Data;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.plugin.Plugin;

public class MainData {
    //这里存放各种需要用到的公共变量

    //这个是用来通知插件的各个部分卸载的变量
    //当该变量为true,所有的BoatFly线程将关闭
    public static boolean IsShutDown = false;
}

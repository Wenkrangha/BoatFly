package com.wenkrang.boatfly.lib;

import static org.bukkit.Bukkit.getServer;

public class ConsoleLoger {
    //辅助插件日志
    public static void info(String msg) {getServer().getConsoleSender().sendMessage("§9[*]§r "+ msg);}
    public static void error(String msg) {getServer().getConsoleSender().sendMessage("§c[-]§r "+ msg);}
    public static void warn(String msg) {getServer().getConsoleSender().sendMessage("§e[!]§r "+ msg);}
}

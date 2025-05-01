package com.wenkrang.boatfly.loader;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.command.BfTabComplete;
import com.wenkrang.boatfly.command.bf;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class LoadCommand {
    public static void run() {
        // 注入命令
        getServer().getConsoleSender().sendMessage("§9§l[*] §r正在注入命令...");
        Objects.requireNonNull(BoatFly.getPlugin(BoatFly.class).getCommand("bf")).setExecutor(new bf());
        Objects.requireNonNull(BoatFly.getPlugin(BoatFly.class).getCommand("bf")).setTabCompleter(new BfTabComplete());
    }
}

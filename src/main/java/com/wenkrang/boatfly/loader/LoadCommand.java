package com.wenkrang.boatfly.loader;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.command.BfCommand;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class LoadCommand {
    public static void run() {
        // 注入命令
        getServer().getConsoleSender().sendMessage("§9§l[*] §r正在注入命令...");
        final var command = new BfCommand();
        Objects.requireNonNull(BoatFly.getPlugin(BoatFly.class).getCommand("bf")).setExecutor(command);
        Objects.requireNonNull(BoatFly.getPlugin(BoatFly.class).getCommand("bf")).setTabCompleter(command);
    }
}

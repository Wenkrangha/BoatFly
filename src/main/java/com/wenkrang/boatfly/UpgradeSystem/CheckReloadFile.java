package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;

import static org.bukkit.Bukkit.getServer;

public class CheckReloadFile implements Listener {
    @EventHandler
    public static void onCall(ServerLoadEvent event) {
        new BukkitRunnable(){
            @Override
            public void run() {
                try {
                    UpgradeCentre.update();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }.runTaskTimer(BoatFly.getPlugin(BoatFly.class), 0, 600);
        new BukkitRunnable(){
            @Override
            public void run() {
                if (new File("./plugins/BoatFly/upgrade/reload").exists()) {
                    new File("./plugins/BoatFly/upgrade/reload").delete();
                    File file = new File("./plugins/BoatFly/SetupName");
                    FileReader fr = null;
                    try {
                        fr = new FileReader(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                    BufferedReader br = new BufferedReader(fr);
                    String s = null;
                    try {
                        s = br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }

                    Plugin plugin = null;
                    try {
                        plugin = getServer().getPluginManager().loadPlugin(new File("./plugins/BoatFly/version/" + s));
                    } catch (InvalidPluginException | InvalidDescriptionException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }

                    ConsoleLoger.info(plugin.toString());
                    getServer().getPluginManager().enablePlugin(plugin);
                    getServer().getPluginManager().registerEvents(new CheckReloadFile(), BoatFly.getPlugin(BoatFly.class));
                }
            }
        }.runTaskTimer(BoatFly.getPlugin(BoatFly.class), 0, 40);
    }
}

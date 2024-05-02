package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.DataSystem.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.UnsafeDownloader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static com.wenkrang.boatfly.UpgradeSystem.UpgradeCentre.upgrade;

public class UpgradeCheck implements Listener {
    @EventHandler
    public static void OnCall(ServerLoadEvent event) {
        new BukkitRunnable() {

            @Override
            public void run() {
                try {
                    Source.getSource();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }.runTaskLaterAsynchronously(BoatFly.getPlugin(BoatFly.class), 0);
        new BukkitRunnable() {

            @Override
            public void run() {
                try {
                    new File("./plugins/BoatFly/upgrade/").mkdir();
                    new File("./plugins/BoatFly/upgrade/Name").delete();
                    new File("./plugins/BoatFly/upgrade/Number").delete();
                    boolean Checked = false;
                    Source.getSource();

                    UnsafeDownloader.downloadFile(Source.SourceURL + "upgrade/Name", "plugins/BoatFly/upgrade/Name");
                    UnsafeDownloader.downloadFile(Source.SourceURL + "upgrade/Number", "plugins/BoatFly/upgrade/Number");


                        if (true) {
                            FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Number");
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            String Number = bufferedReader.readLine();
                            if (Integer.parseInt(Number) > MainData.Number) {
                                ConsoleLoger.info("发现新版本!即将安装");
                                upgrade();
                            } else {
                                ConsoleLoger.info("无可用更新");
                            }
                        }

                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.runTaskTimerAsynchronously(BoatFly.getPlugin(BoatFly.class), 5000, 6000);
    }
}

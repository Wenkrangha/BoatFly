package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.UnsafeDownloader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.InetAddress;

import static com.wenkrang.boatfly.UpgradeSystem.UpgradeCentre.upgrade;

public class UpgradeCheck implements Listener {
    @EventHandler
    public static void OnCall(ServerLoadEvent event) {
        new BukkitRunnable() {

            @Override
            public void run() {
                try {
                    new File("./plugins/BoatFly/upgrade/").mkdir();
                    new File("./plugins/BoatFly/upgrade/Name").delete();
                    new File("./plugins/BoatFly/upgrade/Number").delete();
                    InetAddress TEST = InetAddress.getByName("www.bing.com");
                    if (TEST.isReachable(5000)) {
                        InetAddress GITHUB = InetAddress.getByName("github.com");
                        InetAddress GITEE = InetAddress.getByName("gitee.com");

                        boolean Checked = false;

                        if (GITEE.isReachable(5000)) {

                            //https://gitee.com/wenkrang/BoatFly/raw/master/upgrade/Name
                            UnsafeDownloader.downloadFile("https://gitee.com/wenkrang/BoatFly/raw/master/upgrade/Name","plugins/BoatFly/upgrade/Name");
                            UnsafeDownloader.downloadFile("https://gitee.com/wenkrang/BoatFly/raw/master/upgrade/Number","plugins/BoatFly/upgrade/Number");

                            Checked = true;
                        } else if (GITHUB.isReachable(5000)) {

                            UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/Name","plugins/BoatFly/upgrade/Name");
                            UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/Number","plugins/BoatFly/upgrade/Number");
                            Checked = true;
                        }
                        if (Checked) {
                            if (true) {
                                FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Number");
                                BufferedReader bufferedReader = new BufferedReader(fileReader);
                                String Number = bufferedReader.readLine();
                                if (Integer.parseInt(Number) > MainData.Number) {
                                    ConsoleLoger.info("发现新版本!即将安装");
                                    upgrade();
                                }
                            }
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.runTaskTimerAsynchronously(BoatFly.getPlugin(BoatFly.class), 0, 6000);
    }
}

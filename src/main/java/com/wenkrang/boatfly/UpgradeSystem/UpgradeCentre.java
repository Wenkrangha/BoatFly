package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.Download;
import com.wenkrang.boatfly.lib.UnsafeDownloader;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.FileUtil;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.nio.file.Files;

import static com.wenkrang.boatfly.Data.MainData.keys;
import static org.bukkit.Bukkit.getServer;

public class UpgradeCentre {
    public static void upgrade() throws Exception {
        new BukkitRunnable() {

            @Override
            public void run() {
                try {
                    if (true) {
                        FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Name");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String Name = bufferedReader.readLine();
                        UnsafeDownloader.downloadFile(Source.SourceURL + "upgrade/" + Name, "plugins/BoatFly/version/" + Name);
                        ConsoleLoger.info("jar下载完成");
                    }


                    String Name = null;
                    String Number = null;
                    if (true) {
                        FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Name");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        Name = bufferedReader.readLine();
                        ConsoleLoger.info("下载完成：" + Name);
                        fileReader.close();
                        bufferedReader.close();
                    }

                    if (true) {
                        FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Number");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        Number = bufferedReader.readLine();
                        fileReader.close();
                        bufferedReader.close();
                    }

                    new File("./plugins/BoatFly/SetupNumber").delete();
                    new File("./plugins/BoatFly/SetupName").delete();

                    if (true) {
                        File file = new File("./plugins/BoatFly/SetupNumber");
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(Number);
                        MainData.Number = Integer.parseInt(Number);
                        bufferedWriter.close();
                        fileWriter.close();
                    }

                    if (true) {
                        File file = new File("./plugins/BoatFly/SetupName");
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(Name);
                        bufferedWriter.close();
                        fileWriter.close();
                    }

                    ConsoleLoger.info("重启您的服务器或禁用BoatFly并重载BootLoader以应用更新!");
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.runTaskAsynchronously(BoatFly.getPlugin(BoatFly.class));

    }

    public static void update() throws Exception {
        new BukkitRunnable() {

            @Override
            public void run() {
                try {
                    ConsoleLoger.info("初始化更新程序");
                    new File("./plugins/BoatFly/upgrade/").mkdir();
                    new File("./plugins/BoatFly/upgrade/Name").delete();
                    new File("./plugins/BoatFly/upgrade/Number").delete();
                    boolean Checked = false;
                    ConsoleLoger.info("正在更新源地址");
                    Source.getSource();
                    ConsoleLoger.info("正在获取头文件");
                    UnsafeDownloader.downloadFile(Source.SourceURL + "upgrade/Name", "plugins/BoatFly/upgrade/Name");
                    UnsafeDownloader.downloadFile(Source.SourceURL + "upgrade/Number", "plugins/BoatFly/upgrade/Number");

                    Checked = true;

                    if (Checked) {
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
                    }

                }catch (Exception e) {

                }

            }
        }.runTaskAsynchronously(BoatFly.getPlugin(BoatFly.class));

    }
}

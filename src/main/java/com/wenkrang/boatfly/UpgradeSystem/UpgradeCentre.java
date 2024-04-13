package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.Download;
import com.wenkrang.boatfly.lib.UnsafeDownloader;
import org.apache.commons.io.FileUtils;
import org.bukkit.util.FileUtil;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.nio.file.Files;

import static org.bukkit.Bukkit.getServer;

public class UpgradeCentre {
    public static void upgrade() throws Exception {
        InetAddress GITHUB = InetAddress.getByName("github.com");
        InetAddress GITEE = InetAddress.getByName("gitee.com");
        if (GITHUB.isReachable(5000)) {
            ConsoleLoger.info("Github");
            if (true) {
                FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Name");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String Name = bufferedReader.readLine();
                UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/" + Name,"plugins/BoatFly/version/" + Name);
                ConsoleLoger.info("GITHUB HELP");
            }
        } else if (GITEE.isReachable(5000)) {
            ConsoleLoger.info("Gitee");
            if (true) {
                FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Name");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String Name = bufferedReader.readLine();
                UnsafeDownloader.downloadFile("https://gitee.com/wenkrang/BoatFly/raw/master/upgrade/" + Name,"plugins/BoatFly/version/" + Name);
                ConsoleLoger.info("GITEE HELP");
            }
        }

        String Name = null;
        String Number = null;
        if (true) {
            FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Name");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Name = bufferedReader.readLine();
        }

        if (true) {
            FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Number");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Name = bufferedReader.readLine();
        }

        new File("./plugins/BoatFly/SetupNumber").delete();
        new File("./plugins/BoatFly/SetupName").delete();

        if (true) {
            File file = new File("./plugins/BoatFly/SetupNumber");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Number);
            bufferedWriter.close();
            fileWriter.close();
        }

        if (true) {
            File file = new File("./plugins/BoatFly/SetupName");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("BoatFly-" + Name + ".jar");
            bufferedWriter.close();
            fileWriter.close();
        }

        new File ("./plugins/BoatFly/upgrade/reload").createNewFile();
        MainData.plugin.onDisable();
        getServer().getPluginManager().disablePlugin(MainData.plugin);
    }

    public static void update() throws Exception {
        new File("./plugins/BoatFly/upgrade/").mkdir();
        InetAddress TEST = InetAddress.getByName("www.bing.com");
        if (TEST.isReachable(5000)) {
            InetAddress GITHUB = InetAddress.getByName("github.com");
            InetAddress GITEE = InetAddress.getByName("gitee.com");

            boolean Checked = false;
            if (GITHUB.isReachable(5000)) {
                ConsoleLoger.info("Github");
                UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/Name","plugins/BoatFly/upgrade/Name");
                UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/Number","plugins/BoatFly/upgrade/Number");
                Checked = true;
            } else if (GITEE.isReachable(5000)) {
                ConsoleLoger.info("Gitee");
//https://gitee.com/wenkrang/BoatFly/raw/master/upgrade/Name
                UnsafeDownloader.downloadFile("https://gitee.com/wenkrang/BoatFly/raw/master/upgrade/Name","plugins/BoatFly/upgrade/Name");
                UnsafeDownloader.downloadFile("https://gitee.com/wenkrang/BoatFly/raw/master/upgrade/Number","plugins/BoatFly/upgrade/Number");

                Checked = true;
            } else {
                ConsoleLoger.error("网络连接失败，请检查网络连接");
            }
            if (Checked) {
                if (true) {
                    FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Number");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String Number = bufferedReader.readLine();
                    if (Integer.parseInt(Number) > MainData.Number) {
                        ConsoleLoger.info("发现新版!");
                        upgrade();
                    }
                }
            }
        } else {
            ConsoleLoger.error("网络连接失败，请检查网络连接");
        }
    }
}

package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.DataSystem.MainData;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.UnsafeDownloader;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;

public class UpgradeCentre {
    public static void upgrade() throws Exception {
        new BukkitRunnable() {

            @Override
            public void run() {
                try {
                    if (true) {
                        ConsoleLoger.info("读取将下载的更新文件名字");
                        FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Name");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String Name = bufferedReader.readLine();
                        ConsoleLoger.info("Name : " + Name);
                        ConsoleLoger.info("即将下载jar文件：" + Source.SourceURL + "upgrade/" + Name);
                        UnsafeDownloader.downloadFile(Source.SourceURL + "upgrade/" + Name, "plugins/BoatFly/version/" + Name);
                        ConsoleLoger.info("jar下载完成,准备更新");
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
                    ConsoleLoger.info("正在替换文件中，请勿关闭服务器.");
                    if (true) {
                        FileReader fileReader = new FileReader("plugins/BoatFly/upgrade/Number");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        Number = bufferedReader.readLine();
                        fileReader.close();
                        bufferedReader.close();
                    }
                    System.out.print(".");
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
                    System.out.print(".");
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
                    ConsoleLoger.info("正在打开更新文件夹：./plugins/BoatFly/upgrade/");
                    new File("./plugins/BoatFly/upgrade/").mkdir();
                    ConsoleLoger.info("正在删除旧更新文件");
                    new File("./plugins/BoatFly/upgrade/Name").delete();
                    new File("./plugins/BoatFly/upgrade/Number").delete();
                    boolean Checked = false;
                    ConsoleLoger.info("正在从服务器获取更新源地址");
                    Source.getSource(true);
                    ConsoleLoger.info("正在获取更新头文件：upgrade/Name and upgrade/Number");
                    ConsoleLoger.info(Source.SourceURL + "upgrade/Name");
                    UnsafeDownloader.downloadFile(Source.SourceURL + "upgrade/Name", "plugins/BoatFly/upgrade/Name");
                    UnsafeDownloader.downloadFile(Source.SourceURL + "upgrade/Number", "plugins/BoatFly/upgrade/Number");
                    ConsoleLoger.info("预更新文件下载完成,准备检查更新");
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
                    e.printStackTrace();
                }

            }
        }.runTaskAsynchronously(BoatFly.getPlugin(BoatFly.class));

    }
}

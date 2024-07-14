package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.DataSystem.ConfigYaml;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.UnsafeDownloader;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;


public class Source {
    public volatile static String SourceURL = null; // 使用volatile修饰以增强线程安全
    public static boolean DevMode = false;

    public static String getSource(Boolean Log) {
        String tempSourceURL = null; // 使用局部变量进行操作，最后再赋值给静态变量

        try {
            UnsafeDownloader.downloadFile("https://gitee.com/boat-fly-development-team/BoatFly/raw/master/upgrade/Source", "plugins/BoatFly/Source");
            BufferedReader bufferedReader = getBufferedReader("plugins/BoatFly/Source");
            String[] Sources = bufferedReader.readLine().split("\\^");
            bufferedReader.close();

            if (Log) {
                ConsoleLoger.info("源文件下载完成");
            }

            UnsafeDownloader.downloadFile("https://gitee.com/boat-fly-development-team/BoatFly/raw/master/upgrade/SourceDomain", "plugins/BoatFly/SourceDomain");
            BufferedReader domainBufferedReader = getBufferedReader("plugins/BoatFly/SourceDomain");
            String[] DomainSources = domainBufferedReader.readLine().split("\\^");
            ArrayList<Integer> SpeedList = new ArrayList<>();
            domainBufferedReader.close();

            if (Log) {
                ConsoleLoger.info("源域名文件下载完成");
            }

            for (int i = 0; i < DomainSources.length; i++) {
                String s = DomainSources[i];
                try {
                    InetAddress inetAddress = InetAddress.getByName(s);
                    if (isReachable(inetAddress)) {
                        if (ConfigYaml.read("update-source").startsWith("http")) {
                            tempSourceURL = ConfigYaml.read("update-source");
                        } else {
                            tempSourceURL = Sources[i];
                            SpeedList.add(getPing(inetAddress));
                            if (Log) {
                                ConsoleLoger.info("测速完成");
                                ConsoleLoger.info("Source : " + tempSourceURL);
                            }
                        }
                        break;
                    }
                } catch (UnknownHostException e) {
                    ConsoleLoger.info("域名解析失败: " + s);
                }
            }
            if (!SpeedList.isEmpty()) {
                tempSourceURL = Sources[SpeedList.indexOf(Collections.min(SpeedList))];
            }
        } catch (Exception e) {
            ConsoleLoger.error(e.getMessage());
        }

        SourceURL = tempSourceURL;
        if (DevMode) {
            SourceURL = "https://gitee.com/boat-fly-development-team/BoatFly/raw/develop/";
        }
        return SourceURL;
    }

    private static boolean isReachable(InetAddress inetAddress) throws IOException {
        if (System.getProperty("os.name").startsWith("Windows")) {
            return inetAddress.isReachable(500);
        } else {
            Process pingProcess = Runtime.getRuntime().exec("ping -c 4 " + inetAddress);
            return new BufferedReader(
                    new InputStreamReader(
                            pingProcess.getInputStream())
            ).lines().anyMatch(line -> line.contains("ttl"));
        }
    }
    private static int getPing(InetAddress address) {
        try {
            Process p = Runtime.getRuntime().exec("ping -c 1 " + address);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("time=")) {
                    String timeStr = line.split("time=")[1].split(" ")[0];
                    return Integer.parseInt(timeStr);
                }
            }
        } catch (IOException e) {
            ConsoleLoger.error(e.getMessage());
        }
        return -1; // 返回-1表示未能成功获取延迟
    }
    private static BufferedReader getBufferedReader(String filePath) throws IOException {
        return new BufferedReader(new FileReader(filePath));
    }
}
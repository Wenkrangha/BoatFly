package com.wenkrang.boatfly.UpgradeSystem;


import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.UnsafeDownloader;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;


public class Source {
    public volatile static String SourceURL = "https://gitee.com/boat-fly-development-team/BoatFly/raw/master/"; // 使用volatile修饰以增强线程安全
    public static boolean DevMode = false;

    public static String getSource(Boolean Log) {
        return "https://gitee.com/boat-fly-development-team/BoatFly/raw/master/";
    }

    public static boolean isReachable(InetAddress inetAddress) throws IOException {
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
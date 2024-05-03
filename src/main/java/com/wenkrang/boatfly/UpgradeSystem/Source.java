package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.lib.UnsafeDownloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.stream.Collectors;


public class Source {
    public static String SourceURL = null;
    public static String getSource() throws Exception {
        UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/Source","plugins/BoatFly/Source");
        FileReader fileReader = new FileReader(new File("plugins/BoatFly/Source"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] Sources = bufferedReader.readLine().split("^");

        for (String s : Sources) {
            InetAddress inetAddress = InetAddress.getByName(s);
            if (System.getProperty("os.name").startsWith("Windows")) {
                if (inetAddress.isReachable(500)) {
                    SourceURL = s;
                }
            } else {
                Process ping = Runtime.getRuntime().exec("ping -c 4" + inetAddress);
                if (new BufferedReader(
                        new InputStreamReader(
                                ping.getInputStream())).
                        lines().collect(Collectors.joining("\n"))
                        .contains("ttl")) {
                    SourceURL = s;
                }
            }

        }
        return null;
    }
}

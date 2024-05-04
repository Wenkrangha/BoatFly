package com.wenkrang.boatfly.UpgradeSystem;

import com.google.common.net.InetAddresses;
import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.UnsafeDownloader;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;


public class Source {
    public static String SourceURL = null;
    public static String getSource(Boolean Log) throws Exception {
        UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/Source","plugins/BoatFly/Source");
        FileReader fileReader = new FileReader(new File("plugins/BoatFly/Source"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] Sources = bufferedReader.readLine().split("\\^");
        bufferedReader.close();
        fileReader.close();
        if (Log) {
            ConsoleLoger.info("源文件下载完成");
        }
        UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/SourceDomain","plugins/BoatFly/SourceDomain");
        FileReader fr = new FileReader(new File("plugins/BoatFly/SourceDomain"));
        BufferedReader br = new BufferedReader(fr);

        String[] DomainSources = br.readLine().split("\\^");
        br.close();
        fr.close();
        if (Log) {
            ConsoleLoger.info("源域名文件下载完成");
        }
        for (int i = 0;i < DomainSources.length;i++) {
            String s = DomainSources[i];

            InetAddress inetAddress = InetAddress.getByName(s);
            //就这个地方
            //你看看怎么改改
            if (System.getProperty("os.name").startsWith("Windows")) {
                if (inetAddress.isReachable(500)) {
                    SourceURL = Sources[i];
                    if (Log) {
                        ConsoleLoger.info("测速完成");
                        ConsoleLoger.info("Source : " + SourceURL);
                    }
                }
            } else {
                Process ping = Runtime.getRuntime().exec("ping -c 4" + inetAddress);
                if (new BufferedReader(
                        new InputStreamReader(
                                ping.getInputStream())).
                        lines().collect(Collectors.joining("\n"))
                        .contains("ttl")) {
                    SourceURL = Sources[i];
                    if (Log) {
                        ConsoleLoger.info("测速完成");
                        ConsoleLoger.info("Source : " + SourceURL);
                    }
                }
            }
        }
        return null;
    }
}

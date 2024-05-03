package com.wenkrang.boatfly.UpgradeSystem;

import com.google.common.net.InetAddresses;
import com.wenkrang.boatfly.lib.UnsafeDownloader;

import java.io.*;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;


public class Source {
    public static String SourceURL = null;
    public static String getSource() throws Exception {
        UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/Source","plugins/BoatFly/Source");
        FileReader fileReader = new FileReader(new File("plugins/BoatFly/Source"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] Sources = bufferedReader.readLine().split("\\^");
        bufferedReader.close();
        fileReader.close();

        UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/SourceDomain","plugins/BoatFly/SourceDomain");
        fileReader = new FileReader(new File("plugins/BoatFly/DomainSource"));
        bufferedReader = new BufferedReader(fileReader);

        String[] DomainSources = bufferedReader.readLine().split("\\^");
        bufferedReader.close();
        fileReader.close();
        for (int i = 0;i < DomainSources.length;i++) {
            String s = DomainSources[i];

            InetAddress inetAddress = InetAddress.getByName(s);
            //就这个地方
            //你看看怎么改改
            if (System.getProperty("os.name").startsWith("Windows")) {
                if (inetAddress.isReachable(500)) {
                    SourceURL = Sources[i];
                }
            } else {
                Process ping = Runtime.getRuntime().exec("ping -c 4" + inetAddress);
                if (new BufferedReader(
                        new InputStreamReader(
                                ping.getInputStream())).
                        lines().collect(Collectors.joining("\n"))
                        .contains("ttl")) {
                    SourceURL = Sources[i];
                }
            }
        }
        return null;
    }
}

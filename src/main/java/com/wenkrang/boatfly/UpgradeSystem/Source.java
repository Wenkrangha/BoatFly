package com.wenkrang.boatfly.UpgradeSystem;

import com.google.common.net.InetAddresses;
import com.wenkrang.boatfly.lib.UnsafeDownloader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Objects;



public class Source {
    public static String SourceURL = null;
    public static String getSource() throws Exception {
        UnsafeDownloader.downloadFile("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/Source","plugins/BoatFly/Source");
        FileReader fileReader = new FileReader(new File("plugins/BoatFly/Source"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] Sources = bufferedReader.readLine().split("^");

        for (String s : Sources) {
            InetAddress inetAddress = InetAddress.getByName(s);
            if (inetAddress.isReachable(500)) {
                SourceURL = s;
            }
        }
        return null;
    }
}

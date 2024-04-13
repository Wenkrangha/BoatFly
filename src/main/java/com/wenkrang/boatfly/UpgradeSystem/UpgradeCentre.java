package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.lib.ConsoleLoger;
import com.wenkrang.boatfly.lib.Download;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UpgradeCentre {
    public static void upgrade() {

    }

    public static void update() throws IOException {
        InetAddress TEST = InetAddress.getByName("www.bing.com");
        if (TEST.isReachable(5000)) {
            InetAddress GITHUB = InetAddress.getByName("github.com");
            InetAddress GITEE = InetAddress.getByName("gitee.com");

            if (GITHUB.isReachable(5000)) {
                ConsoleLoger.info("Github");
                Download.downLoadFromUrl("", "BoatFly.jar", "plugins/");
            } else if (GITEE.isReachable(5000)) {
                ConsoleLoger.info("Gitee");

            } else {
                ConsoleLoger.error("网络连接失败，请检查网络连接");
            }
        } else {
            ConsoleLoger.error("网络连接失败，请检查网络连接");
        }
    }
}

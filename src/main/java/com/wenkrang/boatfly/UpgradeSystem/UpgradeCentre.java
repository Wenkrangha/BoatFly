package com.wenkrang.boatfly.UpgradeSystem;

import com.wenkrang.boatfly.lib.Download;

import java.io.File;

public class UpgradeCentre {
    public void upgrade() {
        File file = new File("./plugins/BoatFly/upgrade/lasternumber");
        if (file.exists()) {
            file.delete();
        }
        Download.downLoadFromUrl("https://raw.githubusercontent.com/Wenkrangha/BoatFly/master/upgrade/Lasternumber", "./plugins/BoatFly/Upgrade/","Lasternumber");

    }
}

package com.wenkrang.boatfly.BootLoader.lib;

import java.io.File;

public class CheckProgam {
    public boolean check () {
        //检查文件是否完整
        boolean CheckResult = false;
        //检查是否被激活（是否安装）
        File file = new File("./plugins/BoatFly/Installed");

        if (file.exists()) {
            CheckResult = true;
        }
        return CheckResult;
    }
}

package com.wenkrang.boatfly.lib;

import org.bukkit.Bukkit;

public class VersionChecker {

    /**
     * 检查当前运行的Minecraft服务器版本是否低于指定版本。
     *
     * @param requiredVersion 字符串形式的所需最低版本号，例如 "1.20.1"
     * @return 如果当前版本低于指定版本则返回true，否则返回false
     */
    public static boolean isVersionBelow(String requiredVersion) {
        // 获取当前服务器版本
        String currentVersion = Bukkit.getVersion();
        // 从Bukkit.getVersion()返回的字符串中提取纯净的版本号，假设版本号位于 "CraftBukkit version git-SomeHash (MC: 1.20.1)" 形式的字符串中
        String[] versionParts = currentVersion.split(" ")[4].split("-")[0].split("\\.");

        // 将所需版本号按点分割
        String[] requiredVersionParts = requiredVersion.split("\\.");

        try {
            // 比较版本号的每一个部分
            for (int i = 0; i < Math.max(versionParts.length, requiredVersionParts.length); i++) {
                // 处理位数不足的情况，不足的位视为0
                int currentPart = i < versionParts.length ? Integer.parseInt(versionParts[i]) : 0;
                int requiredPart = i < requiredVersionParts.length ? Integer.parseInt(requiredVersionParts[i]) : 0;

                if (currentPart < requiredPart) {
                    return true; // 当前版本低于所需版本
                } else if (currentPart > requiredPart) {
                    return false; // 当前版本高于或等于所需版本
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid version format", e);
        }

        return false; // 版本相同或高于所需版本
    }
}
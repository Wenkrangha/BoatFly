package com.wenkrang.boatfly.lib;

import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionChecker {

    /**
     * 检查当前运行的Minecraft服务器版本是否低于指定版本。
     *
     * @param requiredVersion 字符串形式的所需最低版本号，例如 "1.20.1"
     * @return 如果当前版本低于指定版本则返回true，否则返回false
     */
    public static boolean isVersionBelow(String requiredVersion) {
        // 返回纯净的服务端版本。
        // 如 服务端版本为1.8.8时，返回188
        // 服务端版本为1.21.5时，返回1215
        // 显然1.8.8应小于1.21.5，188<1215，因此获得的版本号不做处理
        final var serverVersion = Integer.parseInt(getVersion().replace(".", ""));

        // 版本相同或高于所需版本（serverVersion >= requiredVersion）时返回false
        // 否则返回true
        return serverVersion < Integer.parseInt(requiredVersion.replace(".", ""));
    }

    public static String getVersion() {
        String currentVersion = Bukkit.getVersion();
        // 从Bukkit.getVersion()返回的字符串中提取纯净的版本号，假设版本号位于 "CraftBukkit version git-SomeHash (MC: 1.20.1)" 形式的字符串中

        // 定义一个正则表达式来匹配版本号
        Pattern pattern = Pattern.compile("(\\d+)\\.(\\d+)(?:\\.(\\d+))?");

        // 创建一个 matcher 对象
        Matcher matcher = pattern.matcher(currentVersion);

        while (matcher.find()) {
            // 使用 matcher.group() 方法来获取匹配的组
            String group = matcher.group(0);

            return group;
        }
        return currentVersion;
    }

    public static boolean isFullySupported() {
        return !isVersionBelow("1.14")
                && isVersionBelow("1.22")
                && !getVersion().contains("pre");
    }
}
package com.wenkrang.boatfly.loader;

import com.wenkrang.boatfly.data.MainData;
import com.wenkrang.boatfly.lib.ConsoleLogger;
import com.wenkrang.boatfly.upgrade.UpgradeCentre;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class LoadCommand {

    /**
     * 向传入的CommandSender对象发送帮助信息
     *
     * @param sender CommandSender对象，用于发送消息
     */
    public static void help(CommandSender sender) {
        sender.sendMessage("""
                §7[!]  §4飞船 - BoatFly §7正在运行
                 §4| §7help  帮助列表
                 §4| §7getbook  获取配方
                 §4| §7- 创造下，右键配方可以将直接获取物品
                 §4| §7upgrade  全自动更新插件
                 §4| §7作者:Wenkrang
                """);
    }

    public static void run() {
        // 注入命令
        getServer().getConsoleSender().sendMessage("§9§l[*] §r正在注入命令...");
        Objects.requireNonNull(MainData.plugin.getCommand("bf")).setExecutor(
                (sender, command, s, strings) -> {
                    if (strings.length == 0) {
                        help(sender);
                    } else {
                        if (strings[0].equalsIgnoreCase("help")) {
                            help(sender);
                        }
                        if (strings[0].equalsIgnoreCase("getbook")) {
                            if (sender instanceof Player player) {
                                ItemStack itemStack0 = new ItemStack(Material.WRITABLE_BOOK);
                                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                                itemMeta0.setDisplayName("§9§lBoatFly§r-飞船配方");
                                ArrayList<String> lore0 = new ArrayList<>();
                                lore0.add("§7这是关于飞船的配方，§7§m飞船可以让你上天");
                                lore0.add("§7里面似乎蕴含着强大的力量♂");
                                lore0.add("");
                                lore0.add("§6§l右键§6打开");
                                itemMeta0.setLore(lore0);
                                itemStack0.setItemMeta(itemMeta0);
                                player.getInventory().addItem(itemStack0);
                            }
                        }
                        if (strings[0].equalsIgnoreCase("upgrade")) {
                            try {
                                UpgradeCentre.update();
                            } catch (Exception e) {
                                ConsoleLogger.error(e);
                                throw new RuntimeException(e);
                            }
                        }


                    }
                    return true;
                }
        );
        Objects.requireNonNull(MainData.plugin.getCommand("bf")).setTabCompleter(
                (sender, command, s, strings) -> strings.length == 1 ?
                        List.of("help", "getbook", "upgrade") : Collections.emptyList()
        );
    }
}

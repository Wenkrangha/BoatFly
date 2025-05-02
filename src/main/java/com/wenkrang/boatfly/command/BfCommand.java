package com.wenkrang.boatfly.command;

import com.wenkrang.boatfly.upgrade.UpgradeCentre;
import com.wenkrang.boatfly.lib.ConsoleLogger;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BfCommand implements CommandExecutor, TabCompleter {
    /**
     * 向传入的CommandSender对象发送帮助信息
     *
     * @param sender CommandSender对象，用于发送消息
     */
    public static void help(CommandSender sender) {
        sender.sendMessage("§7[!]  §4飞船 - BoatFly §7正在运行");
        sender.sendMessage(" §4| §7help  帮助列表");
        sender.sendMessage(" §4| §7getbook  获取配方");
        sender.sendMessage(" §4| §7- 创造下，右键配方可以将直接获取物品");
        sender.sendMessage(" §4| §7upgrade  全自动更新插件");
        sender.sendMessage(" §4| §7作者:Wenkrang");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender,
                             @NotNull Command command,
                             @NotNull String s,
                             String[] strings) {
        if (strings.length == 0) {
            help(commandSender);
        } else {
            //Debug

            if (strings[0].equalsIgnoreCase("help")) {
                help(commandSender);
            }
            if (strings[0].equalsIgnoreCase("getbook")) {
                if (commandSender instanceof Player) {
                    Player player = (Player) commandSender;
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

    //插件补全器
    //用于补全命令
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender,
                                      @NotNull Command command,
                                      @NotNull String s,
                                      String[] strings) {
        if (strings.length == 1) {//第一项补全
            return List.of("help", "getbook", "upgrade");
        }
        return Collections.emptyList();
    }


}

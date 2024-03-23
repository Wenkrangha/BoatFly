package com.wenkrang.boatfly.command;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.Entity.plane;
import com.wenkrang.boatfly.lib.SpigotConsoleColors;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.wenkrang.boatfly.BoatFly.*;
import static com.wenkrang.boatfly.Data.MainData.IsShutDown;

public class bf implements TabExecutor {
    /**
     * 向传入的CommandSender对象发送帮助信息
     *
     * @param sender CommandSender对象，用于发送消息
     */
    public static void gethelp(CommandSender sender) {
        sender.sendMessage("§7[!]  §4飞船 - BoatFly §7正在运行");
        sender.sendMessage(" §4| §7help  帮助列表");
        sender.sendMessage(" §4| §7getbook  获取配方");
        sender.sendMessage(" §4| §7getboat  获取飞船");
        sender.sendMessage(" §4| §7 - regular 飞船");
        sender.sendMessage(" §4| §7 - freight 货运飞船");
        sender.sendMessage(" §4| §7 - passenger 客运飞船");
        sender.sendMessage(" §4| §7作者:Wenkrang");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            gethelp(commandSender);
            return true;
        }
        if (strings[0].equalsIgnoreCase("help")) {
            gethelp(commandSender);
        }
        if (!(commandSender instanceof Player)) {
            return true;
        }
        Player player = (Player) commandSender;
        if (strings[0].equalsIgnoreCase("getbook")) {
            player.getInventory().addItem(BOOK_ITEM);
        } else if (strings[0].equalsIgnoreCase("getboat")) {
            if (!player.hasPermission("bf.getboat")) {
                return true;
            }
            if (strings.length < 2) {
                gethelp(commandSender);
                return true;
            }
            switch (strings[1].toLowerCase()) {
                case "regular": {
                    player.getInventory().addItem(REGULAR);
                    break;
                }
                case "freight": {
                    player.getInventory().addItem(FREIGHT);
                    break;
                }
                case "passenger": {
                    player.getInventory().addItem(PASSENGER);
                    break;
                }
            }
        } else {
            //commandSender.sendMessage(SpigotConsoleColors.DARK_RED + "[-] " + SpigotConsoleColors.RESET + "阿巴阿巴");
            gethelp(commandSender);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings.length) {
            case 1:
                return Arrays.asList("help", "getbook", "getboat");
            case 2: {
                if (strings[0].equalsIgnoreCase("getboat") && commandSender.hasPermission("bf.getboat")) {
                    return Arrays.asList("freight", "regular", "passenger");
                }
            }
            default:
                return Collections.emptyList();
        }
    }
}
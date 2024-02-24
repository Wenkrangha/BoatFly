package com.wenkrang.boatfly.event.GUI.book;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Path2 {
    public static void Show (Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "飞船模块配方");
        if (true) {
            ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            ItemMeta itemMeta0 = itemStack0.getItemMeta();
            itemMeta0.setDisplayName(" ");
            itemStack0.setItemMeta(itemMeta0);
            ItemStack itemStack1 = new ItemStack(Material.OAK_SIGN);
            ItemMeta itemMeta1 = itemStack1.getItemMeta();
            itemMeta1.setDisplayName("§9§l返回§r主页");
            itemStack1.setItemMeta(itemMeta1);
            ItemStack itemStack2 = new ItemStack(Material.CLOCK);
            ItemMeta itemMeta2 = itemStack2.getItemMeta();
            itemMeta2.setDisplayName("§9§l仪表§r盘");
            ArrayList<String> lore2 = new ArrayList<>();
            lore2.add("§7这是§7§l§o飞机的仪表盘§7，用来查看§7§l飞机§7的各个");
            lore2.add("§7参数，对飞机来说是§7§l§n非常重要§7的东西");
            itemMeta2.setLore(lore2);
            itemStack2.setItemMeta(itemMeta2);
            inventory.setItem(0, itemStack0);
            inventory.setItem(1, itemStack1);
            inventory.setItem(2, itemStack0);
            inventory.setItem(3, itemStack0);
            inventory.setItem(4, itemStack0);
            inventory.setItem(5, itemStack0);
            inventory.setItem(6, itemStack0);
            inventory.setItem(7, itemStack0);
            inventory.setItem(8, itemStack0);
            inventory.setItem(9, itemStack2);
        }
        if (true) {
            ItemStack itemStack7 = new ItemStack(Material.BEEHIVE);
            ItemMeta itemMeta7 = itemStack7.getItemMeta();
            itemMeta7.setDisplayName("§9§l发动机§r模块-I");
            ArrayList<String> lore7 = new ArrayList<>();
            lore7.add("§7这是1级的§7§l发动机模块§7，可以给飞机");
            lore7.add("§7提供§7§l强大的动力§7!");
            lore7.add("");
            lore7.add("§3?§7可提供动力:§2+2");
            itemMeta7.setLore(lore7);
            itemStack7.setItemMeta(itemMeta7);
        }
        if (true) {
            ItemStack itemStack7 = new ItemStack(Material.BEEHIVE);
            ItemMeta itemMeta7 = itemStack7.getItemMeta();
            itemMeta7.setDisplayName("§9§l发动机§r模块-II");
            ArrayList<String> lore7 = new ArrayList<>();
            lore7.add("§7这是2级的§7§l发动机模块§7，可以给飞机");
            lore7.add("§7提供§7§l强大的动力§7!");
            lore7.add("");
            lore7.add("§3?§7可提供动力:§2+3");
            itemMeta7.setLore(lore7);
            itemStack7.setItemMeta(itemMeta7);
            inventory.setItem(11, itemStack7);
        }



        player.openInventory(inventory);

    }
}

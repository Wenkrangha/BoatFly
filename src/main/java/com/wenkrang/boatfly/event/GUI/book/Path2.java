package com.wenkrang.boatfly.event.GUI.book;

import com.wenkrang.boatfly.lib.Materials;
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
        ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta itemMeta0 = itemStack0.getItemMeta();
        itemMeta0.setDisplayName(" ");
        itemStack0.setItemMeta(itemMeta0);
        ItemStack itemStack1 = new ItemStack(Materials.sign);
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§9§l返回§r主页");
        itemStack1.setItemMeta(itemMeta1);


        inventory.setItem(0, itemStack0);
        inventory.setItem(1, itemStack1);
        inventory.setItem(2, itemStack0);
        inventory.setItem(3, itemStack0);
        inventory.setItem(4, itemStack0);
        inventory.setItem(5, itemStack0);
        inventory.setItem(6, itemStack0);
        inventory.setItem(7, itemStack0);
        inventory.setItem(8, itemStack0);

        if (true) {
            ItemStack itemStack7 = new ItemStack(Materials.beeHive);
            ItemMeta itemMeta7 = itemStack7.getItemMeta();
            itemMeta7.setDisplayName("§9§l发动机§r模块-I");
            ArrayList<String> lore7 = new ArrayList<>();
            lore7.add("§7这是1级的§7§l发动机模块§7，可以给飞机");
            lore7.add("§7提供§7§l强大的动力§7!");
            lore7.add("");
            lore7.add("§3☞§7可提供动力:§2+2");
            itemMeta7.setLore(lore7);
            itemStack7.setItemMeta(itemMeta7);
            inventory.setItem(10, itemStack7);
        }
        if (true) {
            ItemStack itemStack7 = new ItemStack(Materials.beeHive);
            ItemMeta itemMeta7 = itemStack7.getItemMeta();
            itemMeta7.setDisplayName("§9§l发动机§r模块-II");
            ArrayList<String> lore7 = new ArrayList<>();
            lore7.add("§7这是2级的§7§l发动机模块§7，可以给飞机");
            lore7.add("§7提供§7§l强大的动力§7!");
            lore7.add("");
            lore7.add("§3☞§7可提供动力:§2+3");
            itemMeta7.setLore(lore7);
            itemStack7.setItemMeta(itemMeta7);
            inventory.setItem(11, itemStack7);
        }
        if (true) {

        }



        player.openInventory(inventory);

    }
}

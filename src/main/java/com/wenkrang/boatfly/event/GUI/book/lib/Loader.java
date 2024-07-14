package com.wenkrang.boatfly.event.GUI.book.lib;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Loader {
    public static void run(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "飞船配方主页");
        ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta itemMeta0 = itemStack0.getItemMeta();
        itemMeta0.setDisplayName(" ");
        itemStack0.setItemMeta(itemMeta0);
        ItemStack itemStack1 = new ItemStack(Material.COMPASS);
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§9§l飞机§r配方");
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§7这里是§7§l飞机配方§7的§7§l主页§7你可以在这里");
        lore1.add("§7查看所有§7§n飞机部件§7的配方");
        itemMeta1.setLore(lore1);
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

        for (int i = 0;i < BookAPI.things.toArray().length;i++) {
            if (BookAPI.things.get(i) instanceof Recipe) {
                Recipe recipe = (Recipe) BookAPI.things.get(i);
                inventory.addItem(recipe.item);
            }
            if (BookAPI.things.get(i) instanceof Page) {
                Page page = (Page) BookAPI.things.get(i);
                inventory.addItem(page.item);
            }
        }

        player.openInventory(inventory);
    }
}

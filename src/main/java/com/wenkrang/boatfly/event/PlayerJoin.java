package com.wenkrang.boatfly.event;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerJoin implements Listener {
    @EventHandler
    public static void OnPlayerJoin (PlayerJoinEvent event) {
        if (event.getPlayer().getLastPlayed() == 0) {
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
            event.getPlayer().getInventory().addItem(itemStack0);
        }
    }
}

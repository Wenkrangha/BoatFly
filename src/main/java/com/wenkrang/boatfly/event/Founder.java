package com.wenkrang.boatfly.event;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Founder implements Listener {
    @EventHandler
    public static void OnClick(PlayerInteractEvent event) {

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (event.getHand().equals(EquipmentSlot.HAND)) {
                ItemStack itemStack10 = new ItemStack(Material.CLOCK);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemMeta10.setDisplayName("§9飞船§r寻找器");
                ArrayList<String> lore10 = new ArrayList<>();
                lore10.add("§7它可以§n帮助§r§7你寻找§l100格内的飞船§r§7，给于你与它的§n距离§r§7");
                lore10.add("§7再也不怕§n飞船§r§7丢了捏（");
                lore10.add("");
                lore10.add("§6§n§l右键 §r§7寻找");
                itemMeta10.setLore(lore10);
                itemStack10.setItemMeta(itemMeta10);
                if (event.getPlayer().getInventory().getItemInMainHand().equals(itemStack10)){
                    final var boatFound = new AtomicBoolean(false);
                    final var nearbyEntities = event.getPlayer().getNearbyEntities(100, 100, 100);
                    nearbyEntities.stream()
                            .filter(i -> i.getScoreboardTags().contains("CanFly"))
                            .map(Entity::getLocation)
                            .forEach(i -> {
                                event.getPlayer().sendMessage("§9[*]§r 在§l" +
                                        i.distance(event.getPlayer().getLocation()) +
                                        "§r格外，有一辆§l飞船");
                                boatFound.set(true);
                            });
                    if (!boatFound.get()) {
                        event.getPlayer().sendMessage("§c[-]§r 附近没有可用的飞船（大悲");
                    }
                    event.setCancelled(true);
                }
            }
        }
    }
}

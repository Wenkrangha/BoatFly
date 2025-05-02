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
import java.util.concurrent.atomic.AtomicBoolean;

public class Finder implements Listener {
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
                    final var boatFound = event.getPlayer().
                            getNearbyEntities(100, 100, 100)
                            // 获取100*100*100范围内实体列表的流
                            .stream()
                            // 选中飞船
                            .filter(i -> i.getScoreboardTags().contains("CanFly"))
                            // 获取飞船相对于玩家的距离
                            .map(i -> i.getLocation().distance(event.getPlayer().getLocation()))
                            // 向玩家报告飞船距离
                            .peek(i -> event.getPlayer().sendMessage("§9[*]§r 在§l" + i +
                                    "§r格外，有一辆§l飞船"))
                            .findAny().isPresent();
                    if (!boatFound) {
                        event.getPlayer().sendMessage("§c[-]§r 附近没有可用的飞船（大悲");
                    }
                    event.setCancelled(true);
                }
            }
        }
    }
}

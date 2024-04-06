package com.wenkrang.boatfly.event;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.event.GUI.book.PlayerInteract;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class VehicleDestroy implements Listener {
    @EventHandler
    public static void OnVehicleDestroyEvent(VehicleDestroyEvent event) {
        if (event.getVehicle().getScoreboardTags().contains("CanFly")) {
            for (Entity entity : event.getVehicle().getPassengers()) {
                if (entity instanceof Player) {
                    Player player = (Player) entity;
                    player.addScoreboardTag("CanExit");
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            player.closeInventory();
                            event.getVehicle().removePassenger(player);
                        }
                    }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 1);
                }
            }
            if (PlayerInteract.isBelow1_20_4()) {
                if (event.getVehicle().getCustomName().equalsIgnoreCase("§9§l飞§r船")) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            ItemStack itemStack9 = new ItemStack(Material.OAK_BOAT);
                            ItemMeta itemMeta9 = itemStack9.getItemMeta();
                            itemMeta9.setDisplayName("§9§l飞§r船");
                            ArrayList<String> lore9 = new ArrayList<>();
                            lore9.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
                            lore9.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
                            lore9.add("§7由地去探索这个§7§l世界");
                            lore9.add("");
                            lore9.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
                            lore9.add("§6在§6§l船上§6,按§f§l§o§nShift§6打开面板");
                            itemMeta9.setLore(lore9);
                            itemStack9.setItemMeta(itemMeta9);
                            event.getVehicle().getWorld().dropItem(event.getVehicle().getLocation(), itemStack9);
                            event.getVehicle().remove();
                        }
                    }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 1);
                    event.setCancelled(true);
                }
                if (event.getVehicle().getCustomName().equalsIgnoreCase("§9§l货运§r飞船")) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            ItemStack itemStack4 = new ItemStack(Material.OAK_CHEST_BOAT);
                            ItemMeta itemMeta4 = itemStack4.getItemMeta();
                            itemMeta4.setDisplayName("§9§l货运§r飞船");
                            ArrayList<String> lore4 = new ArrayList<>();
                            lore4.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
                            lore4.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
                            lore4.add("§7由地去探索这个§7§l世界");
                            lore4.add("§7这艘飞船不仅可以§l载人§r§7，还可以§l§n运货");
                            lore4.add("");
                            lore4.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
                            lore4.add("§6在§6§l船上§6,按§f§l§o§nShift§6打开面板");
                            itemMeta4.setLore(lore4);
                            itemStack4.setItemMeta(itemMeta4);
                            event.getVehicle().getWorld().dropItem(event.getVehicle().getLocation(), itemStack4);
                            event.getVehicle().remove();
                        }
                    }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 1);
                    event.setCancelled(true);
                }
                if (event.getVehicle().getCustomName().equalsIgnoreCase("§9§l客运§r飞船")) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            ItemStack itemStack4 = new ItemStack(Material.OAK_CHEST_BOAT);
                            ItemMeta itemMeta4 = itemStack4.getItemMeta();
                            itemMeta4.setDisplayName("§9§l客运§r飞船");
                            ArrayList<String> lore4 = new ArrayList<>();
                            lore4.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
                            lore4.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
                            lore4.add("§7由地去探索这个§7§l世界");
                            lore4.add("§7这艘船没有攻击模块，而且造价更低");
                            lore4.add("");
                            lore4.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
                            lore4.add("§6在§6§l船上§6,按§f§l§o§nShift§6打开面板");
                            itemMeta4.setLore(lore4);
                            itemStack4.setItemMeta(itemMeta4);
                            event.getVehicle().getWorld().dropItem(event.getVehicle().getLocation(), itemStack4);
                            event.getVehicle().remove();
                        }
                    }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 1);
                    event.setCancelled(true);
                }
                //"§9§l客运§r飞船"
            }
        }
    }
}

package com.wenkrang.boatfly.event;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class PlayerSwapHandItems implements Listener {
    @EventHandler
    public static void OnPlayerSwapHandItems (org.bukkit.event.player.PlayerSwapHandItemsEvent event) {
        if (event.getPlayer().getVehicle() != null && Objects.requireNonNull(event.getPlayer().getVehicle()).getScoreboardTags().contains("CanFire")) {
            if (event.getOffHandItem() != null && event.getOffHandItem().getType().equals(Material.ARROW)) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
                        itemInMainHand.setAmount(itemInMainHand.getAmount() - 1);
                        event.getPlayer().getInventory().setItemInMainHand(itemInMainHand);
                        Arrow spawn = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Arrow.class);
                        spawn.setVelocity(event.getPlayer().getLocation().getDirection().multiply(7));
                        spawn.setShooter(event.getPlayer());
                    }
                }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 5);
                event.setCancelled(true);
            }
            if (event.getOffHandItem() != null && event.getOffHandItem().getType().equals(Material.TNT)) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
                        itemInMainHand.setAmount(itemInMainHand.getAmount() - 1);
                        event.getPlayer().getInventory().setItemInMainHand(itemInMainHand);
                        Location location = event.getPlayer().getLocation();
                        location.add(0, -3, 0);
                        TNTPrimed spawn = event.getPlayer().getWorld().spawn(location, TNTPrimed.class);
                        spawn.setVelocity(event.getPlayer().getLocation().getDirection().multiply(2));
                    }
                }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 5);
                event.setCancelled(true);
            }
        }
    }
}

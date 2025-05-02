package com.wenkrang.boatfly.event.GUI.book;

import com.wenkrang.boatfly.lib.PlaneUtil;
import com.wenkrang.boatfly.lib.VersionChecker;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class PlayerInteract implements Listener {
    public static boolean isBelow1_20_4() {
        try {
            return VersionChecker.isVersionBelow("1.20.4");
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public static Location getOffsetForFace(BlockFace face) {
        double dx, dz;
        switch (face) {
            case NORTH_WEST:
                dx = -0.5;
                dz = -0.5;
            case NORTH_EAST:
                dx = 0.5;
                dz = -0.5;
            case SOUTH_WEST:
                dx = -0.5;
                dz = 0.5;
            case SOUTH_EAST:
                dx = 0.5;
                dz = 0.5;
            // ... 其他斜向面的处理 ...
            default:
                dx = 0;
                dz = 0;
        }
        return new Location(null, dx, 0, dz); // 返回一个只有偏移量的Location对象
    }
    public static Location calculateParticleLocation(Location blockLocation, BlockFace face) {
        return switch (face) {
            case NORTH -> blockLocation.clone().add(0.5, 0.5, 0);
            case SOUTH -> blockLocation.clone().add(0.5, 0.5, 1);
            case WEST -> blockLocation.clone().add(0, 0.5, 0.5);
            case EAST -> blockLocation.clone().add(1, 0.5, 0.5);
            case UP -> blockLocation.clone().add(0.5, 1, 0.5);
            case DOWN -> blockLocation.clone().add(0.5, 0, 0.5);
            // 对于其他斜向面，需要额外计算偏移量
            // 例如对于NORTH_EAST等方向，可以通过向量运算获得准确位置
            // 这里假设你已经有一个名为getOffsetForFace的函数完成这项工作
            default -> blockLocation.clone().add(getOffsetForFace(face));
        };
    }

    @EventHandler
    public static void onPlayer(PlayerInteractEvent event) {
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
        if (event.getPlayer().getInventory().getItemInMainHand().equals(itemStack0)) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (Objects.equals(event.getHand(), EquipmentSlot.HAND)) {
                    Main.Show(event.getPlayer());
                }
            }
        }


        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getHand().equals(EquipmentSlot.HAND)) {
                if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() &&
                        (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9§l飞§r船") ||
                                event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9§l货运§r飞船") ||
                                event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9§l客运§r飞船"))) {
                    Block clickedBlock = event.getClickedBlock();
                    Location location = calculateParticleLocation(clickedBlock.getLocation(), event.getBlockFace());
                    switch (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()) {
                        case "§9§l飞§r船" -> PlaneUtil.getPlane(location);
                        case "§9§l货运§r飞船" -> PlaneUtil.getPlaneLevel2(location);
                        case "§9§l客运§r飞船" -> PlaneUtil.getPlaneLevel3(location);
                    }
                    if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE))
                        event.getPlayer().getInventory().setItemInMainHand(null);
                    event.setCancelled(true);
                }
            }
        }
    }
}

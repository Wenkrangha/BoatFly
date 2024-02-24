package com.wenkrang.boatfly.event.GUI.table;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Dropper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Objects;

public class OpenTable implements Listener {
    @EventHandler
    public static void OnPlayer(PlayerInteractEvent event) {

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getHand().equals(EquipmentSlot.HAND) && Objects.requireNonNull(event.getClickedBlock()).getBlockData().getMaterial().equals(Material.DROPPER)) {
            Dropper dropper = (Dropper) event.getClickedBlock().getState();
            if (dropper.getCustomName() != null) {
                String customName = dropper.getCustomName();
                if (customName.contains("装配台")) {
                    Inventory inventory = Bukkit.createInventory(null, 54, "航空装配台");
                    ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                    ItemMeta itemMeta0 = itemStack0.getItemMeta();
                    itemMeta0.setDisplayName(" ");
                    itemStack0.setItemMeta(itemMeta0);
                    ItemStack itemStack1 = new ItemStack(Material.CARTOGRAPHY_TABLE);
                    ItemMeta itemMeta1 = itemStack1.getItemMeta();
                    itemMeta1.setDisplayName("§9§l航空§r装配台");
                    ArrayList<String> lore1 = new ArrayList<>();
                    lore1.add("§7你可以在这里§7§l装配§7你的飞机，将§7§l§n不同的模块");
                    lore1.add("§7§l§o装配到上面§7，以加强它的性能");
                    itemMeta1.setLore(lore1);
                    itemStack1.setItemMeta(itemMeta1);
                    ItemStack itemStack2 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                    ItemMeta itemMeta2 = itemStack2.getItemMeta();
                    itemStack2.setItemMeta(itemMeta2);
                    ItemStack itemStack3 = new ItemStack(Material.OAK_SIGN);
                    ItemMeta itemMeta3 = itemStack3.getItemMeta();
                    itemMeta3.setDisplayName("§9§l将配件§r放在上方");
                    ArrayList<String> lore3 = new ArrayList<>();
                    lore3.add("§7将你的§7§l配件§7放在§7§l§n上面§7，然后按下§7§l§n下面的按钮");
                    itemMeta3.setLore(lore3);
                    itemStack3.setItemMeta(itemMeta3);
                    ItemStack itemStack4 = new ItemStack(Material.OAK_SIGN);
                    ItemMeta itemMeta4 = itemStack4.getItemMeta();
                    itemMeta4.setDisplayName("§9§l请将飞机放在§r下方");
                    ArrayList<String> lore4 = new ArrayList<>();
                    lore4.add("§7请将你需要添加（拆除）配件的§7§l§o飞机");
                    lore4.add("§7放在§7§l§n下方");
                    itemMeta4.setLore(lore4);
                    itemStack4.setItemMeta(itemMeta4);
                    ItemStack itemStack5 = new ItemStack(Material.ANVIL);
                    ItemMeta itemMeta5 = itemStack5.getItemMeta();
                    itemMeta5.setDisplayName("§9§l确§r定");
                    itemStack5.setItemMeta(itemMeta5);
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
                    inventory.setItem(17, itemStack2);
                    inventory.setItem(18, itemStack2);
                    inventory.setItem(19, itemStack3);
                    inventory.setItem(20, itemStack2);
                    inventory.setItem(21, itemStack2);
                    inventory.setItem(22, itemStack2);
                    inventory.setItem(23, itemStack2);
                    inventory.setItem(24, itemStack2);
                    inventory.setItem(25, itemStack4);
                    inventory.setItem(26, itemStack2);
                    inventory.setItem(33, itemStack2);
                    inventory.setItem(35, itemStack2);
                    inventory.setItem(37, itemStack5);
                    inventory.setItem(42, itemStack2);
                    inventory.setItem(43, itemStack2);
                    inventory.setItem(44, itemStack2);

                    event.getPlayer().openInventory(inventory);

                    event.setCancelled(true);
                }
            }
        }

    }
}

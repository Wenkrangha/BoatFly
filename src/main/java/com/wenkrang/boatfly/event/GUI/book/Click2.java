package com.wenkrang.boatfly.event.GUI.book;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Click2 implements Listener {
    @EventHandler
    public static void OnPlayer (InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("飞船配方主页")) {
            if (event.getRawSlot() == 16) {
                Path2.Show((Player) event.getWhoClicked());
            }
        }
        if (event.getView().getTitle().contains("飞船模块配方-")) {
            if (event.getRawSlot() == 1) {
                Path2.Show((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase("飞船模块配方")) {
            if (event.getRawSlot() == 1)  {
                Main.Show((Player) event.getWhoClicked());
            }
            if (event.getRawSlot() == 9) {
                Inventory inventory = Bukkit.createInventory(null, 27, "飞船模块配方-仪表盘");
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Material.OAK_SIGN);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l返回§r主页");
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Material.COMPARATOR);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta itemMeta3 = itemStack3.getItemMeta();
                itemMeta3.setDisplayName("§9§l工作台§r合成");
                ArrayList<String> lore3 = new ArrayList<>();
                lore3.add("§7该物品使用§7§l工作台§7合成，请");
                lore3.add("§7按照配方§7§l§n有序合成");
                itemMeta3.setLore(lore3);
                itemStack3.setItemMeta(itemMeta3);
                ItemStack itemStack4 = new ItemStack(Material.REDSTONE_LAMP);
                ItemMeta itemMeta4 = itemStack4.getItemMeta();
                itemStack4.setItemMeta(itemMeta4);
                ItemStack itemStack5 = new ItemStack(Material.REDSTONE);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemStack5.setItemMeta(itemMeta5);
                ItemStack itemStack6 = new ItemStack(Material.CLOCK);
                ItemMeta itemMeta6 = itemStack6.getItemMeta();
                itemMeta6.setDisplayName("§9§l仪表§r盘");
                ArrayList<String> lore6 = new ArrayList<>();
                lore6.add("§7这是§7§l§o飞机的仪表盘§7，用来查看§7§l飞机§7的各个");
                lore6.add("§7参数，对飞机来说是§7§l§n非常重要§7的东西");
                itemMeta6.setLore(lore6);
                itemStack6.setItemMeta(itemMeta6);
                ItemStack itemStack7 = new ItemStack(Material.GOLD_INGOT);
                ItemMeta itemMeta7 = itemStack7.getItemMeta();
                itemStack7.setItemMeta(itemMeta7);
                inventory.setItem(0, itemStack0);
                inventory.setItem(1, itemStack1);
                inventory.setItem(2, itemStack0);
                inventory.setItem(4, itemStack2);
                inventory.setItem(6, itemStack0);
                inventory.setItem(7, itemStack0);
                inventory.setItem(8, itemStack0);
                inventory.setItem(10, itemStack3);
                inventory.setItem(12, itemStack4);
                inventory.setItem(13, itemStack5);
                inventory.setItem(14, itemStack4);
                inventory.setItem(16, itemStack6);
                inventory.setItem(21, itemStack7);
                inventory.setItem(22, itemStack7);
                inventory.setItem(23, itemStack7);

                event.getWhoClicked().openInventory(inventory);
                if (event.isRightClick() && event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
                    event.getWhoClicked().getInventory().addItem(itemStack6);
                    event.getWhoClicked().closeInventory();
                }
            }
            if (event.getRawSlot() == 10) {
                Inventory inventory = Bukkit.createInventory(null, 27, "飞船模块配方-发动机模块-I");
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Material.OAK_SIGN);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l返回§r主页");
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Material.LIGHTNING_ROD);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.ANVIL);
                ItemMeta itemMeta3 = itemStack3.getItemMeta();
                itemStack3.setItemMeta(itemMeta3);
                ItemStack itemStack4 = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta itemMeta4 = itemStack4.getItemMeta();
                itemMeta4.setDisplayName("§9§l工作台§r合成");
                ArrayList<String> lore4 = new ArrayList<>();
                lore4.add("§7该物品使用§7§l工作台§7合成，请");
                lore4.add("§7按照配方§7§l§n有序合成");
                itemMeta4.setLore(lore4);
                itemStack4.setItemMeta(itemMeta4);
                ItemStack itemStack5 = new ItemStack(Material.FURNACE);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemStack5.setItemMeta(itemMeta5);
                ItemStack itemStack6 = new ItemStack(Material.BLAST_FURNACE);
                ItemMeta itemMeta6 = itemStack6.getItemMeta();
                itemStack6.setItemMeta(itemMeta6);
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
                ItemStack itemStack8 = new ItemStack(Material.IRON_INGOT);
                ItemMeta itemMeta8 = itemStack8.getItemMeta();
                itemStack8.setItemMeta(itemMeta8);
                ItemStack itemStack9 = new ItemStack(Material.COPPER_INGOT);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemStack9.setItemMeta(itemMeta9);
                inventory.setItem(0, itemStack0);
                inventory.setItem(1, itemStack1);
                inventory.setItem(2, itemStack0);
                inventory.setItem(3, itemStack2);
                inventory.setItem(4, itemStack3);
                inventory.setItem(5, itemStack2);
                inventory.setItem(6, itemStack0);
                inventory.setItem(7, itemStack0);
                inventory.setItem(8, itemStack0);
                inventory.setItem(10, itemStack4);
                inventory.setItem(12, itemStack5);
                inventory.setItem(13, itemStack6);
                inventory.setItem(14, itemStack5);
                inventory.setItem(16, itemStack7);
                inventory.setItem(21, itemStack8);
                inventory.setItem(22, itemStack9);
                inventory.setItem(23, itemStack8);

                event.getWhoClicked().openInventory(inventory);
                if (event.isRightClick() && event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
                    event.getWhoClicked().getInventory().addItem(itemStack7);
                    event.getWhoClicked().closeInventory();
                }
            }
            if (event.getRawSlot() == 11) {
                Inventory inventory = Bukkit.createInventory(null, 27, "飞船模块配方-发动机模块-II");
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Material.OAK_SIGN);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l返回§r主页");
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Material.LIGHTNING_ROD);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.ANVIL);
                ItemMeta itemMeta3 = itemStack3.getItemMeta();
                itemStack3.setItemMeta(itemMeta3);
                ItemStack itemStack4 = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta itemMeta4 = itemStack4.getItemMeta();
                itemMeta4.setDisplayName("§9§l工作台§r合成");
                ArrayList<String> lore4 = new ArrayList<>();
                lore4.add("§7该物品使用§7§l工作台§7合成，请");
                lore4.add("§7按照配方§7§l§n有序合成");
                itemMeta4.setLore(lore4);
                itemStack4.setItemMeta(itemMeta4);
                ItemStack itemStack5 = new ItemStack(Material.BLAST_FURNACE);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemStack5.setItemMeta(itemMeta5);
                ItemStack itemStack6 = new ItemStack(Material.BEEHIVE);
                ItemMeta itemMeta6 = itemStack6.getItemMeta();
                itemMeta6.setDisplayName("§9§l发动机§r模块-I");
                ArrayList<String> lore6 = new ArrayList<>();
                lore6.add("§7这是1级的§7§l发动机模块§7，可以给飞机");
                lore6.add("§7提供§7§l强大的动力§7!");
                lore6.add("");
                lore6.add("§3?§7可提供动力:§2+2");
                itemMeta6.setLore(lore6);
                itemStack6.setItemMeta(itemMeta6);
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
                ItemStack itemStack8 = new ItemStack(Material.IRON_INGOT);
                ItemMeta itemMeta8 = itemStack8.getItemMeta();
                itemStack8.setItemMeta(itemMeta8);
                ItemStack itemStack9 = new ItemStack(Material.NETHERITE_INGOT);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemStack9.setItemMeta(itemMeta9);
                inventory.setItem(0, itemStack0);
                inventory.setItem(1, itemStack1);
                inventory.setItem(2, itemStack0);
                inventory.setItem(3, itemStack2);
                inventory.setItem(4, itemStack3);
                inventory.setItem(5, itemStack2);
                inventory.setItem(6, itemStack0);
                inventory.setItem(7, itemStack0);
                inventory.setItem(8, itemStack0);
                inventory.setItem(10, itemStack4);
                inventory.setItem(12, itemStack5);
                inventory.setItem(13, itemStack6);
                inventory.setItem(14, itemStack5);
                inventory.setItem(16, itemStack7);
                inventory.setItem(21, itemStack8);
                inventory.setItem(22, itemStack9);
                inventory.setItem(23, itemStack8);

                event.getWhoClicked().openInventory(inventory);
                if (event.isRightClick() && event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
                    event.getWhoClicked().getInventory().addItem(itemStack7);
                    event.getWhoClicked().closeInventory();
                }
            }

            event.setCancelled(true);
        }
    }
}

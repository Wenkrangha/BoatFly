package com.wenkrang.boatfly.event.GUI;

import com.wenkrang.boatfly.item.Materials;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class HomeFly implements Listener {
    //类名随便取的，所以不要揍我qwq
    private static Inventory furnace;
    @EventHandler
    public static void interactive(InventoryClickEvent e) {
        ItemStack crafting = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta craftingMeta = crafting.getItemMeta();
        craftingMeta.setDisplayName("§b打开工作台");
        ArrayList<String> loreCrafting = new ArrayList<>();
        loreCrafting.add("§b房船自带工作台。");
        loreCrafting.add("§b点击打开你房船的工作台！");
        craftingMeta.setLore(loreCrafting);
        crafting.setItemMeta(craftingMeta);
        if (e.getView().getTitle().equalsIgnoreCase("飞船控制面包") && e.getRawSlot() == 17) {
            if (e.getCurrentItem() == crafting) {
                e.getWhoClicked().openInventory(Bukkit.createInventory(null, InventoryType.WORKBENCH, "§b§l房船工作台"));
            }
        }
        ItemStack furnacing = new ItemStack(Materials.blastFurnace);
        ItemMeta furnacingMeta = furnacing.getItemMeta();
        furnacingMeta.setDisplayName("§b打开熔炉");
        ArrayList<String> loreFurnacing = new ArrayList<>();
        loreFurnacing.add("§b房船自带熔炉。");
        loreFurnacing.add("§b点击打开你房船的熔炉！");
        furnacingMeta.setLore(loreFurnacing);
        furnacing.setItemMeta(furnacingMeta);
        if (e.getView().getTitle().equalsIgnoreCase("飞船控制面包") && e.getRawSlot() == 26) {
            if (e.getCurrentItem() == furnacing) {
                e.getWhoClicked().openInventory(Bukkit.createInventory(null, InventoryType.FURNACE, "§c§l请勿在使用时关闭"));
            }
        }
        ItemStack bed = new ItemStack(Material.LIGHT_BLUE_BED);
        ItemMeta bedMeta = bed.getItemMeta();
        bedMeta.setDisplayName("§b设置重生点");
        ArrayList<String> loreBed = new ArrayList<>();
        loreBed.add("§7点击设置你的重生点为§cx " + e.getWhoClicked().getLocation().getBlockX() +
                " §ey " + e.getWhoClicked().getLocation().getBlockY() +
                " §bz " + e.getWhoClicked().getLocation().getBlockZ());
        bedMeta.setLore(loreBed);
        bed.setItemMeta(bedMeta);
        if (e.getView().getTitle().equalsIgnoreCase("飞船控制面包") && e.getRawSlot() == 35) {
            if (e.getCurrentItem() == bed) {
                try {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " +
                            e.getWhoClicked().getName() + " " +
                            e.getWhoClicked().getLocation().getBlockX() + " " +
                            e.getWhoClicked().getLocation().getBlockY() + " " +
                            e.getWhoClicked().getLocation().getBlockZ());
                } catch (CommandException el) {
                    ConsoleLoger.error("spawnpoint 命令似乎不存在：" + el.getMessage());
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b设置重生点")) {
                e.getWhoClicked().sendMessage("§c请重新打开控制面包！");
            }
        }
        e.setCancelled(true);
    }
}

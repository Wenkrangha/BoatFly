package com.wenkrang.boatfly.event.Compatibility;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.lib.Materials;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static com.wenkrang.boatfly.DataSystem.MainData.keys;

public class BoatBuild implements Listener {
    @EventHandler
    public static void buildCPT(InventoryClickEvent event) {
        event.getInventory();
        if (event.getInventory().getHolder() instanceof Player) {
            if (event.getInventory() instanceof CraftingInventory) {
                CraftingInventory inventory = (CraftingInventory) event.getInventory();
                ItemStack[] matrix = inventory.getMatrix();
                ItemStack itemStack2 = new ItemStack(Material.CONDUIT);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.BEACON);
                ItemMeta itemMeta3 = itemStack3.getItemMeta();
                itemStack3.setItemMeta(itemMeta3);
                ItemStack itemStack4 = new ItemStack(Material.END_CRYSTAL);
                ItemMeta itemMeta4 = itemStack4.getItemMeta();
                itemStack4.setItemMeta(itemMeta4);
                ItemStack itemStack6 = new ItemStack(Material.SADDLE);
                ItemMeta itemMeta6 = itemStack6.getItemMeta();
                itemStack6.setItemMeta(itemMeta6);
                ItemStack itemStack7 = new ItemStack(Materials.beeHive);
                ItemMeta itemMeta7 = itemStack7.getItemMeta();
                itemMeta7.setDisplayName("§9§l发动机§r模块");
                ArrayList<String> lore7 = new ArrayList<>();
                lore7.add("§7这是飞船的§7§l发动机模块§7,是整个飞船§7§l§n最重要§7的");
                lore7.add("§7模块，用§7§l强大的材料§7制成");
                itemMeta7.setLore(lore7);
                itemStack7.setItemMeta(itemMeta7);
                ItemStack itemStack8 = new ItemStack(Material.DISPENSER);
                ItemMeta itemMeta8 = itemStack8.getItemMeta();
                itemMeta8.setDisplayName("§c§l攻击§r模块");
                ArrayList<String> lore8 = new ArrayList<>();
                lore8.add("§7飞机的攻击模块，可以发射");
                lore8.add("§7TNT和弓箭");
                itemMeta8.setLore(lore8);
                itemStack8.setItemMeta(itemMeta8);
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
                ItemStack itemStack10 = new ItemStack(Materials.netheriteIngot);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemStack10.setItemMeta(itemMeta10);
                ItemStack itemStack11 = new ItemStack(Material.REDSTONE);
                ItemMeta itemMeta11 = itemStack11.getItemMeta();
                itemStack11.setItemMeta(itemMeta11);

                ArrayList<ItemStack> list = new ArrayList<>();
                list.add(itemStack2);
                list.add(itemStack3);
                list.add(itemStack4);
                list.add(itemStack6);
                list.add(itemStack7);
                list.add(itemStack8);
                list.add(itemStack10);
                list.add(itemStack11);
                list.add(itemStack10);
                boolean add = false;

                for (int i = 0; i < 4; i++) {
                    if (matrix[i] != null) {
                        if (matrix[i].getType() != Material.AIR) {
                            if (matrix[i].getType().equals(list.get(i).getType())) {
                                if (matrix[5].getType().equals(itemStack7.getType()) && matrix[5].getItemMeta().getDisplayName().equalsIgnoreCase("§9§l发动机§r模块")) {
                                    if (matrix[6].getType().equals(itemStack8.getType()) && matrix[6].getItemMeta().getDisplayName().equalsIgnoreCase("§c§l攻击§r模块")) {
                                        for (int j = 7; j < 9; j++) {
                                            if (matrix[j] != null) {
                                                if (matrix[j].getType() != Material.AIR) {
                                                    if (matrix[j].getType().equals(list.get(j).getType())) {
                                                        add = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (add) {
                    inventory.setResult(itemStack9);
                }
            }
        }
    }
}

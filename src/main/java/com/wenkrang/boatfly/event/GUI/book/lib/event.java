package com.wenkrang.boatfly.event.GUI.book.lib;

import com.wenkrang.boatfly.lib.Materials;
import com.wenkrang.boatfly.lib.ShapedRecipeUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class event implements Listener {
    public void enter(InventoryClickEvent event) {
        ItemStack item = event.getInventory().getItem(event.getRawSlot());
        for (int i = 0; i < BookAPI.pages.size(); i++) {
            if (BookAPI.pages.get(i).item.equals(item)) {
                Inventory inventory = Bukkit.createInventory(null, 27, "飞船配方主页 - " + BookAPI.pages.get(i).title);
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Materials.sign);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l返回§r主页");
                itemStack1.setItemMeta(itemMeta1);

                inventory.setItem(0, itemStack0);
                inventory.setItem(1, itemStack1);
                inventory.setItem(2, itemStack0);
                inventory.setItem(3, itemStack0);
                inventory.setItem(4, itemStack0);
                inventory.setItem(5, itemStack0);
                inventory.setItem(6, itemStack0);
                inventory.setItem(7, itemStack0);
                inventory.setItem(8, itemStack0);

                for (int j = 0; j < BookAPI.pages.get(i).things.size(); j++) {
                    if (BookAPI.pages.get(i).things.get(j) instanceof Recipe) {
                        Recipe recipe = (Recipe) BookAPI.things.get(i);
                        inventory.addItem(recipe.item);
                    }
                    if (BookAPI.pages.get(i).things.get(j) instanceof Page) {
                        Page page = (Page) BookAPI.things.get(i);
                        inventory.addItem(page.item);
                    }
                }
                event.getWhoClicked().openInventory(inventory);
            }
        }
        for (int i = 0; i < BookAPI.recipes.size(); i++) {
            if (BookAPI.recipes.get(i).item.equals(item)) {
                Inventory inventory = Bukkit.createInventory(null, 27, "飞船模块配方 - " + BookAPI.recipes.get(i).item.getItemMeta().getDisplayName());
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Materials.sign);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l返回§r主页");
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Materials.lightningRod);
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
                ItemStack itemStack5 = new ItemStack(Materials.blastFurnace);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemStack5.setItemMeta(itemMeta5);
                ItemStack itemStack8 = new ItemStack(Material.IRON_INGOT);
                ItemMeta itemMeta8 = itemStack8.getItemMeta();
                itemStack8.setItemMeta(itemMeta8);
                ItemStack itemStack9 = new ItemStack(Materials.netheriteIngot);
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

                ShapedRecipe shapedRecipe = BookAPI.recipes.get(i).shapedRecipe;
                List<ItemStack> itemStacks = ShapedRecipeUtil.getItemStacks(shapedRecipe);
                inventory.setItem(4, itemStacks.get(0));
                inventory.setItem(5, itemStacks.get(1));
                inventory.setItem(6, itemStacks.get(2));
                inventory.setItem(12, itemStacks.get(3));
                inventory.setItem(13, itemStacks.get(4));
                inventory.setItem(14, itemStacks.get(5));
                inventory.setItem(21, itemStacks.get(6));
                inventory.setItem(22, itemStacks.get(7));
                inventory.setItem(23, itemStacks.get(8));

                event.getWhoClicked().openInventory(inventory);
            }
        }


    }
    @EventHandler
    public void onItemClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("飞船配方主页")) {
            enter(event);
        } else {
            for (int i = 0; i < BookAPI.pages.size(); i++) {
                if (BookAPI.pages.get(i).title.equalsIgnoreCase(event.getView().getTitle())) {
                    enter(event);
                    break;
                }
            }
        }

        if (event.getView().getTitle().equalsIgnoreCase("飞船配方主页")) {
            event.setCancelled(true);
        }
        if (event.getView().getTitle().contains("飞船模块配方 - ")) {
            ItemStack itemStack1 = new ItemStack(Materials.sign);
            ItemMeta itemMeta1 = itemStack1.getItemMeta();
            itemMeta1.setDisplayName("§9§l返回§r主页");
            itemStack1.setItemMeta(itemMeta1);
            if (event.getInventory().getItem(event.getRawSlot()).equals(itemStack1)) {
                Loader.run((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
    }
}

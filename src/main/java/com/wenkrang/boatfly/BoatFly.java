package com.wenkrang.boatfly;

import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.command.bf;
import com.wenkrang.boatfly.event.GUI.*;
import com.wenkrang.boatfly.event.GUI.book.Click;
import com.wenkrang.boatfly.event.GUI.book.PlayerInteract;
import com.wenkrang.boatfly.event.PlayerItemHeld;
import com.wenkrang.boatfly.event.PlayerSwapHandItems;
import com.wenkrang.boatfly.event.VehicleEnter;
import com.wenkrang.boatfly.event.VehicleExit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public final class BoatFly extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("bf")).setExecutor(new bf());
        getServer().getPluginManager().registerEvents(new VehicleExit(), this);
        getServer().getPluginManager().registerEvents(new Exit(), this);
        getServer().getPluginManager().registerEvents(new PlayerItemHeld(), this);
        getServer().getPluginManager().registerEvents(new OnEng(), this);
        getServer().getPluginManager().registerEvents(new VehicleEnter(), this);
        getServer().getPluginManager().registerEvents(new KickEntity(), this);
        getServer().getPluginManager().registerEvents(new CouldPut(), this);
        getServer().getPluginManager().registerEvents(new PutCaol(), this);
        getServer().getPluginManager().registerEvents(new FireSafe(), this);
        getServer().getPluginManager().registerEvents(new PlayerSwapHandItems(), this);
        getServer().getPluginManager().registerEvents(new AF(), this);
        getServer().getPluginManager().registerEvents(new InventoryClose(), this);
        getServer().getPluginManager().registerEvents(new Click(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);

        if (true) {
            ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            ItemMeta itemMeta0 = itemStack0.getItemMeta();
            itemMeta0.setDisplayName(" ");
            itemStack0.setItemMeta(itemMeta0);
            ItemStack itemStack1 = new ItemStack(Material.OAK_SIGN);
            ItemMeta itemMeta1 = itemStack1.getItemMeta();
            itemMeta1.setDisplayName("§9§l返回§r主页");
            itemStack1.setItemMeta(itemMeta1);
            ItemStack itemStack2 = new ItemStack(Material.CONDUIT);
            ItemMeta itemMeta2 = itemStack2.getItemMeta();
            itemStack2.setItemMeta(itemMeta2);
            ItemStack itemStack3 = new ItemStack(Material.BEACON);
            ItemMeta itemMeta3 = itemStack3.getItemMeta();
            itemStack3.setItemMeta(itemMeta3);
            ItemStack itemStack4 = new ItemStack(Material.END_CRYSTAL);
            ItemMeta itemMeta4 = itemStack4.getItemMeta();
            itemStack4.setItemMeta(itemMeta4);
            ItemStack itemStack5 = new ItemStack(Material.CRAFTING_TABLE);
            ItemMeta itemMeta5 = itemStack5.getItemMeta();
            itemMeta5.setDisplayName("§9§l工作台§r合成");
            ArrayList<String> lore5 = new ArrayList<>();
            lore5.add("§7该物品使用§7§l工作台§7合成，请");
            lore5.add("§7按照配方§7§l§n有序合成");
            itemMeta5.setLore(lore5);
            itemStack5.setItemMeta(itemMeta5);
            ItemStack itemStack6 = new ItemStack(Material.SADDLE);
            ItemMeta itemMeta6 = itemStack6.getItemMeta();
            itemStack6.setItemMeta(itemMeta6);
            ItemStack itemStack7 = new ItemStack(Material.BEEHIVE);
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
            itemStack9.setItemMeta(itemMeta9);
            ItemStack itemStack10 = new ItemStack(Material.NETHERITE_INGOT);
            ItemMeta itemMeta10 = itemStack10.getItemMeta();
            itemStack10.setItemMeta(itemMeta10);
            ItemStack itemStack11 = new ItemStack(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
            ItemMeta itemMeta11 = itemStack11.getItemMeta();
            itemStack11.setItemMeta(itemMeta11);

            NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "BoatFly");
            ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack9).shape("qwe","rty","uiu")
                    .setIngredient('q', new RecipeChoice.ExactChoice(itemStack2))
                    .setIngredient('w', new RecipeChoice.ExactChoice(itemStack3))
                    .setIngredient('e', new RecipeChoice.ExactChoice(itemStack4))
                    .setIngredient('r', new RecipeChoice.ExactChoice(itemStack6))
                    .setIngredient('t', new RecipeChoice.ExactChoice(itemStack7))
                    .setIngredient('y', new RecipeChoice.ExactChoice(itemStack8))
                    .setIngredient('i', new RecipeChoice.ExactChoice(itemStack11))
                    .setIngredient('u', new RecipeChoice.ExactChoice(itemStack10));
            getServer().addRecipe(shapedRecipe);
        }
        if (true) {
            ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            ItemMeta itemMeta0 = itemStack0.getItemMeta();
            itemMeta0.setDisplayName(" ");
            itemStack0.setItemMeta(itemMeta0);
            ItemStack itemStack1 = new ItemStack(Material.OAK_SIGN);
            ItemMeta itemMeta1 = itemStack1.getItemMeta();
            itemMeta1.setDisplayName("§9§l返回§r主页");
            itemStack1.setItemMeta(itemMeta1);
            ItemStack itemStack2 = new ItemStack(Material.CONDUIT);
            ItemMeta itemMeta2 = itemStack2.getItemMeta();
            itemStack2.setItemMeta(itemMeta2);
            ItemStack itemStack3 = new ItemStack(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
            ItemMeta itemMeta3 = itemStack3.getItemMeta();
            itemStack3.setItemMeta(itemMeta3);
            ItemStack itemStack4 = new ItemStack(Material.END_CRYSTAL);
            ItemMeta itemMeta4 = itemStack4.getItemMeta();
            itemStack4.setItemMeta(itemMeta4);
            ItemStack itemStack5 = new ItemStack(Material.CRAFTING_TABLE);
            ItemMeta itemMeta5 = itemStack5.getItemMeta();
            itemMeta5.setDisplayName("§9§l工作台§r合成");
            ArrayList<String> lore5 = new ArrayList<>();
            lore5.add("§7该物品使用§7§l工作台§7合成，请");
            lore5.add("§7按照配方§7§l§n有序合成");
            itemMeta5.setLore(lore5);
            itemStack5.setItemMeta(itemMeta5);
            ItemStack itemStack6 = new ItemStack(Material.FURNACE);
            ItemMeta itemMeta6 = itemStack6.getItemMeta();
            itemStack6.setItemMeta(itemMeta6);
            ItemStack itemStack7 = new ItemStack(Material.BLAST_FURNACE);
            ItemMeta itemMeta7 = itemStack7.getItemMeta();
            itemStack7.setItemMeta(itemMeta7);
            ItemStack itemStack8 = new ItemStack(Material.BEEHIVE);
            ItemMeta itemMeta8 = itemStack8.getItemMeta();
            itemMeta8.setDisplayName("§9§l发动机§r模块");
            ArrayList<String> lore8 = new ArrayList<>();
            lore8.add("§7这是飞船的§7§l发动机模块§7,是整个飞船§7§l§n最重要§7的");
            lore8.add("§7模块，用§7§l强大的材料§7制成");
            itemMeta8.setLore(lore8);
            itemStack8.setItemMeta(itemMeta8);
            ItemStack itemStack9 = new ItemStack(Material.NETHERITE_BLOCK);
            ItemMeta itemMeta9 = itemStack9.getItemMeta();
            itemStack9.setItemMeta(itemMeta9);
            ItemStack itemStack10 = new ItemStack(Material.NETHER_STAR);
            ItemMeta itemMeta10 = itemStack10.getItemMeta();
            itemStack10.setItemMeta(itemMeta10);

            NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "Boost");
            ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack8)
                    .shape("qwe","rty","uiu")
                    .setIngredient('q', new RecipeChoice.ExactChoice(itemStack2))
                    .setIngredient('w', new RecipeChoice.ExactChoice(itemStack3))
                    .setIngredient('e', new RecipeChoice.ExactChoice(itemStack4))
                    .setIngredient('r', new RecipeChoice.ExactChoice(itemStack6))
                    .setIngredient('t', new RecipeChoice.ExactChoice(itemStack7))
                    .setIngredient('y', new RecipeChoice.ExactChoice(itemStack6))
                    .setIngredient('u', new RecipeChoice.ExactChoice(itemStack9))
                    .setIngredient('i', new RecipeChoice.ExactChoice(itemStack10));
            getServer().addRecipe(shapedRecipe);
        }
        if (true) {
            ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            ItemMeta itemMeta0 = itemStack0.getItemMeta();
            itemMeta0.setDisplayName(" ");
            itemStack0.setItemMeta(itemMeta0);
            ItemStack itemStack1 = new ItemStack(Material.OAK_SIGN);
            ItemMeta itemMeta1 = itemStack1.getItemMeta();
            itemMeta1.setDisplayName("§9§l返回§r主页");
            itemStack1.setItemMeta(itemMeta1);
            ItemStack itemStack2 = new ItemStack(Material.END_CRYSTAL);
            ItemMeta itemMeta2 = itemStack2.getItemMeta();
            itemStack2.setItemMeta(itemMeta2);
            ItemStack itemStack3 = new ItemStack(Material.NETHER_STAR);
            ItemMeta itemMeta3 = itemStack3.getItemMeta();
            itemStack3.setItemMeta(itemMeta3);
            ItemStack itemStack4 = new ItemStack(Material.TARGET);
            ItemMeta itemMeta4 = itemStack4.getItemMeta();
            itemStack4.setItemMeta(itemMeta4);
            ItemStack itemStack5 = new ItemStack(Material.CRAFTING_TABLE);
            ItemMeta itemMeta5 = itemStack5.getItemMeta();
            itemMeta5.setDisplayName("§9§l工作台§r合成");
            ArrayList<String> lore5 = new ArrayList<>();
            lore5.add("§7该物品使用§7§l工作台§7合成，请");
            lore5.add("§7按照配方§7§l§n有序合成");
            itemMeta5.setLore(lore5);
            itemStack5.setItemMeta(itemMeta5);
            ItemStack itemStack6 = new ItemStack(Material.OBSERVER);
            ItemMeta itemMeta6 = itemStack6.getItemMeta();
            itemStack6.setItemMeta(itemMeta6);
            ItemStack itemStack7 = new ItemStack(Material.NETHERITE_SWORD);
            ItemMeta itemMeta7 = itemStack7.getItemMeta();
            itemStack7.setItemMeta(itemMeta7);
            ItemStack itemStack8 = new ItemStack(Material.DISPENSER);
            ItemMeta itemMeta8 = itemStack8.getItemMeta();
            itemMeta8.setDisplayName("§c§l攻击§r模块");
            ArrayList<String> lore8 = new ArrayList<>();
            lore8.add("§7飞机的攻击模块，可以发射");
            lore8.add("§7TNT和弓箭");
            itemMeta8.setLore(lore8);
            itemStack8.setItemMeta(itemMeta8);
            ItemStack itemStack9 = new ItemStack(Material.NETHERITE_BLOCK);
            ItemMeta itemMeta9 = itemStack9.getItemMeta();
            itemStack9.setItemMeta(itemMeta9);
            ItemStack itemStack10 = new ItemStack(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
            ItemMeta itemMeta10 = itemStack10.getItemMeta();
            itemStack10.setItemMeta(itemMeta10);
            ItemStack itemStack11 = new ItemStack(Material.DISPENSER);
            ItemMeta itemMeta11 = itemStack11.getItemMeta();
            itemStack11.setItemMeta(itemMeta11);

            NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "Damager");
            ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack8)
                    .shape("qwe","rty","uiu")
                    .setIngredient('q', new RecipeChoice.ExactChoice(itemStack2))
                    .setIngredient('w', new RecipeChoice.ExactChoice(itemStack3))
                    .setIngredient('e', new RecipeChoice.ExactChoice(itemStack4))
                    .setIngredient('r', new RecipeChoice.ExactChoice(itemStack6))
                    .setIngredient('t', new RecipeChoice.ExactChoice(itemStack7))
                    .setIngredient('y', new RecipeChoice.ExactChoice(itemStack11))
                    .setIngredient('u', new RecipeChoice.ExactChoice(itemStack9))
                    .setIngredient('i', new RecipeChoice.ExactChoice(itemStack10));
            getServer().addRecipe(shapedRecipe);
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
    }
}

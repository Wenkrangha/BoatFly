package com.wenkrang.boatfly.loader;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.lib.ConsoleLogger;
import com.wenkrang.boatfly.lib.Materials;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static com.wenkrang.boatfly.data.MainData.keys;
import static org.bukkit.Bukkit.getServer;

public class LoadRecipe {
    public static void run() {
        //加载配方的函数
        getServer().getConsoleSender().sendMessage("§9§l[*] §r正在加载配方...");
        try {
            //"if (true)"是用来隔离的，防止变量名重复
            if (true) {
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Materials.sign);
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
                //命名空间
                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "TheBoatFly");
                keys.add(namespacedKey);
                //配方
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack9).shape("qwe", "rty", "uiu")
                        .setIngredient('q', ItemChoice.exactChoice(itemStack2))
                        .setIngredient('w', ItemChoice.exactChoice(itemStack3))
                        .setIngredient('e', ItemChoice.exactChoice(itemStack4))
                        .setIngredient('r', ItemChoice.exactChoice(itemStack6))
                        .setIngredient('t', Materials.beeHive)
                        .setIngredient('y', Material.DISPENSER)
                        .setIngredient('i', ItemChoice.exactChoice(itemStack11))
                        .setIngredient('u', ItemChoice.exactChoice(itemStack10));
                //注册配方
                getServer().addRecipe(shapedRecipe);
            }
            //下面的作用同上
            if (true) {
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Materials.sign);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l返回§r主页");
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Material.CONDUIT);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.REDSTONE);
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
                ItemStack itemStack7 = new ItemStack(Materials.blastFurnace);
                ItemMeta itemMeta7 = itemStack7.getItemMeta();
                itemStack7.setItemMeta(itemMeta7);
                ItemStack itemStack8 = new ItemStack(Materials.beeHive);
                ItemMeta itemMeta8 = itemStack8.getItemMeta();
                itemMeta8.setDisplayName("§9§l发动机§r模块");
                ArrayList<String> lore8 = new ArrayList<>();
                lore8.add("§7这是飞船的§7§l发动机模块§7,是整个飞船§7§l§n最重要§7的");
                lore8.add("§7模块，用§7§l强大的材料§7制成");
                itemMeta8.setLore(lore8);
                itemStack8.setItemMeta(itemMeta8);
                ItemStack itemStack9 = new ItemStack(Material.DIAMOND_BLOCK);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemStack9.setItemMeta(itemMeta9);
                ItemStack itemStack10 = new ItemStack(Material.NETHER_STAR);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemStack10.setItemMeta(itemMeta10);

                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "Boost");
                keys.add(namespacedKey);
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack8)
                        .shape("qwe", "rty", "uiu")
                        .setIngredient('q', ItemChoice.exactChoice(itemStack2))
                        .setIngredient('w', ItemChoice.exactChoice(itemStack3))
                        .setIngredient('e', ItemChoice.exactChoice(itemStack4))
                        .setIngredient('r', ItemChoice.exactChoice(itemStack6))
                        .setIngredient('t', ItemChoice.exactChoice(itemStack7))
                        .setIngredient('y', ItemChoice.exactChoice(itemStack6))
                        .setIngredient('u', ItemChoice.exactChoice(itemStack9))
                        .setIngredient('i', ItemChoice.exactChoice(itemStack10));
                getServer().addRecipe(shapedRecipe);
            }
            if (true) {
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Materials.sign);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l返回§r主页");
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Material.END_CRYSTAL);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.NETHER_STAR);
                ItemMeta itemMeta3 = itemStack3.getItemMeta();
                itemStack3.setItemMeta(itemMeta3);
                ItemStack itemStack4 = new ItemStack(Materials.target);
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
                ItemStack itemStack7 = new ItemStack(Materials.netheriteSword);
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
                ItemStack itemStack9 = new ItemStack(Material.DIAMOND_BLOCK);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemStack9.setItemMeta(itemMeta9);
                ItemStack itemStack10 = new ItemStack(Material.REDSTONE);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemStack10.setItemMeta(itemMeta10);

                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "Damager");
                keys.add(namespacedKey);
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack8)
                        .shape("qwe", "rty", "uiu")
                        .setIngredient('q', ItemChoice.exactChoice(itemStack2))
                        .setIngredient('w', ItemChoice.exactChoice(itemStack3))
                        .setIngredient('e', ItemChoice.exactChoice(itemStack4))
                        .setIngredient('r', ItemChoice.exactChoice(itemStack6))
                        .setIngredient('t', ItemChoice.exactChoice(itemStack7))
                        .setIngredient('y', ItemChoice.exactChoice(new ItemStack(Material.DISPENSER, 1)))
                        .setIngredient('u', ItemChoice.exactChoice(itemStack9))
                        .setIngredient('i', ItemChoice.exactChoice(itemStack10));
                getServer().addRecipe(shapedRecipe);

            }
            if (true) {
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Materials.sign);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l返回§r主页");
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Material.SHULKER_SHELL);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.IRON_TRAPDOOR);
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
                ItemStack itemStack5 = new ItemStack(Materials.honeyBlock);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemStack5.setItemMeta(itemMeta5);
                ItemStack itemStack6 = new ItemStack(Material.CHEST);
                ItemMeta itemMeta6 = itemStack6.getItemMeta();
                itemStack6.setItemMeta(itemMeta6);
                ItemStack itemStack7 = new ItemStack(Material.SLIME_BLOCK);
                ItemMeta itemMeta7 = itemStack7.getItemMeta();
                itemStack7.setItemMeta(itemMeta7);
                ItemStack itemStack8 = new ItemStack(Material.CHEST);
                ItemMeta itemMeta8 = itemStack8.getItemMeta();
                itemMeta8.setDisplayName("§9§l货运§r箱子");
                ArrayList<String> lore8 = new ArrayList<>();
                lore8.add("§7这是专门用于§7§l货运飞船§7的箱子，虽然看起来一样，");
                lore8.add("§7但实际上就是§7§l一样§7的（");
                itemMeta8.setLore(lore8);
                itemStack8.setItemMeta(itemMeta8);
                ItemStack itemStack9 = new ItemStack(Materials.netheriteIngot);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemStack9.setItemMeta(itemMeta9);
                ItemStack itemStack10 = new ItemStack(Material.CAULDRON);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemStack10.setItemMeta(itemMeta10);
                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "superchest");
                keys.add(namespacedKey);
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey,itemStack8)
                        .shape("qwq","ert","yuy")
                        .setIngredient('q', ItemChoice.exactChoice(itemStack2))
                        .setIngredient('w', ItemChoice.exactChoice(itemStack3))
                        .setIngredient('e', ItemChoice.exactChoice(itemStack5))
                        .setIngredient('r', ItemChoice.exactChoice(itemStack6))
                        .setIngredient('t', ItemChoice.exactChoice(itemStack7))
                        .setIngredient('y', ItemChoice.exactChoice(itemStack9))
                        .setIngredient('u', ItemChoice.exactChoice(itemStack10));
                getServer().addRecipe(shapedRecipe);
            }
            if (true) {
                Inventory inventory = Bukkit.createInventory(null, 27, "飞船配方-货运飞船");
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Materials.sign);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l返回§r主页");
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Material.CHEST);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemMeta2.setDisplayName("§9§l货运§r箱子");
                ArrayList<String> lore2 = new ArrayList<>();
                lore2.add("§7这是专门用于§7§l货运飞船§7的箱子，虽然看起来一样，");
                lore2.add("§7但实际上就是§7§l一样§7的（");
                itemMeta2.setLore(lore2);
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta itemMeta3 = itemStack3.getItemMeta();
                itemMeta3.setDisplayName("§9§l工作台§r合成");
                ArrayList<String> lore3 = new ArrayList<>();
                lore3.add("§7该物品使用§7§l工作台§7合成，请");
                lore3.add("§7按照配方§7§l§n有序合成");
                itemMeta3.setLore(lore3);
                itemStack3.setItemMeta(itemMeta3);
                ItemStack itemStack4 = new ItemStack(Materials.chestBoat);
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
                ItemStack itemStack5 = new ItemStack(Materials.campfire);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemStack5.setItemMeta(itemMeta5);
                ItemStack itemStack6 = new ItemStack(Materials.netheriteIngot);
                ItemMeta itemMeta6 = itemStack6.getItemMeta();
                itemStack6.setItemMeta(itemMeta6);
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
                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "boatchest");
                keys.add(namespacedKey);
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack4)
                        .shape(" q "," w ","ere")
                        .setIngredient('q', ItemChoice.exactChoice(itemStack2))
                        .setIngredient('w', ItemChoice.exactChoice(itemStack9))
                        .setIngredient('e', ItemChoice.exactChoice(itemStack5))
                        .setIngredient('r', ItemChoice.exactChoice(itemStack6));
                getServer().addRecipe(shapedRecipe);
            }
            if (true) {
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Materials.sign);
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
                ItemStack itemStack7 = new ItemStack(Materials.beeHive);
                ItemMeta itemMeta7 = itemStack7.getItemMeta();
                itemMeta7.setDisplayName("§9§l发动机§r模块");
                ArrayList<String> lore7 = new ArrayList<>();
                lore7.add("§7这是飞船的§7§l发动机模块§7,是整个飞船§7§l§n最重要§7的");
                lore7.add("§7模块，用§7§l强大的材料§7制成");
                itemMeta7.setLore(lore7);
                itemStack7.setItemMeta(itemMeta7);
                ItemStack itemStack8 = new ItemStack(Material.GLASS);
                ItemStack itemStack9 = new ItemStack(Material.OAK_BOAT);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemMeta9.setDisplayName("§9§l客运§r飞船");
                ArrayList<String> lore9 = new ArrayList<>();
                lore9.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
                lore9.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
                lore9.add("§7由地去探索这个§7§l世界");
                lore9.add("§7这艘船没有攻击模块，而且造价更低");
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

                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "TheLowBoatFly");
                keys.add(namespacedKey);
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack9).shape("   ", "rty", "uiu")
                        .setIngredient('r', ItemChoice.exactChoice(itemStack6))
                        .setIngredient('t', ItemChoice.exactChoice(itemStack7))
                        .setIngredient('y', ItemChoice.exactChoice(itemStack8))
                        .setIngredient('i', ItemChoice.exactChoice(itemStack11))
                        .setIngredient('u', ItemChoice.exactChoice(itemStack10));
                getServer().addRecipe(shapedRecipe);
            }


            if (true) {
                ItemStack itemStack0 = new ItemStack(Materials.netheriteScrap);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Material.ANVIL);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Materials.grindstone);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Materials.smithingTable);
                ItemMeta itemMeta3 = itemStack3.getItemMeta();
                itemStack3.setItemMeta(itemMeta3);
                ItemStack itemStack4 = new ItemStack(Material.DROPPER);
                ItemMeta itemMeta4 = itemStack4.getItemMeta();
                itemMeta4.setDisplayName("§9§l航空§r装配台");
                ArrayList<String> lore4 = new ArrayList<>();
                lore4.add("§7你可以在这里§7§l装配§7你的飞机，将§7§l§n不同的模块");
                lore4.add("§7§l§o装配到上面§7，以加强它的性能");
                lore4.add("");
                lore4.add("§6§l右键§6打开装配面包");
                itemMeta4.setLore(lore4);
                itemStack4.setItemMeta(itemMeta4);
                ItemStack itemStack5 = new ItemStack(Material.STONE);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemStack5.setItemMeta(itemMeta5);

                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "Tflytable");
                keys.add(namespacedKey);
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack4);
                shapedRecipe.shape("qwe", "rty", "uio");
                shapedRecipe.setIngredient('q', ItemChoice.exactChoice(itemStack0));
                shapedRecipe.setIngredient('w', ItemChoice.exactChoice(itemStack0));
                shapedRecipe.setIngredient('e', ItemChoice.exactChoice(itemStack0));
                shapedRecipe.setIngredient('r', ItemChoice.exactChoice(itemStack1));
                shapedRecipe.setIngredient('t', ItemChoice.exactChoice(itemStack2));
                shapedRecipe.setIngredient('y', ItemChoice.exactChoice(itemStack3));
                shapedRecipe.setIngredient('u', ItemChoice.exactChoice(itemStack5));
                shapedRecipe.setIngredient('i', ItemChoice.exactChoice(itemStack5));
                shapedRecipe.setIngredient('o', ItemChoice.exactChoice(itemStack5));
                getServer().addRecipe(shapedRecipe);
            }

            if (true) {
                ItemStack itemStack0 = new ItemStack(Material.SADDLE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Material.CLOCK);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l仪表§r盘");
                ArrayList<String> lore1 = new ArrayList<>();
                lore1.add("§7这是§7§l§o飞机的仪表盘§7，用来查看§7§l飞机§7的各个");
                lore1.add("§7参数，对飞机来说是§7§l§n非常重要§7的东西");
                itemMeta1.setLore(lore1);
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Material.COMPARATOR);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.OAK_BOAT);
                ItemMeta itemMeta3 = itemStack3.getItemMeta();
                itemMeta3.setDisplayName("§9§l空白§r飞船");
                ArrayList<String> lore3 = new ArrayList<>();
                lore3.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
                lore3.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
                lore3.add("§7由地去探索这个§7§l世界");
                lore3.add("");
                lore3.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
                itemMeta3.setLore(lore3);
                itemStack3.setItemMeta(itemMeta3);
                ItemStack itemStack4 = new ItemStack(Materials.netheriteIngot);
                ItemMeta itemMeta4 = itemStack4.getItemMeta();
                itemStack4.setItemMeta(itemMeta4);
                ItemStack itemStack5 = new ItemStack(Material.REDSTONE);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemStack5.setItemMeta(itemMeta5);
                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "TTheRawBoat");
                keys.add(namespacedKey);
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack3);
                shapedRecipe.shape("   ", "rty", "uio");
                shapedRecipe.setIngredient('r', ItemChoice.exactChoice(itemStack0));
                shapedRecipe.setIngredient('t', ItemChoice.exactChoice(itemStack1));
                shapedRecipe.setIngredient('y', ItemChoice.exactChoice(itemStack2));
                shapedRecipe.setIngredient('u', ItemChoice.exactChoice(itemStack4));
                shapedRecipe.setIngredient('i', ItemChoice.exactChoice(itemStack5));
                shapedRecipe.setIngredient('o', ItemChoice.exactChoice(itemStack4));
                getServer().addRecipe(shapedRecipe);

            }

            if (true) {
                Inventory inventory = Bukkit.createInventory(null, 27, "飞船配方-客运飞船");
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Materials.sign);
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
                ItemStack itemStack11 = new ItemStack(Material.CLOCK);
                ItemStack itemStack12 = new ItemStack(Material.REDSTONE);

                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "Finder");
                keys.add(namespacedKey);
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack10);
                shapedRecipe.shape("   ", " t ", " i ");
                shapedRecipe.setIngredient('t', ItemChoice.exactChoice(itemStack11));
                shapedRecipe.setIngredient('i', ItemChoice.exactChoice(itemStack12));
                getServer().addRecipe(shapedRecipe);
            }


        } catch (Exception e) {}

//        try {
//            for (Recipe recipe : BookAPI.recipes) {
//                getServer().addRecipe(recipe.shapedRecipe);
//            }
//        }catch (Exception e) {}
//自动测试
    }

    // 1.13.1兼容
    public static class ItemChoice implements RecipeChoice {

        public ItemChoice(ItemStack itemStack) {
            super();
            this.itemStack = itemStack;
        }

        private final ItemStack itemStack;

        @NotNull
        @Override
        public ItemStack getItemStack() {
            return itemStack;
        }

        @NotNull
        @Override
        public ItemChoice clone() {
            try {
                return (ItemChoice) super.clone();
            } catch (CloneNotSupportedException e) {
                ConsoleLogger.error(e);
                throw new RuntimeException(e);
            }
        }

        @Override
        public boolean test(@NotNull ItemStack itemStack) {
            return true;
        }

        public static RecipeChoice exactChoice(ItemStack itemStack) {
            try {
                return new ExactChoice(itemStack);
            } catch (NoClassDefFoundError e) {
                return new ItemChoice(itemStack);
            }
        }
    }
}

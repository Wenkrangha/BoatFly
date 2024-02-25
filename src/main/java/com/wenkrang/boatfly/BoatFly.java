package com.wenkrang.boatfly;

import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.command.bf;
import com.wenkrang.boatfly.event.*;
import com.wenkrang.boatfly.event.GUI.*;
import com.wenkrang.boatfly.event.GUI.book.Click;
import com.wenkrang.boatfly.event.GUI.book.Click2;
import com.wenkrang.boatfly.event.GUI.book.PlayerInteract;
import com.wenkrang.boatfly.event.GUI.table.OpenTable;
import com.wenkrang.boatfly.event.GUI.table.TableCouldPut;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
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
        getServer().getConsoleSender().sendMessage("    ____              __  ________     ");
        getServer().getConsoleSender().sendMessage("   / __ )____  ____ _/ /_/ ____/ /_  __");
        getServer().getConsoleSender().sendMessage("  / __  / __ \\/ __ `/ __/ /_  / / / / /");
        getServer().getConsoleSender().sendMessage(" / /_/ / /_/ / /_/ / /_/ __/ / / /_/ / ");
        getServer().getConsoleSender().sendMessage("/_____/\\____/\\__,_/\\__/_/   /_/\\__, /  ");
        getServer().getConsoleSender().sendMessage("                              /____/   ");
        getServer().getConsoleSender().sendMessage("§9§l[*] §r正在注入命令...");
        Objects.requireNonNull(this.getCommand("bf")).setExecutor(new bf());
        getServer().getConsoleSender().sendMessage("§9§l[*] §r正在加载监听器...");
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
        getServer().getPluginManager().registerEvents(new VehicleDestroy(), this);
//        getServer().getPluginManager().registerEvents(new OpenTable(), this);
//        getServer().getPluginManager().registerEvents(new TableCouldPut(), this);
//        getServer().getPluginManager().registerEvents(new Click2(), this);
        getServer().getConsoleSender().sendMessage("§9§l[*] §r正在加载配方...");
        try {
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
                ArrayList<String> lore9 = new ArrayList<>();
                lore9.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
                lore9.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
                lore9.add("§7由地去探索这个§7§l世界");
                lore9.add("");
                lore9.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
                lore9.add("§6在§6§l船上§6,按§f§l§o§nShift§6打开面板");
                itemMeta9.setLore(lore9);
                itemStack9.setItemMeta(itemMeta9);
                ItemStack itemStack10 = new ItemStack(Material.NETHERITE_INGOT);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemStack10.setItemMeta(itemMeta10);
                ItemStack itemStack11 = new ItemStack(Material.REDSTONE);
                ItemMeta itemMeta11 = itemStack11.getItemMeta();
                itemStack11.setItemMeta(itemMeta11);

                NamespacedKey namespacedKey = new NamespacedKey(this, "TheBoatFly");
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack9).shape("qwe", "rty", "uiu")
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
                ItemStack itemStack9 = new ItemStack(Material.DIAMOND_BLOCK);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemStack9.setItemMeta(itemMeta9);
                ItemStack itemStack10 = new ItemStack(Material.NETHER_STAR);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemStack10.setItemMeta(itemMeta10);

                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "Boost");
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack8)
                        .shape("qwe", "rty", "uiu")
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
                ItemStack itemStack9 = new ItemStack(Material.DIAMOND_BLOCK);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemStack9.setItemMeta(itemMeta9);
                ItemStack itemStack10 = new ItemStack(Material.REDSTONE);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemStack10.setItemMeta(itemMeta10);

                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "Damager");
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack8)
                        .shape("qwe", "rty", "uiu")
                        .setIngredient('q', new RecipeChoice.ExactChoice(itemStack2))
                        .setIngredient('w', new RecipeChoice.ExactChoice(itemStack3))
                        .setIngredient('e', new RecipeChoice.ExactChoice(itemStack4))
                        .setIngredient('r', new RecipeChoice.ExactChoice(itemStack6))
                        .setIngredient('t', new RecipeChoice.ExactChoice(itemStack7))
                        .setIngredient('y', new RecipeChoice.ExactChoice(new ItemStack(Material.DISPENSER, 1)))
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
                ItemStack itemStack5 = new ItemStack(Material.HONEY_BLOCK);
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
                ItemStack itemStack9 = new ItemStack(Material.NETHERITE_INGOT);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemStack9.setItemMeta(itemMeta9);
                ItemStack itemStack10 = new ItemStack(Material.CAULDRON);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemStack10.setItemMeta(itemMeta10);
                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "superchest");
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey,itemStack8)
                        .shape("qwq","ert","yuy")
                        .setIngredient('q', new RecipeChoice.ExactChoice(itemStack2))
                        .setIngredient('w', new RecipeChoice.ExactChoice(itemStack3))
                        .setIngredient('e', new RecipeChoice.ExactChoice(itemStack5))
                        .setIngredient('r', new RecipeChoice.ExactChoice(itemStack6))
                        .setIngredient('t', new RecipeChoice.ExactChoice(itemStack7))
                        .setIngredient('y', new RecipeChoice.ExactChoice(itemStack9))
                        .setIngredient('u', new RecipeChoice.ExactChoice(itemStack10));
                getServer().addRecipe(shapedRecipe);
            }
            if (true) {
                Inventory inventory = Bukkit.createInventory(null, 27, "飞船配方-货运飞船");
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Material.OAK_SIGN);
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
                ItemStack itemStack5 = new ItemStack(Material.CAMPFIRE);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemStack5.setItemMeta(itemMeta5);
                ItemStack itemStack6 = new ItemStack(Material.NETHERITE_INGOT);
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
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack4)
                        .shape(" q "," w ","ere")
                        .setIngredient('q', new RecipeChoice.ExactChoice(itemStack2))
                        .setIngredient('w', new RecipeChoice.ExactChoice(itemStack9))
                        .setIngredient('e', new RecipeChoice.ExactChoice(itemStack5))
                        .setIngredient('r', new RecipeChoice.ExactChoice(itemStack6));
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
                ItemStack itemStack10 = new ItemStack(Material.NETHERITE_INGOT);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemStack10.setItemMeta(itemMeta10);
                ItemStack itemStack11 = new ItemStack(Material.REDSTONE);
                ItemMeta itemMeta11 = itemStack11.getItemMeta();
                itemStack11.setItemMeta(itemMeta11);

                NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), "TheLowBoatFly");
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack9).shape("   ", "rty", "uiu")
                        .setIngredient('r', new RecipeChoice.ExactChoice(itemStack6))
                        .setIngredient('t', new RecipeChoice.ExactChoice(itemStack7))
                        .setIngredient('y', new RecipeChoice.ExactChoice(itemStack8))
                        .setIngredient('i', new RecipeChoice.ExactChoice(itemStack11))
                        .setIngredient('u', new RecipeChoice.ExactChoice(itemStack10));
                getServer().addRecipe(shapedRecipe);
            }
//
//
//            if (true) {
//                ItemStack itemStack0 = new ItemStack(Material.NETHERITE_SCRAP);
//                ItemMeta itemMeta0 = itemStack0.getItemMeta();
//                itemStack0.setItemMeta(itemMeta0);
//                ItemStack itemStack1 = new ItemStack(Material.ANVIL);
//                ItemMeta itemMeta1 = itemStack1.getItemMeta();
//                itemStack1.setItemMeta(itemMeta1);
//                ItemStack itemStack2 = new ItemStack(Material.GRINDSTONE);
//                ItemMeta itemMeta2 = itemStack2.getItemMeta();
//                itemStack2.setItemMeta(itemMeta2);
//                ItemStack itemStack3 = new ItemStack(Material.SMITHING_TABLE);
//                ItemMeta itemMeta3 = itemStack3.getItemMeta();
//                itemStack3.setItemMeta(itemMeta3);
//                ItemStack itemStack4 = new ItemStack(Material.DROPPER);
//                ItemMeta itemMeta4 = itemStack4.getItemMeta();
//                itemMeta4.setDisplayName("§9§l航空§r装配台");
//                ArrayList<String> lore4 = new ArrayList<>();
//                lore4.add("§7你可以在这里§7§l装配§7你的飞机，将§7§l§n不同的模块");
//                lore4.add("§7§l§o装配到上面§7，以加强它的性能");
//                lore4.add("");
//                lore4.add("§6§l右键§6打开装配面板");
//                itemMeta4.setLore(lore4);
//                itemStack4.setItemMeta(itemMeta4);
//                ItemStack itemStack5 = new ItemStack(Material.STONE);
//                ItemMeta itemMeta5 = itemStack5.getItemMeta();
//                itemStack5.setItemMeta(itemMeta5);
//
//                NamespacedKey namespacedKey = new NamespacedKey(this, "Tflytable");
//                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack4);
//                shapedRecipe.shape("qwe", "rty", "uio");
//                shapedRecipe.setIngredient('q', new RecipeChoice.ExactChoice(itemStack0));
//                shapedRecipe.setIngredient('w', new RecipeChoice.ExactChoice(itemStack0));
//                shapedRecipe.setIngredient('e', new RecipeChoice.ExactChoice(itemStack0));
//                shapedRecipe.setIngredient('r', new RecipeChoice.ExactChoice(itemStack1));
//                shapedRecipe.setIngredient('t', new RecipeChoice.ExactChoice(itemStack2));
//                shapedRecipe.setIngredient('y', new RecipeChoice.ExactChoice(itemStack3));
//                shapedRecipe.setIngredient('u', new RecipeChoice.ExactChoice(itemStack5));
//                shapedRecipe.setIngredient('i', new RecipeChoice.ExactChoice(itemStack5));
//                shapedRecipe.setIngredient('o', new RecipeChoice.ExactChoice(itemStack5));
//                getServer().addRecipe(shapedRecipe);
//            }
//            if (true) {
//                ItemStack itemStack0 = new ItemStack(Material.COMPARATOR);
//                ItemMeta itemMeta0 = itemStack0.getItemMeta();
//                itemStack0.setItemMeta(itemMeta0);
//                ItemStack itemStack1 = new ItemStack(Material.REDSTONE_LAMP);
//                ItemMeta itemMeta1 = itemStack1.getItemMeta();
//                itemStack1.setItemMeta(itemMeta1);
//                ItemStack itemStack2 = new ItemStack(Material.REDSTONE);
//                ItemMeta itemMeta2 = itemStack2.getItemMeta();
//                itemStack2.setItemMeta(itemMeta2);
//                ItemStack itemStack3 = new ItemStack(Material.CLOCK);
//                ItemMeta itemMeta3 = itemStack3.getItemMeta();
//                itemMeta3.setDisplayName("§9§l仪表§r盘");
//                ArrayList<String> lore3 = new ArrayList<>();
//                lore3.add("§7这是§7§l§o飞机的仪表盘§7，用来查看§7§l飞机§7的各个");
//                lore3.add("§7参数，对飞机来说是§7§l§n非常重要§7的东西");
//                itemMeta3.setLore(lore3);
//                itemStack3.setItemMeta(itemMeta3);
//                ItemStack itemStack4 = new ItemStack(Material.GOLD_INGOT);
//                ItemMeta itemMeta4 = itemStack4.getItemMeta();
//                itemStack4.setItemMeta(itemMeta4);
//                NamespacedKey namespacedKey = new NamespacedKey(this, "TTChecker");
//                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack3);
//                shapedRecipe.shape(" w ", "rty", "uio");
//                shapedRecipe.setIngredient('w', new RecipeChoice.ExactChoice(itemStack0));
//                shapedRecipe.setIngredient('r', new RecipeChoice.ExactChoice(itemStack1));
//                shapedRecipe.setIngredient('t', new RecipeChoice.ExactChoice(itemStack2));
//                shapedRecipe.setIngredient('y', new RecipeChoice.ExactChoice(itemStack1));
//                shapedRecipe.setIngredient('u', new RecipeChoice.ExactChoice(itemStack4));
//                shapedRecipe.setIngredient('i', new RecipeChoice.ExactChoice(itemStack4));
//                shapedRecipe.setIngredient('o', new RecipeChoice.ExactChoice(itemStack4));
//                getServer().addRecipe(shapedRecipe);
//
//            }
//            if (true) {
//                ItemStack itemStack0 = new ItemStack(Material.SADDLE);
//                ItemMeta itemMeta0 = itemStack0.getItemMeta();
//                itemStack0.setItemMeta(itemMeta0);
//                ItemStack itemStack1 = new ItemStack(Material.CLOCK);
//                ItemMeta itemMeta1 = itemStack1.getItemMeta();
//                itemMeta1.setDisplayName("§9§l仪表§r盘");
//                ArrayList<String> lore1 = new ArrayList<>();
//                lore1.add("§7这是§7§l§o飞机的仪表盘§7，用来查看§7§l飞机§7的各个");
//                lore1.add("§7参数，对飞机来说是§7§l§n非常重要§7的东西");
//                itemMeta1.setLore(lore1);
//                itemStack1.setItemMeta(itemMeta1);
//                ItemStack itemStack2 = new ItemStack(Material.COMPARATOR);
//                ItemMeta itemMeta2 = itemStack2.getItemMeta();
//                itemStack2.setItemMeta(itemMeta2);
//                ItemStack itemStack3 = new ItemStack(Material.OAK_BOAT);
//                ItemMeta itemMeta3 = itemStack3.getItemMeta();
//                itemMeta3.setDisplayName("§9§l空白§r飞船");
//                ArrayList<String> lore3 = new ArrayList<>();
//                lore3.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
//                lore3.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
//                lore3.add("§7由地去探索这个§7§l世界");
//                lore3.add("");
//                lore3.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
//                itemMeta3.setLore(lore3);
//                itemStack3.setItemMeta(itemMeta3);
//                ItemStack itemStack4 = new ItemStack(Material.NETHERITE_INGOT);
//                ItemMeta itemMeta4 = itemStack4.getItemMeta();
//                itemStack4.setItemMeta(itemMeta4);
//                ItemStack itemStack5 = new ItemStack(Material.REDSTONE);
//                ItemMeta itemMeta5 = itemStack5.getItemMeta();
//                itemStack5.setItemMeta(itemMeta5);
//                NamespacedKey namespacedKey = new NamespacedKey(this, "TTheRawBoat");
//                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack3);
//                shapedRecipe.shape("   ", "rty", "uio");
//                shapedRecipe.setIngredient('r', new RecipeChoice.ExactChoice(itemStack0));
//                shapedRecipe.setIngredient('t', new RecipeChoice.ExactChoice(itemStack1));
//                shapedRecipe.setIngredient('y', new RecipeChoice.ExactChoice(itemStack2));
//                shapedRecipe.setIngredient('u', new RecipeChoice.ExactChoice(itemStack4));
//                shapedRecipe.setIngredient('i', new RecipeChoice.ExactChoice(itemStack5));
//                shapedRecipe.setIngredient('o', new RecipeChoice.ExactChoice(itemStack4));
//                getServer().addRecipe(shapedRecipe);
//
//            }
            getServer().getConsoleSender().sendMessage("§9§l[*] §r加载完毕,当前版本 : 1.4");
        } catch (Exception e) {}
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
    }
}

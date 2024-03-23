package com.wenkrang.boatfly;

import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.Loader.LoadCommand;
import com.wenkrang.boatfly.Loader.LoadEvent;
import com.wenkrang.boatfly.Loader.LoadRecipe;
import com.wenkrang.boatfly.command.bf;
import com.wenkrang.boatfly.event.*;
import com.wenkrang.boatfly.event.GUI.*;
import com.wenkrang.boatfly.event.GUI.book.Click;
import com.wenkrang.boatfly.event.GUI.book.Click2;
import com.wenkrang.boatfly.event.GUI.book.PlayerInteract;
import com.wenkrang.boatfly.event.GUI.table.OpenTable;
import com.wenkrang.boatfly.event.GUI.table.TableCouldPut;
import com.wenkrang.boatfly.lib.ConsoleLoger;
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

import static org.bukkit.Bukkit.getServer;


public final class BoatFly extends JavaPlugin {
    public static ItemStack BOOK_ITEM;

    public static ItemStack REGULAR;

    public static ItemStack FREIGHT;

    public static ItemStack PASSENGER;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage("    ____              __  ________     ");
        getServer().getConsoleSender().sendMessage("   / __ )____  ____ _/ /_/ ____/ /_  __");
        getServer().getConsoleSender().sendMessage("  / __  / __ \\/ __ `/ __/ /_  / / / / /");
        getServer().getConsoleSender().sendMessage(" / /_/ / /_/ / /_/ / /_/ __/ / / /_/ / ");
        getServer().getConsoleSender().sendMessage("/_____/\\____/\\__,_/\\__/_/   /_/\\__, /  ");
        getServer().getConsoleSender().sendMessage("                              /____/   ");
        try {
            loadItem();
            LoadCommand.run();
            LoadEvent.run();
            LoadRecipe.run();
            if (PlayerInteract.isBelow1_20_2()) {
                ConsoleLoger.info("您的服务器版本低于1.20.2,部分功能可能无法正常使用");
            }
            getServer().getConsoleSender().sendMessage("§9§l[*] §r加载完毕,当前版本 : 1.5");
        } catch (Exception e) {}
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
        ConsoleLoger.info("正在关闭 BoatFly ...");
    }
    private void loadItem() {
        BOOK_ITEM = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta itemMeta0 = BOOK_ITEM.getItemMeta();
        itemMeta0.setDisplayName("§9§lBoatFly§r-飞船配方");
        ArrayList<String> lore0 = new ArrayList<>();
        lore0.add("§7这是关于飞船的配方，§7§m飞船可以让你上天");
        lore0.add("§7里面似乎蕴含着强大的力量♂");
        lore0.add("");
        lore0.add("§6§l右键§6打开");
        itemMeta0.setLore(lore0);
        BOOK_ITEM.setItemMeta(itemMeta0);

        REGULAR = new ItemStack(Material.OAK_BOAT);
        ItemMeta itemMeta9 = REGULAR.getItemMeta();
        itemMeta9.setDisplayName("§9§l飞§r船");
        ArrayList<String> lore9 = new ArrayList<>();
        lore9.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
        lore9.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
        lore9.add("§7由地去探索这个§7§l世界");
        lore9.add("");
        lore9.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
        lore9.add("§6在§6§l船上§6,按§f§l§o§nShift§6打开面板");
        itemMeta9.setLore(lore9);
        REGULAR.setItemMeta(itemMeta9);

        FREIGHT = new ItemStack(Material.OAK_CHEST_BOAT);
        ItemMeta itemMeta4 = FREIGHT.getItemMeta();
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
        FREIGHT.setItemMeta(itemMeta4);


        PASSENGER = new ItemStack(Material.OAK_BOAT);
        ItemMeta itemMeta10 = PASSENGER.getItemMeta();
        itemMeta10.setDisplayName("§9§l客运§r飞船");
        ArrayList<String> lore10 = new ArrayList<>();
        lore10.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
        lore10.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
        lore10.add("§7由地去探索这个§7§l世界");
        lore10.add("§7这艘船没有攻击模块，而且造价更低");
        lore10.add("");
        lore10.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
        lore10.add("§6在§6§l船上§6,按§f§l§o§nShift§6打开面板");
        itemMeta10.setLore(lore10);
        PASSENGER.setItemMeta(itemMeta10);
    }
}

package com.wenkrang.boatfly.event.GUI.book;

import com.wenkrang.boatfly.lib.Materials;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Main {
    public static void Show (Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "飞船配方主页");
        ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta itemMeta0 = itemStack0.getItemMeta();
        itemMeta0.setDisplayName(" ");
        itemStack0.setItemMeta(itemMeta0);
        ItemStack itemStack1 = new ItemStack(Material.COMPASS);
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§9§l飞机§r配方");
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§7这里是§7§l飞机配方§7的§7§l主页§7你可以在这里");
        lore1.add("§7查看所有§7§n飞机部件§7的配方");
        itemMeta1.setLore(lore1);
        itemStack1.setItemMeta(itemMeta1);
        ItemStack itemStack2 = new ItemStack(Material.OAK_BOAT);
        ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta2.setDisplayName("§9§l飞§r船");
        itemStack2.setItemMeta(itemMeta2);
        ItemStack itemStack3 = new ItemStack(Materials.beeHive);
        ItemMeta itemMeta3 = itemStack3.getItemMeta();
        itemMeta3.setDisplayName("§9§l发动机§r模块");
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("§7这是飞船的§7§l发动机模块§7,是整个飞船§7§l§n最重要§7的");
        lore3.add("§7模块，用§7§l强大的材料§7制成");
        itemMeta3.setLore(lore3);
        itemStack3.setItemMeta(itemMeta3);
        ItemStack itemStack4 = new ItemStack(Material.DISPENSER);
        ItemMeta itemMeta4 = itemStack4.getItemMeta();
        itemMeta4.setDisplayName("§c§l攻击§r模块");
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("§7飞机的攻击模块，可以发射");
        lore4.add("§7TNT和弓箭");
        itemMeta4.setLore(lore4);
        itemStack4.setItemMeta(itemMeta4);
        ItemStack itemStack8 = new ItemStack(Material.CHEST);
        ItemMeta itemMeta8 = itemStack8.getItemMeta();
        itemMeta8.setDisplayName("§9§l货运§r箱子");
        ArrayList<String> lore8 = new ArrayList<>();
        lore8.add("§7这是专门用于§7§l货运飞船§7的箱子，虽然看起来一样，");
        lore8.add("§7但实际上就是§7§l一样§7的（");
        itemMeta8.setLore(lore8);
        itemStack8.setItemMeta(itemMeta8);
        ItemStack itemStack5 = new ItemStack(Materials.chestBoat);
        ItemMeta itemMeta5 = itemStack5.getItemMeta();
        itemMeta5.setDisplayName("§9§l货运§r飞船");
        ArrayList<String> lore5 = new ArrayList<>();
        lore5.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
        lore5.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
        lore5.add("§7由地去探索这个§7§l世界");
        lore5.add("§7这艘飞船不仅可以§l载人§r§7，还可以§l§n运货");
        lore5.add("");
        lore5.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
        lore5.add("§6在§6§l船上§6,按§f§l§o§nShift§6打开面板");
        itemMeta5.setLore(lore5);
        itemStack5.setItemMeta(itemMeta5);
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

//        ItemStack itemStack10 = new ItemStack(Material.DROPPER);
//        ItemMeta itemMeta10 = itemStack8.getItemMeta();
//        itemMeta10.setDisplayName("§9§l航空§r装配台");
//        ArrayList<String> lore10 = new ArrayList<>();
//        lore10.add("§7你可以在这里§7§l装配§7你的飞机，将§7§l§n不同的模块");
//        lore10.add("§7§l§o装配到上面§7，以加强它的性能");
//        lore10.add("");
//        lore10.add("§6§l右键§6打开装配面包");
//        itemMeta10.setLore(lore10);
//        itemStack10.setItemMeta(itemMeta10);
//        ItemStack itemStack11 = new ItemStack(Material.BARREL);
//        ItemMeta itemMeta11 = itemStack11.getItemMeta();
//        itemMeta11.setDisplayName("§9§l模块§r部分");
//        ArrayList<String> lore11 = new ArrayList<>();
//        lore11.add("§7这是关于飞船的§7§l模块配方§7，你可以将");
//        lore11.add("§7这些§7§l§n模块和飞船§7放入装配台来§7§l组装");
//        itemMeta2.setLore(lore11);
//        itemStack11.setItemMeta(itemMeta11);
        inventory.setItem(0, itemStack0);
        inventory.setItem(1, itemStack1);
        inventory.setItem(2, itemStack0);
        inventory.setItem(3, itemStack0);
        inventory.setItem(4, itemStack0);
        inventory.setItem(5, itemStack0);
        inventory.setItem(6, itemStack0);
        inventory.setItem(7, itemStack0);
        inventory.setItem(8, itemStack0);
        inventory.setItem(9, itemStack9);
        inventory.setItem(10, itemStack3);
        inventory.setItem(11, itemStack4);
        inventory.setItem(12, itemStack8);
        inventory.setItem(13, itemStack5);
//        inventory.setItem(15, itemStack10);
//        inventory.setItem(16, itemStack11);

        if (true) {
            ItemStack itemStack = new ItemStack(Material.OAK_BOAT);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§9§l客运§r飞船");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
            lore.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
            lore.add("§7由地去探索这个§7§l世界");
            lore.add("§7这艘船没有攻击模块，而且造价更低");
            lore.add("");
            lore.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
            lore.add("§6在§6§l船上§6,按§f§l§o§nShift§6打开面板");
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(14, itemStack);
        }
//        if (true) {
//            ItemStack itemStack6 = new ItemStack(Material.OAK_BOAT);
//            ItemMeta itemMeta6 = itemStack6.getItemMeta();
//            itemMeta6.setDisplayName("§9§l空白§r飞船");
//            ArrayList<String> lore6 = new ArrayList<>();
//            lore6.add("§7这是BoatFly§7§l§n最重要的物品§7,是一");
//            lore6.add("§7个很快地§7§l交通工具§7,可以让§7§l§o玩家§7自");
//            lore6.add("§7由地去探索这个§7§l世界");
//            lore6.add("");
//            lore6.add("§6放下船§6§l后§6，§6§l§n右键§6上船");
//            itemMeta6.setLore(lore6);
//            itemStack6.setItemMeta(itemMeta6);
//            inventory.setItem(17, itemStack6);
//
//        }

        player.openInventory(inventory);
    }
}

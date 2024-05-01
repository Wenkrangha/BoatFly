package com.wenkrang.boatfly.ItemSystem.AllTheItem;

import com.wenkrang.boatfly.ItemSystem.PluginItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class test {
    public static PluginItem load() {
        PluginItem test = new PluginItem();
        test.setCoreItem(new ItemStack(Material.ACACIA_BOAT));
        test.setItemName("awa");
        return test;
    }
}

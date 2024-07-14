package com.wenkrang.boatfly.event.GUI.book.lib;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Recipe {
    public ItemStack item;
    public NamespacedKey namespacedKey;
    public ShapedRecipe shapedRecipe;

    public void register(Page page) {
        BookAPI.recipes.add(this);
        page.things.add(this);
    }
}

package com.wenkrang.boatfly.lib;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.Map;

@SuppressWarnings("deprecated")
public class ShapedRecipeUtil {
    public static ItemStack[] getItemStacks(ShapedRecipe recipe) {
        ItemStack[] itemStacks;
        Map<ItemStack, Integer> map = new java.util.HashMap<>(Map.of());
        final String[] shape = recipe.getShape();
        for (int i = 0; i < shape.length; i++) {
            var c = shape[i].charAt(i);
            if (c != ' ') {
                map.put(recipe.getIngredientMap().get(c), 1);
            }
        }
        map.forEach((k, v) -> map.merge(k, v, Integer::sum));
        itemStacks = new ItemStack[map.size()];
        for (Map.Entry<ItemStack, Integer> entry : map.entrySet()) {
            var itemStack = entry.getKey();
            itemStack.setAmount(entry.getValue());
            itemStacks[entry.getValue()] = itemStack;
        }

        return itemStacks;
    }
}


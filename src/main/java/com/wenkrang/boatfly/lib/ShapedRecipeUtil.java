package com.wenkrang.boatfly.lib;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShapedRecipeUtil {
    public static List<ItemStack> getItemStacks(ShapedRecipe recipe) {
        List<ItemStack> itemStacks = new ArrayList<>();
        Map<ItemStack, Integer> map = new java.util.HashMap<>(Map.of());
        final String[] shape = recipe.getShape();
        for (int i = 0; i < shape.length; i++) {
            var c = shape[i].charAt(i);
            if (c != ' ') {
                map.put(recipe.getIngredientMap().get(c), 1);
            } else {
                itemStacks.set(i, null);
            }
        }
        map.forEach((k, v) -> map.merge(k, v, Integer::sum));
        for (Map.Entry<ItemStack, Integer> entry : map.entrySet()) {
            var itemStack = entry.getKey();
            itemStack.setAmount(entry.getValue());
            itemStacks.add(itemStack);
        }

        return itemStacks;
    }
}


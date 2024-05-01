package com.wenkrang.boatfly.ItemSystem;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Bukkit.getServer;

public class PluginItem {
    /**
     * 这是插件物品的最基本的物品，也就是该物品的ItemStack <br />
     * 必须设置CoreItem, 否则该物品将被禁用
     */
    public ItemStack CoreItem = null;

    /**
     * 该方法用于设置CoreItem
     * @param coreItem 要设置的飞船物品的ItemStack
     */
    public void setCoreItem(ItemStack coreItem) {
        CoreItem = coreItem;
    }

    /**
     * 该方法用于获取CoreItem
     */
    public ItemStack getCoreItem() {
        return CoreItem;
    }

    /**
     * 该插件物品的名字,这个名字将作为NamespaceKey注册
     */
    public String ItemName = null;

    /**
     * 设置这个物品的名字，你可以使用ItemManager.getItem(Name)来获取该物品
     * @param itemName 要设置的物品的名字
     */
    public void setItemName(String itemName) {
        ItemName = itemName;
    }
    /**
     * 该方法用于获取该物品的名字
     */
    public String getItemName() {
        return ItemName;
    }

    public NamespacedKey namespacedKey = null;

    /**
     * 该物品的名字
     */
    public ShapedRecipe shapedRecipe = null;

    /**
     * 注册这个物品，以在其他的类中使用它
     */
    public void register() {
        if (CoreItem != null && ItemName != null) {
            NamespacedKey namespacedKey = new NamespacedKey(BoatFly.getPlugin(BoatFly.class), ItemName);
            ItemManager.namespacedKeys.add(namespacedKey);
            if (shapedRecipe != null) {
                getServer().addRecipe(shapedRecipe);
            }
        }
    }

    public ItemStack getItem() {
        return CoreItem;
    }
}

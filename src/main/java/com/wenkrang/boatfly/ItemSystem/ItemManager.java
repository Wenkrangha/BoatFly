package com.wenkrang.boatfly.ItemSystem;

import org.bukkit.NamespacedKey;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class ItemManager {


    /**
     * 该变量用于存储所有物品的NameSpaceKey
     */
    public static ArrayList<NamespacedKey> namespacedKeys = new ArrayList<>();

    /**
     * 该变量用于存储所有物品的PluginItem对象
     */
    public static ArrayList<PluginItem> pluginItems = new ArrayList<>();

    /**
     * 该方法用于注册物品
     * @param pluginItem 你需要注册的物品
     */
    public static void register(PluginItem pluginItem) {
        pluginItems.add(pluginItem);
        pluginItem.register();
    }

    /**
     * 从服务器移除该物品，并关闭该物品的配方
     * @param pluginItem 要删除的物品
     */
    public static void remove(PluginItem pluginItem) {
        pluginItems.remove(pluginItem);
        getServer().removeRecipe(pluginItem.namespacedKey);
    }

    /**
     * 该方法用于获取物品,如果该物品不存在，则返回null
     * @param string 你需要获取的物品的Name
     * @return 返回PluginItem对象
     */
    public static PluginItem getItem(String string) {
        for (PluginItem pluginItem : pluginItems) {
            if (pluginItem.getItemName().contains(string)) {
                return pluginItem;
            }
        }
        return null;
    }
}

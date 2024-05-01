package com.wenkrang.boatfly.Loader;

import com.wenkrang.boatfly.ItemSystem.ItemManager;
import org.bukkit.entity.Item;
import com.wenkrang.boatfly.ItemSystem.AllTheItem.test;

public class LoadItem {
    //wait
    public static void load() {
        ItemManager.register(test.load());
    }
}

package com.wenkrang.boatfly.event.GUI.book.lib;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Page {
    public ArrayList<Object> things = new ArrayList<>();
    public ItemStack item;
    public String title;

    public void register() {
        BookAPI.pages.add(this);
    }
}

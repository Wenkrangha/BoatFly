package com.wenkrang.boatfly.Loader;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.event.*;
import com.wenkrang.boatfly.event.GUI.*;
import com.wenkrang.boatfly.event.GUI.book.Click;
import com.wenkrang.boatfly.event.GUI.book.Click2;
import com.wenkrang.boatfly.event.GUI.book.PlayerInteract;
import com.wenkrang.boatfly.event.GUI.table.OpenTable;
import com.wenkrang.boatfly.event.GUI.table.TableCouldPut;
import com.wenkrang.boatfly.lib.ConsoleLoger;

import static org.bukkit.Bukkit.getServer;

public class LoadEvent {
    public static void run() {
        //加载事件
        ConsoleLoger.info("正在加载监听器...");
        getServer().getPluginManager().registerEvents(new VehicleExit(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new Exit(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new PlayerItemHeld(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new OnEng(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new VehicleEnter(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new KickEntity(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new CouldPut(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new PutCaol(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new FireSafe(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new PlayerSwapHandItems(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new AF(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new InventoryClose(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new Click(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new PlayerInteract(), BoatFly.getPlugin(BoatFly.class));
        getServer().getPluginManager().registerEvents(new VehicleDestroy(), BoatFly.getPlugin(BoatFly.class));

        //铺垫awa
//        getServer().getPluginManager().registerEvents(new OpenTable(), BoatFly.getPlugin(BoatFly.class));
//        getServer().getPluginManager().registerEvents(new TableCouldPut(), BoatFly.getPlugin(BoatFly.class));
//        getServer().getPluginManager().registerEvents(new Click2(), BoatFly.getPlugin(BoatFly.class));
    }
}

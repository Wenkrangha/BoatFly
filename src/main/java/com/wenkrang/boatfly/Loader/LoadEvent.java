package com.wenkrang.boatfly.Loader;

import com.wenkrang.boatfly.UpgradeSystem.UpgradeCheck;
import com.wenkrang.boatfly.event.GUI.*;
import com.wenkrang.boatfly.event.GUI.book.Click;
import com.wenkrang.boatfly.event.GUI.book.PlayerInteract;
import com.wenkrang.boatfly.event.*;
import com.wenkrang.boatfly.lib.ConsoleLogger;

import static com.wenkrang.boatfly.DataSystem.MainData.plugin;
import static org.bukkit.Bukkit.getServer;

public class LoadEvent {
    public static void run() {
        //加载事件
        try {
            ConsoleLogger.info("正在加载监听器...");
            getServer().getPluginManager().registerEvents(new onVehicleExit(), plugin);
            getServer().getPluginManager().registerEvents(new Exit(), plugin);
            getServer().getPluginManager().registerEvents(new PlayerItemHeld(), plugin);
            getServer().getPluginManager().registerEvents(new OnEng(), plugin);
            getServer().getPluginManager().registerEvents(new VehicleEnter(), plugin);
            getServer().getPluginManager().registerEvents(new KickEntity(), plugin);
            getServer().getPluginManager().registerEvents(new CouldPut(), plugin);
            getServer().getPluginManager().registerEvents(new PutCaol(), plugin);
            getServer().getPluginManager().registerEvents(new FireSafe(), plugin);
            getServer().getPluginManager().registerEvents(new PlayerSwapHandItems(), plugin);
            getServer().getPluginManager().registerEvents(new AF(), plugin);
            getServer().getPluginManager().registerEvents(new InventoryClose(), plugin);
            getServer().getPluginManager().registerEvents(new Click(), plugin);
            getServer().getPluginManager().registerEvents(new PlayerInteract(), plugin);
            getServer().getPluginManager().registerEvents(new VehicleDestroy(), plugin);
            getServer().getPluginManager().registerEvents(new UpgradeCheck(), plugin);
            getServer().getPluginManager().registerEvents(new Founder(), plugin);

            //铺垫awa
//        getServer().getPluginManager().registerEvents(new OpenTable(), BoatFly.getPlugin(BoatFly.class));
//        getServer().getPluginManager().registerEvents(new TableCouldPut(), BoatFly.getPlugin(BoatFly.class));
//        getServer().getPluginManager().registerEvents(new Click2(), BoatFly.getPlugin(BoatFly.class));
        } catch (Exception e) {
            ConsoleLogger.error("啊？事件注册失败：" + e.getMessage());
        }
    }
}

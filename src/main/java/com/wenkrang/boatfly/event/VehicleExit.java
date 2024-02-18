package com.wenkrang.boatfly.event;

import com.wenkrang.boatfly.BoatFly;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

import static com.wenkrang.boatfly.Data.MainData.IsShutDown;

public class VehicleExit implements Listener {
    @EventHandler
    public static void OnVehicleExit (VehicleExitEvent event) {
        if (event.getVehicle().getScoreboardTags().contains("CanFly") && !event.getExited().getScoreboardTags().contains("CanExit")) {
            if (event.getExited() instanceof Player && !event.getVehicle().isDead()) {
                Player player = (Player) event.getExited();
                Inventory inventory = Bukkit.createInventory(null, 54, "飞船控制面包");
                ItemStack itemStack0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta itemMeta0 = itemStack0.getItemMeta();
                itemMeta0.setDisplayName(" ");
                itemStack0.setItemMeta(itemMeta0);
                ItemStack itemStack1 = new ItemStack(Material.COMPASS);
                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                itemMeta1.setDisplayName("§9§l飞行§r控制面包");
                ArrayList<String> lore1 = new ArrayList<>();
                lore1.add("§7这是飞机的§7§l控制面板§7，可以控制飞机的");
                lore1.add("§7各个装置，包括AF,引擎等等");
                itemMeta1.setLore(lore1);
                itemStack1.setItemMeta(itemMeta1);
                ItemStack itemStack2 = new ItemStack(Material.SMOKER);
                ItemMeta itemMeta2 = itemStack2.getItemMeta();
                itemMeta2.setDisplayName("§6§l引擎§6设置");
                ArrayList<String> lore2 = new ArrayList<>();
                lore2.add("§7这里是§7§l飞机的引擎设置§7，可以很方便");
                lore2.add("§7地调节速度和其他的东西");
                lore2.add("");
                lore2.add("§6使用§l滚轮§r§6来调整§l§n节流阀");
                itemMeta2.setLore(lore2);
                itemStack2.setItemMeta(itemMeta2);
                ItemStack itemStack3 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta itemMeta3 = itemStack3.getItemMeta();
                itemMeta3.setDisplayName("§9§l引擎§r关闭");
                ArrayList<String> lore3 = new ArrayList<>();
                lore3.add("§7§l引擎§7没有开启，不能提供动力");
                lore3.add("");
                lore3.add("§9左键§9§l开启引擎§9");
                itemMeta3.setLore(lore3);
                itemStack3.setItemMeta(itemMeta3);
                ItemStack itemStack4 = new ItemStack(Material.GLASS_PANE);
                ItemMeta itemMeta4 = itemStack4.getItemMeta();
                itemMeta4.setDisplayName(" ");
                itemStack4.setItemMeta(itemMeta4);
                ItemStack itemStack5 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta itemMeta5 = itemStack5.getItemMeta();
                itemMeta5.setDisplayName("§9§l引擎§r燃料口");
                ArrayList<String> lore5 = new ArrayList<>();
                lore5.add("§7请在右边的格子中放入§7§l燃料( 煤炭 )");
                itemMeta5.setLore(lore5);
                itemStack5.setItemMeta(itemMeta5);
                ItemStack itemStack6 = new ItemStack(Material.SADDLE);
                ItemMeta itemMeta6 = itemStack6.getItemMeta();
                itemMeta6.setDisplayName("§9§l座位§r控制模块");
                ArrayList<String> lore6 = new ArrayList<>();
                lore6.add("§7这里是关于§7§l飞机座位§7的控制模块，你可以在");
                lore6.add("§7这里§7§m弹出乘客§7，或者下飞机");
                itemMeta6.setLore(lore6);
                itemStack6.setItemMeta(itemMeta6);
                ItemStack itemStack7 = new ItemStack(Material.PISTON);
                ItemMeta itemMeta7 = itemStack7.getItemMeta();
                itemMeta7.setDisplayName("§4§l§o离开§r飞船");
                ArrayList<String> lore7 = new ArrayList<>();
                lore7.add("§7这会让你§7§n立即§7离开飞船，如果你正在§7§n飞行§7，");
                lore7.add("§7此时§4§l离开飞船§7，是飞船可怕的事情!!!");
                itemMeta7.setLore(lore7);
                itemStack7.setItemMeta(itemMeta7);
                ItemStack itemStack8 = new ItemStack(Material.STICKY_PISTON);
                ItemMeta itemMeta8 = itemStack8.getItemMeta();
                itemMeta8.setDisplayName("§4§l§o弹出§r一号乘客");
                ArrayList<String> lore8 = new ArrayList<>();
                lore8.add("§7这会让一号乘客§7§n立即§7离开飞船，如果你正在§7§n飞行§7，");
                lore8.add("§7此时§4§l离开飞船§7，是非常可怕的事情!!!");
                itemMeta8.setLore(lore8);
                itemStack8.setItemMeta(itemMeta8);
                ItemStack itemStack9 = new ItemStack(Material.STICKY_PISTON);
                ItemMeta itemMeta9 = itemStack9.getItemMeta();
                itemMeta9.setDisplayName("§4§l§o弹出§r二号乘客");
                ArrayList<String> lore9 = new ArrayList<>();
                lore9.add("§7这会让二号乘客§7§n立即§7离开飞船，如果你正在§7§n飞行§7，");
                lore9.add("§7此时§4§l离开飞船§7，是非常可怕的事情!!!");
                itemMeta9.setLore(lore9);
                itemStack9.setItemMeta(itemMeta9);
                ItemStack itemStack10 = new ItemStack(Material.REDSTONE_TORCH);
                ItemMeta itemMeta10 = itemStack10.getItemMeta();
                itemMeta10.setDisplayName("§c§l攻击§r模块");
                ArrayList<String> lore10 = new ArrayList<>();
                lore10.add("§7这是飞机的§7§l攻击模块§7，可以发射§7§lTNT§7和");
                lore10.add("§7弓箭，直接化身§7§n战斗机");
                lore10.add("");
                lore10.add("§6将TNT或者弓箭放在手中，然后");
                lore10.add("§6§l§n切换到副手§6，就可以发射");
                itemMeta10.setLore(lore10);
                itemStack10.setItemMeta(itemMeta10);
                ItemStack itemStack11 = new ItemStack(Material.LEVER);
                ItemMeta itemMeta11 = itemStack11.getItemMeta();
                itemMeta11.setDisplayName("§9§l保险§r按钮-关闭");
                ArrayList<String> lore11 = new ArrayList<>();
                lore11.add("§7这决定着§7§lTNT和弓箭§7是否能被发射出去，");
                lore11.add("§7如果§7§n没有开启，就无法发射");
                itemMeta11.setLore(lore11);
                itemStack11.setItemMeta(itemMeta11);
                ItemStack itemStack12 = new ItemStack(Material.OBSERVER);
                ItemMeta itemMeta12 = itemStack12.getItemMeta();
                itemMeta12.setDisplayName("§9§l导航§r模块");
                ArrayList<String> lore12 = new ArrayList<>();
                lore12.add("§7你是否累于§7§l§n寻找目标？§7现在有了§7§l导航模块§7，");
                lore12.add("§7你就可以更快地到达目的地了§7§l！");
                itemMeta12.setLore(lore12);
                itemStack12.setItemMeta(itemMeta12);
                ItemStack itemStack13 = new ItemStack(Material.COMPASS);
                ItemMeta itemMeta13 = itemStack13.getItemMeta();
                itemMeta13.setDisplayName("§9§l开始§r自动驾驶");
                ArrayList<String> lore13 = new ArrayList<>();
                lore13.add("§7在这个地方，你可以开启§7§l自动驾驶§7");
                lore13.add("§7模式§7§m（我是谁，我要到哪里去）");
                lore13.add("");
                lore13.add("§6设置好电子指南针后，§6§l左键§6点击按钮，就会§c自动开启驾驶");
                lore13.add("§6右键点击，就会取消§6§l自动驾驶");
                itemMeta13.setLore(lore13);
                itemStack13.setItemMeta(itemMeta13);
                ItemStack itemStack14 = new ItemStack(Material.COMPASS);
                ItemMeta itemMeta14 = itemStack14.getItemMeta();
                itemMeta14.setDisplayName("§9§l电子§r指南针");
                ArrayList<String> lore14 = new ArrayList<>();
                lore14.add("§7这是§7§l飞机§7上面的§7§l§n电子指南针§7，§7§l它§7能指向你所给");
                lore14.add("§7的§7§l§n坐标§7，在§7§l右边§7§l§n设置坐标");
                lore14.add("");
                lore14.add("§6当前§l§n导航目标§r§6 : 0 , 0");
                itemMeta14.setLore(lore14);
                itemStack14.setItemMeta(itemMeta14);
                ItemStack itemStack15 = new ItemStack(Material.SLIME_BLOCK);
                ItemMeta itemMeta15 = itemStack15.getItemMeta();
                itemMeta15.setDisplayName("§9§l设置§rX坐标");
                ArrayList<String> lore15 = new ArrayList<>();
                lore15.add("§7设置你所§7§l想去的位置§7的§7§nX坐标");
                lore15.add("");
                lore15.add("§6§l左键增加100");
                lore15.add("§6右键减少100");
                itemMeta15.setLore(lore15);
                itemStack15.setItemMeta(itemMeta15);
                ItemStack itemStack16 = new ItemStack(Material.HONEY_BLOCK);
                ItemMeta itemMeta16 = itemStack16.getItemMeta();
                itemMeta16.setDisplayName("§9§l设置§rZ坐标");
                ArrayList<String> lore16 = new ArrayList<>();
                lore16.add("§7设置你所§7§l想去的位置§7的§7§nZ坐标");
                lore16.add("");
                lore16.add("§6§l左键增加100");
                lore16.add("§6右键减少100");
                itemMeta16.setLore(lore16);
                itemStack16.setItemMeta(itemMeta16);
                ItemStack itemStack17 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta itemMeta17 = itemStack17.getItemMeta();
                itemMeta17.setDisplayName("§9§l引擎§r开启");
                ArrayList<String> lore17 = new ArrayList<>();
                lore17.add("§7§l引擎§7现在开启了，可以提供动力");
                lore17.add("");
                lore17.add("§9左键§9§l关闭引擎§9");
                itemMeta17.setLore(lore17);
                itemStack17.setItemMeta(itemMeta17);
                ItemStack itemStack18 = new ItemStack(Material.LEVER);
                ItemMeta itemMeta18 = itemStack18.getItemMeta();
                itemMeta18.setDisplayName("§9§l保险§r按钮-开启");
                ArrayList<String> lore18 = new ArrayList<>();
                lore18.add("§7这决定着§7§lTNT和弓箭§7是否能被发射出去，");
                lore18.add("§7如果§7§n没有开启，就无法发射");
                itemMeta18.setLore(lore18);
                itemStack18.setItemMeta(itemMeta18);

                inventory.setItem(0, itemStack0);
                inventory.setItem(1, itemStack1);
                inventory.setItem(2, itemStack0);
                inventory.setItem(3, itemStack0);
                inventory.setItem(4, itemStack0);
                inventory.setItem(5, itemStack0);
                inventory.setItem(6, itemStack0);
                inventory.setItem(7, itemStack0);
                inventory.setItem(8, itemStack0);
                inventory.setItem(9, itemStack2);
                inventory.setItem(10, itemStack3);
                inventory.setItem(11, itemStack4);
                inventory.setItem(12, itemStack4);
                inventory.setItem(13, itemStack4);
                inventory.setItem(14, itemStack5);
                inventory.setItem(16, itemStack4);
                inventory.setItem(17, itemStack4);
                inventory.setItem(18, itemStack6);
                inventory.setItem(19, itemStack7);
                inventory.setItem(20, itemStack4);
                inventory.setItem(21, itemStack4);
                inventory.setItem(22, itemStack4);
                inventory.setItem(23, itemStack8);
                inventory.setItem(24, itemStack9);
                inventory.setItem(25, itemStack4);
                inventory.setItem(26, itemStack4);
                inventory.setItem(27, itemStack10);
                inventory.setItem(28, itemStack4);
                inventory.setItem(29, itemStack11);
                inventory.setItem(30, itemStack4);
                inventory.setItem(31, itemStack4);
                inventory.setItem(32, itemStack4);
                inventory.setItem(33, itemStack4);
                inventory.setItem(34, itemStack4);
                inventory.setItem(35, itemStack4);
                inventory.setItem(36, itemStack12);
                inventory.setItem(37, itemStack4);
                inventory.setItem(38, itemStack13);
                inventory.setItem(39, itemStack4);
                inventory.setItem(40, itemStack14);
                inventory.setItem(41, itemStack4);
                inventory.setItem(42, itemStack15);
                inventory.setItem(43, itemStack16);
                inventory.setItem(44, itemStack4);
                inventory.setItem(45, itemStack0);
                inventory.setItem(46, itemStack0);
                inventory.setItem(47, itemStack0);
                inventory.setItem(48, itemStack0);
                inventory.setItem(49, itemStack0);
                inventory.setItem(50, itemStack0);
                inventory.setItem(51, itemStack0);
                inventory.setItem(52, itemStack0);
                inventory.setItem(53, itemStack0);

                player.openInventory(inventory);
                player.setCompassTarget(new Location(player.getWorld(), 0, 0, 0));
                int coal = 0;
                for (String s : event.getVehicle().getScoreboardTags()) {
                    if (s.contains("coal")) {
                        coal = Integer.parseInt(s.replace("coal", ""));
                        break;
                    }
                }
                if (coal != 0) {
                    ItemStack itemStack = new ItemStack(Material.COAL, coal);
                    inventory.setItem(15, itemStack);
                }
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        if (!inventory.getViewers().contains((HumanEntity) event.getExited()) || IsShutDown) {
                            cancel();
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                if (event.getVehicle().getScoreboardTags().contains("OFF")) {
                                    inventory.setItem(10, itemStack3);
                                }else {
                                    inventory.setItem(10, itemStack17);
                                }
                                if (event.getVehicle().getScoreboardTags().contains("ON")) {
                                    int coal = 0;
                                    for (String s : event.getVehicle().getScoreboardTags()) {
                                        if (s.contains("coal")) {
                                            coal = Integer.parseInt(s.replace("coal", ""));
                                            break;
                                        }
                                    }
                                    if (coal != 0) {
                                        ItemStack itemStack = new ItemStack(Material.COAL, coal);
                                        inventory.setItem(15, itemStack);
                                    }
                                }
                                if (event.getVehicle().getScoreboardTags().contains("CanFire")) {
                                    inventory.setItem(29, itemStack18);
                                }else {
                                    inventory.setItem(29, itemStack11);
                                }

                                for (String string : event.getVehicle().getScoreboardTags()) {
                                    if (string.contains("location")) {
                                        String location = string.replace("location", "");
                                        String[] split = location.split(",");
                                        int x = Integer.parseInt(split[0]);
                                        int z = Integer.parseInt(split[1]);
                                        ((Player) event.getExited()).setCompassTarget(new Location(event.getExited().getWorld(), x, event.getExited().getLocation().getBlockY(), z));
                                        ItemStack itemStack14 = new ItemStack(Material.COMPASS);
                                        ItemMeta itemMeta14 = itemStack14.getItemMeta();
                                        itemMeta14.setDisplayName("§9§l电子§r指南针");
                                        ArrayList<String> lore14 = new ArrayList<>();
                                        lore14.add("§7这是§7§l飞机§7上面的§7§l§n电子指南针§7，§7§l它§7能指向你所给");
                                        lore14.add("§7的§7§l§n坐标§7，在§7§l右边§7§l§n设置坐标");
                                        lore14.add("");
                                        lore14.add("§6当前§l§n导航目标§r§6 : " + String.valueOf(x) + " , " + String.valueOf(z));
                                        itemMeta14.setLore(lore14);
                                        itemStack14.setItemMeta(itemMeta14);
                                        inventory.setItem(40, itemStack14);
                                        break;
                                    }
                                }
                            }
                        }.runTaskLater(BoatFly.getPlugin(BoatFly.class), 0);
                    }
                }.runTaskTimerAsynchronously(BoatFly.getPlugin(BoatFly.class), 0, 5);

                event.setCancelled(true);
            }
        }
        if (event.getExited().getScoreboardTags().contains("CanExit")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (event.getVehicle().getPassengers().isEmpty()) {
                        event.getVehicle().removeScoreboardTag("Run");
                    }
                }
            }.runTaskLaterAsynchronously(BoatFly.getPlugin(BoatFly.class), 10);
            event.getExited().removeScoreboardTag("CanExit");
        }
    }
}

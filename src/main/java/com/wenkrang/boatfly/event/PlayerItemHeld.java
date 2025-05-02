package com.wenkrang.boatfly.event;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.Objects;

public class PlayerItemHeld implements Listener {
    @EventHandler
    public static void onPlayerItemHeldEvent(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        if (event.getPlayer().getVehicle() != null && Objects.requireNonNull(event.getPlayer().getVehicle()).getScoreboardTags().contains("CanFly") && Objects.requireNonNull(event.getPlayer().getVehicle()).getScoreboardTags().contains("ON")) {
            boolean change = false;
            if (event.getNewSlot() > event.getPreviousSlot()) {
                change = true;
            }
            if (event.getNewSlot() < event.getPreviousSlot()) {
                change = false;
            }
            if (event.getNewSlot() == 8 && event.getPreviousSlot() == 0) {
                change = false;
            }
            if (event.getNewSlot() == 0 && event.getPreviousSlot() == 8) {
                change = true;
            }

            String temp = null;
            for (String string : event.getPlayer().getVehicle().getScoreboardTags()) {
                if (string.contains("eng")) {
                    temp = string;
                    break;
                }
            }
            if (temp != null) {
                int power = Integer.parseInt(temp.replace("eng", ""));

                if (change) {
                    if (!(power >= 100)) {
                        event.getPlayer().getVehicle().removeScoreboardTag(temp);
                        power += 5;
                        temp = "eng" + String.valueOf(power);
                        event.getPlayer().getVehicle().addScoreboardTag(temp);
                        event.getPlayer().sendTitle("", "§9§l节流阀§r " + ": " + String.valueOf(power) + "%",0 , 10, 5);
                    }
                }else {
                    if (!(power == 0)) {
                        event.getPlayer().getVehicle().removeScoreboardTag(temp);
                        power -= 5;
                        temp = "eng" + String.valueOf(power);
                        event.getPlayer().getVehicle().addScoreboardTag(temp);
                        event.getPlayer().sendTitle("", "§9§l节流阀§r " + ": " + String.valueOf(power) + "%", 0, 10, 5);
                    }
                }
            }

        }
    }
}

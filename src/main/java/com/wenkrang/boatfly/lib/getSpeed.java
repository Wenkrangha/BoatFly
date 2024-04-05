package com.wenkrang.boatfly.lib;

import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.Random;

public class getSpeed {
    public static int run(Entity entity, int speed) {
        int power = 0;
        //计算真正的速度
        String temp = null;
        for (String string : entity.getScoreboardTags()) {
            if (string.contains("real")) {
                temp = string;
                break;
            }
        }
        if (temp != null) {
            power = Integer.parseInt(temp.replace("real", ""));

            if (!(power >= 100)){
                if (power < speed) {
                    if (20 > new Random().nextInt(80)) {
                        entity.removeScoreboardTag(temp);
                        Random random = new Random();
                        int realspeed = random.nextInt(3);
                        power += realspeed;
                        temp = "real" + String.valueOf(power);
                        entity.addScoreboardTag(temp);
                        return power;
                    } else {
                        return power;
                    }

                }

            } else if (power > 100) {
                entity.removeScoreboardTag(temp);
                temp = "real100";
                entity.addScoreboardTag(temp);
                return power;
            }
            if (power > speed && !(power == 0)) {
                if (20 > new Random().nextInt(50)) {
                    entity.removeScoreboardTag(temp);
                    Random random = new Random();
                    int realspeed = random.nextInt(speed);
                    power -= 1;
                    temp = "real" + String.valueOf(power);
                    entity.addScoreboardTag(temp);
                    return power;
                } else {
                    return power;
                }
            }
            if (power == 0) {
                entity.removeScoreboardTag(temp);
                temp = "real0";
                entity.addScoreboardTag(temp);
            }
        } else {
            temp = "real0";
            entity.addScoreboardTag(temp);
        }

        return power;
    }
}

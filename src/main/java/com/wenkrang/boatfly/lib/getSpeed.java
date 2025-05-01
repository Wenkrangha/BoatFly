package com.wenkrang.boatfly.lib;

import org.bukkit.entity.Entity;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
                        int realspeed = ThreadLocalRandom.current().nextInt(3);
                        power += realspeed;
                        temp = "real" + power;
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
                    // int realspeed = ThreadLocalRandom.current().nextInt(speed);
                    power -= 1;
                    temp = "real" + power;
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

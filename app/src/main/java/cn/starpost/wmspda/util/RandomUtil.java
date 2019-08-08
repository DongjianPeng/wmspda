package cn.starpost.wmspda.util;

import java.util.Random;

import cn.starpost.wmspda.R;

public class RandomUtil {
    private final static Random random = new Random();

    public static int randomInt(int bound) {
        return random.nextInt(bound);
    }
}

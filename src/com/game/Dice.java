package com.game;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private static final Dice instance = new Dice();

    private Dice() {
    }

    public static Dice getInstance() {
        return instance;
    }

    public int roll() {
        return ThreadLocalRandom.current().nextInt(1, 7); // 1 to 6
    }
}

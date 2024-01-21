package com.megazone.goop.racingcar.logic;

import java.util.Random;

public class RandomGenerator {

    private final Random rand = new Random();

    public int getRandomValue(int bound) {
        return rand.nextInt(bound);
    }
}

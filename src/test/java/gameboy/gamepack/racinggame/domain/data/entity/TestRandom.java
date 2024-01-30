package gameboy.gamepack.racinggame.domain.data.entity;

import java.util.Random;

public class TestRandom extends Random {

    private int randomInt;

    public TestRandom(int randomInt) {
        super();
        this.randomInt = randomInt;
    }

    @Override
    public int nextInt(int bound) {
        return randomInt;
    }
}

package step1.racingcar;

import java.util.Random;

public class RandomUtils {

    private final static Random RANDOM = new Random();

    public static int getRandom(int bound) {
        return RANDOM.nextInt(bound);
    }
}

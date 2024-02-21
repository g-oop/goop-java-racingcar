package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();
    private static final int DEFAULT_BOUND = 10;

    public static int generate() {
        return random.nextInt(DEFAULT_BOUND);
    }

}

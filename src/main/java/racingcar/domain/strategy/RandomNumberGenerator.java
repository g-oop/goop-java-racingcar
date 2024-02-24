package racingcar.domain.strategy;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private static final Random random = new Random();
    private static final int DEFAULT_BOUND = 10;

    public int generate() {
        return random.nextInt(DEFAULT_BOUND);
    }

}

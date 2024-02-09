package racingcar.domain.numbergenerator;

import java.util.Random;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    private final Random random = new Random();
    private static final int DEFAULT_BOUND = 10;

    public int generate() {
        return random.nextInt(DEFAULT_BOUND);
    }

}

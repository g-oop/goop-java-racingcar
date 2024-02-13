package racingcar.step345;

import java.util.Random;

public class RandomRule implements Rule {

    private final Random random;

    public RandomRule() {
        this.random = new Random();
    }

    @Override
    public boolean isRun() {
        return random.nextInt(10) > 4;
    }
}

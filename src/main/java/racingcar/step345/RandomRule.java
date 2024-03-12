package racingcar.step345;

import java.util.Random;

public class RandomRule implements Rule {

    private final Random random;

    public RandomRule() {
        this.random = new Random();
    }

    public RandomRule(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public boolean isRun() {
        return this.random.nextInt(10) > 4;
    }
}

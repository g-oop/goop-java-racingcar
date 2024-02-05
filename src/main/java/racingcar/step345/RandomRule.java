package racingcar.step345;

import java.util.Random;

public class RandomRule implements Rule {

    private final Random random;
    private int stopCount;

    public RandomRule() {
        this.random = new Random();
        this.stopCount = 0;
    }

    @Override
    public boolean isStop() {

        boolean result = random.nextInt(10) < 4;
        if (result) this.stopCount += 1;
        return result;
    }

    @Override
    public int getStopCount() {
        return this.stopCount;
    }
}

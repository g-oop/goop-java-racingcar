package strategy;

import java.util.Random;

public class RandomMoveStrategyImpl implements RandomMoveStrategy {

    public static final Random RANDOM = new Random();


    @Override
    public int generateRandomValue(int rangeNumber) {
        return RANDOM.nextInt(rangeNumber);
    }
}

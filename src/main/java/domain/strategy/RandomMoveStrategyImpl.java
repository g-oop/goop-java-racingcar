package domain.strategy;

import java.util.Random;

public class RandomMoveStrategyImpl implements RandomMoveStrategy {

    @Override
    public int generateRandomValue(int rangeNumber) {
        return new Random().nextInt(rangeNumber);
    }
}

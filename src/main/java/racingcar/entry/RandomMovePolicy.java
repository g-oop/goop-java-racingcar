package racingcar.entry;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {

    private final Random random;

    public RandomMovePolicy() {
        this.random = new Random();
    }

    @Override
    public boolean canMove() {
        int randomValue = random.nextInt(10);
        return randomValue >= 4;
    }
}

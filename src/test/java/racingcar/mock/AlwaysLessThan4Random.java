package racingcar.mock;

import java.util.Random;

public class AlwaysLessThan4Random extends Random {

    @Override
    public int nextInt(int bound) {
        return super.nextInt(4);
    }
}

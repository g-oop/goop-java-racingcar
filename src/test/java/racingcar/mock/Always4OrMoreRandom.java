package racingcar.mock;

import java.util.Random;

public class Always4OrMoreRandom extends Random {

    @Override
    public int nextInt(int bound) {
        return super.nextInt(6) + 4;
    }
}

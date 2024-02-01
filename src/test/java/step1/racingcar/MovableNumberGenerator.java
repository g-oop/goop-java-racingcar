package step1.racingcar;

import step1.racingcar.strategy.NumberGenerator;

public class MovableNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return 4;
    }
}

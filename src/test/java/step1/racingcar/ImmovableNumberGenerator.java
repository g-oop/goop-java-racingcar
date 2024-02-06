package step1.racingcar;

import step1.racingcar.strategy.NumberGenerator;

public class ImmovableNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return 3;
    }
}

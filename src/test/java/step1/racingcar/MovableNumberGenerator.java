package step1.racingcar;

import step1.racingcar.domain.NumberGenerator;

public class MovableNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return 4;
    }
}

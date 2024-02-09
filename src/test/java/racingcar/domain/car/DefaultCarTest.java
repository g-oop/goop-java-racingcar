package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultCarTest {
    private Car car;
    private RandomNumberGenerator numberGenerator;

    @Test
    void moveWhenRandomValueIsOverThreshold() {
        numberGenerator = new MoveRandomNumberGenerator();
        car = new DefaultCar(numberGenerator, "TEST");
        car.move();

        assertEquals(1, car.getPosition());
    }

    @Test
    void stayWhenRandomValueIsUnderThreshold() {
        numberGenerator = new StayRandomNumberGenerator();
        car = new DefaultCar(numberGenerator, "TEST");
        car.move();

        assertEquals(0, car.getPosition());
    }
}

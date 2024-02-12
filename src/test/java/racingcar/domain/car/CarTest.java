package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car = new Car("TEST");

    @Test
    void moveWhenRandomValueIsOverThreshold() {
        car.move(MoveRandomNumberGenerator.generate());

        assertEquals(1, car.getPosition());
    }

    @Test
    void stayWhenRandomValueIsUnderThreshold() {
        car.move(StayRandomNumberGenerator.generate());

        assertEquals(0, car.getPosition());
    }
}

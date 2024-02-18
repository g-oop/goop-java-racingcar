package racingcar.domain.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car = new Car("TEST");

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9,10})
    void moveWhenRandomValueIsOverThreshold(int randomNumber) {
        car.move(randomNumber);

        assertEquals(1, car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void stayWhenRandomValueIsUnderThreshold(int randomNumber) {
        car.move(randomNumber);

        assertEquals(0, car.getPosition());
    }

}

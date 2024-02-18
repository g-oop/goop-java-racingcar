package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car = new Car("TEST");

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9,10})
    @DisplayName("기준값 이상일 경우 자동차 이동")
    void moveWhenRandomValueIsOverThreshold(int randomNumber) {
        car.move(randomNumber);

        assertEquals(1, car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("기준값 미만일 경우 자동차 이동 X")
    void stayWhenRandomValueIsUnderThreshold(int randomNumber) {
        car.move(randomNumber);

        assertEquals(0, car.getPosition());
    }

}

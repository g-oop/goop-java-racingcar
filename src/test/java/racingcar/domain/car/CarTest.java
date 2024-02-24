package racingcar.domain.car;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.entity.car.Car;
import racingcar.domain.strategy.NumberGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TEST");
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9,10})
    @DisplayName("기준값 이상일 경우 자동차 이동")
    void moveWhenRandomValueIsOverThreshold(int movableNumber){
        NumberGenerator movableNumberGenerator = () -> movableNumber;
        car  = car.move(movableNumberGenerator.generate());
        assertEquals(1, car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("기준값 미만일 경우 자동차 이동 X")
    void stayWhenRandomValueIsUnderThreshold(int immovableNumber){
        NumberGenerator immovableNumberGenerator = () -> immovableNumber;
        car  = car.move(immovableNumberGenerator.generate());
        assertEquals(0, car.getPosition());
    }

}

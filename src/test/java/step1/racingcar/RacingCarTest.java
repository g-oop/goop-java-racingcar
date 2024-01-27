package step1.racingcar;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.racingcar.util.ImmovableNumberGenerator;
import step1.racingcar.util.MovableNumberGenerator;
import step1.racingcar.vo.Car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @ParameterizedTest
    @CsvSource(value = {"5,3"}, delimiter = ',')
    @DisplayName("자동차 게임 - 1. 자동차 생성 확인")
    public void carCreateTest(int carCount, int tryCount) throws Exception {
        CarManager carManager = new CarManager(carCount, tryCount);
        carManager.readyToStart();
        assertThat(carManager.moveCars().size()).isEqualTo(carCount);
    }

    @Test
    @DisplayName("자동차 게임 - 2. 4 이상이면 전진, 4 미만이면 정지")
    public void carMoveTest() throws Exception {
        Car beforeMoveCar = new Car();

        Car movingCar = new Car();
        movingCar.move(new MovableNumberGenerator());
        assertNotEquals(beforeMoveCar, movingCar);
        assertEquals(movingCar.getPosition(), 2);

        Car nonMovingCar = new Car();
        nonMovingCar.move(new ImmovableNumberGenerator());
        assertEquals(beforeMoveCar, nonMovingCar);
    }
}

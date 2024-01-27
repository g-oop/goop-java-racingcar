package step1.racingcar;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.racingcar.util.ImmovableNumberGenerator;
import step1.racingcar.util.MovableNumberGenerator;
import step1.racingcar.vo.Car;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    @DisplayName("자동차 게임 - 1. 자동차 생성 확인")
    public void carCreateTest(int carCount) throws Exception {
        CarManager carManager = new CarManager(carCount);
        carManager.readyToStart();
        assertThat(carManager.getPositions()).hasSize(carCount);
    }

    @Test
    @DisplayName("자동차 게임 - 2. 4 이상이면 자동차 전진, 4 미만이면 정지 확인")
    public void carMoveTest() throws Exception {
        Car movingCar = new Car();
        movingCar.move(new MovableNumberGenerator());
        assertThat(movingCar.getPosition()).isEqualTo(2);

        Car nonMovingCar = new Car();
        nonMovingCar.move(new ImmovableNumberGenerator());
        assertThat(nonMovingCar.getPosition()).isEqualTo(1);
    }
}

package step1.racingcar;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.racingcar.util.ImmovableNumberGenerator;
import step1.racingcar.util.MovableNumberGenerator;
import step1.racingcar.vo.Car;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @ParameterizedTest
    @CsvSource(value = {"5,3,10"}, delimiter = ',')
    @DisplayName("자동차 게임 - 1. 자동차 생성 확인")
    public void carCreateTest(int carCount, int tryCount, int condition) throws Exception {
        CarManager carManager = new CarManager(carCount, tryCount);
        carManager.readyToStart();
        //assertThat(carManager.getCarCount()).isEqualTo(carCount);
        //assertThat(carManager.getTryCount()).isEqualTo(tryCount);
        assertThat(carManager.moveCars().size()).isEqualTo(carCount);
    }

    @Test
    @DisplayName("자동차 게임 - 2. 4 이상이면 전진, 4 미만이면 정지")
    public void carMoveTest() throws Exception {
        Car movableCar = new Car();
        movableCar.move(new MovableNumberGenerator());
        assertThat(movableCar.getPosition()).isEqualTo(2);

        Car immovableCar = new Car();
        immovableCar.move(new ImmovableNumberGenerator());
        assertThat(immovableCar.getPosition()).isEqualTo(1);
    }
}

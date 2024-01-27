package step1.racingcar;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        assertThat(carManager.moveCars(condition).size()).isEqualTo(carCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "3:1", "4:2", "5:2", "9:2"}, delimiter = ':')
    @DisplayName("자동차 게임 - 2. 4 이상이면 자동차 전진, 4 미만이면 정지 확인")
    public void carMoveTest(int condition, int expected) throws Exception {
        Car car = new Car();
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}

package step1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.vo.Car;
import step1.vo.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveCarTest {

    @ParameterizedTest
    @CsvSource(value = {"3"}, delimiter = ',')
    @DisplayName("자동차 게임 - 1. 자동차 생성 개수 확인")
    public void carCreateTest(int carCount) throws Exception {
        Cars cars = CarManager.createCar(carCount);
        assertThat(cars.getCarCount()).isEqualTo(carCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"0=1", "1=1", "2=1"}, delimiter = '=')
    @DisplayName("자동차 게임 - 2. 시작 위치 1인지 확인")
    public void carInitialTest(int carNum, int expected) throws Exception {
        Cars cars = CarManager.createCar(3);
        assertThat(cars.getCarLoc(carNum)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,5"}, delimiter = ',')
    @DisplayName("자동차 게임 - 3. 4 이상일 때만 전진하는지 확인")
    public void carMoveTest(int initialLoc, int greaterThan) throws Exception {
        Car car = new Car();
        car.moveForward();
        int carLoc = car.getLoc();
        assertTrue(carLoc == initialLoc || carLoc >= greaterThan);
    }
}

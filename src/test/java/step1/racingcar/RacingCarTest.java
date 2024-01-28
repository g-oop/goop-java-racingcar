package step1.racingcar;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.racingcar.domain.vo.Car;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true"}, delimiter = ':')
    @DisplayName("자동차 게임 - 1. 자동차 생성 확인")
    public void carCreateTest(int position, boolean expected) throws Exception {
        Car car = new Car();
        car.initializePosition();
        assertThat(car.getPosition() == position).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 게임 - 2. 4 이상이면 자동차 전진, 4 미만이면 정지 확인")
    public void carMoveTest() throws Exception {
        Car movingCar = new Car();
        movingCar.move(new MovableNumberGenerator().generateNumber());
        assertThat(movingCar.getPosition()).isEqualTo(2);

        Car nonMovingCar = new Car();
        nonMovingCar.move(new ImmovableNumberGenerator().generateNumber());
        assertThat(nonMovingCar.getPosition()).isEqualTo(1);
    }
}

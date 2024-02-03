package step1.racingcar;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.racingcar.domain.vo.Car;
import step1.racingcar.domain.vo.Cars;
import step1.racingcar.exception.CarNameException;
import step1.racingcar.utils.StringSplitUtils;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true"}, delimiter = ':')
    @DisplayName("자동차 게임 - 1. 자동차 생성 확인")
    public void carCreateTest(int position, boolean expected) throws Exception {
        Car car = new Car("name");
        car.initializePosition();
        assertThat(car.getPosition() == position).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 게임 - 2. 4 이상이면 자동차 전진, 4 미만이면 정지 확인")
    public void carMoveTest() throws Exception {
        Car movingCar = new Car("name");
        movingCar.move(new MovableNumberGenerator().generateNumber());
        assertThat(movingCar.getPosition()).isEqualTo(2);

        Car nonMovingCar = new Car("name");
        nonMovingCar.move(new ImmovableNumberGenerator().generateNumber());
        assertThat(nonMovingCar.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"가,나,다:,:3", "1/2:/:2"}, delimiter = ':')
    @DisplayName("자동차 게임 - 3. 구분자로 자동차 이름 구분해서 이름 수만큼 자동차 생성")
    public void createCarOfNamesTest(String carNames, String delimiter, int expected) throws Exception {
        String[] carNameArr = StringSplitUtils.splitBySeparator("//" + delimiter + "\n" + carNames);
        assertThat(carNameArr).hasSize(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나다라마바", "123456"})
    @DisplayName("자동차 게임 - 4. 자동차 이름 5자리 초과")
    public void carNameValidationTest(String carNames) throws Exception {
        assertThatThrownBy(() -> { new Car(carNames); })
            .isInstanceOf(CarNameException.class)
            .hasMessageContaining("자동차 이름이 5자리 초과되었습니다.");
    }

    @Test
    @DisplayName("자동차 게임 - 5. 우승자 선정")
    public void createCarOfNamesTest() throws Exception {
        Car car1 = new Car("가");
        Car car2 = new Car("나");
        Car car3 = new Car("다");

        car1.move(new MovableNumberGenerator().generateNumber());

        Cars cars = new Cars(List.of(car1, car2, car3));
        assertThat(cars.getWinnerNames()).hasSize(1);
        assertThat(cars.getWinnerNames().get(0)).isEqualTo("가");
    }

}

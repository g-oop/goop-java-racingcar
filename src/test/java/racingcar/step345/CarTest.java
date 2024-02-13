package racingcar.step345;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차는 전진한다.")
    @Test
    void run() {

        Car car = new Car();

        car.run();
        Assertions.assertThat(car.getOdometer()).isEqualTo(1);
    }

    @DisplayName("자동차는 멈춘다.")
    @Test
    void pause() {

        Car car = new Car();

        car.pause();
        Assertions.assertThat(car.getOdometer()).isEqualTo(0);
    }
}

package racingcar.entry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.mock.Always4OrMoreRandom;
import racingcar.mock.AlwaysLessThan4Random;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @RepeatedTest(10)
    @DisplayName("랜덤값이 4 이상이면 전진한다.")
    void move() {
        Random random = new Always4OrMoreRandom();
        Car car = new Car(random);

        int prevPosition = car.currentPosition();
        car.move();
        int nextPosition = car.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition + 1);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤값이 4 미만이면 전진하지 않는다.")
    void notMove() {
        Random random = new AlwaysLessThan4Random();
        Car car = new Car(random);
        
        int prevPosition = car.currentPosition();
        car.move();
        int nextPosition = car.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition);
    }


}

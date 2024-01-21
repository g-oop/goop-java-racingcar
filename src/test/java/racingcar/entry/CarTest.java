package racingcar.entry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.mock.AlwaysMovePolicy;
import racingcar.mock.AlwaysNotMovePolicy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @RepeatedTest(10)
    @DisplayName("랜덤값이 4 이상이면 전진한다.")
    void move() {
        Car car = new Car();
        MovePolicy movePolicy = new AlwaysMovePolicy();

        int prevPosition = car.currentPosition();
        Car newCar = car.move(movePolicy);
        int nextPosition = newCar.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition + 1);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤값이 4 미만이면 전진하지 않는다.")
    void notMove() {
        Car car = new Car();
        MovePolicy movePolicy = new AlwaysNotMovePolicy();

        int prevPosition = car.currentPosition();
        Car newCar = car.move(movePolicy);
        int nextPosition = newCar.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition);
    }
}

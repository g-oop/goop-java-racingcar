package racingcar.entry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.mock.AlwaysMovePolicy;
import racingcar.mock.AlwaysNotMovePolicy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @RepeatedTest(10)
    @DisplayName("MovePolicy를 지정하지 않으면 전진하지 않는다.")
    void notPolicy() {
        Car car = new Car();

        int prevPosition = car.currentPosition();
        car.move();
        int nextPosition = car.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition);
    }

    @RepeatedTest(10)
    @DisplayName("Setter를 통해 MovePolicy를 설정하고, 랜덤값이 4 이상이면 전진한다.")
    void move() {
        MovePolicy movePolicy = new AlwaysMovePolicy();
        Car car = new Car();
        car.setMovePolicy(movePolicy);

        int prevPosition = car.currentPosition();
        car.move();
        int nextPosition = car.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition + 1);
    }

    @RepeatedTest(10)
    @DisplayName("생성자를 통해 MovePolicy를 설정하고, 랜덤값이 4 이상이면 전진한다.")
    void move2() {
        MovePolicy movePolicy = new AlwaysMovePolicy();
        Car car = new Car(movePolicy);

        int prevPosition = car.currentPosition();
        car.move();
        int nextPosition = car.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition + 1);
    }

    @RepeatedTest(10)
    @DisplayName("Setter를 통해 MovePolicy를 설정하고, 랜덤값이 4 미만이면 전진하지 않는다.")
    void notMove() {
        MovePolicy movePolicy = new AlwaysNotMovePolicy();
        Car car = new Car();
        car.setMovePolicy(movePolicy);

        int prevPosition = car.currentPosition();
        car.move();
        int nextPosition = car.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition);
    }
}

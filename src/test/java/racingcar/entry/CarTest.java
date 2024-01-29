package racingcar.entry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.mock.AlwaysMovePolicy;
import racingcar.mock.AlwaysNotMovePolicy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcde"})
    @DisplayName("자동차 이름은 1~5자만 가능하다.")
    void allowedCarName(String carName) {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "abcdefghi"})
    @DisplayName("자동차 이름은 없거나 5자를 초과할 수 없다.")
    void deniedCarName(String carName) {
        ThrowingCallable callable = () -> new Car(carName);
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤값이 4 이상이면 전진한다.")
    void move() {
        Car car = new Car("test");
        MovePolicy movePolicy = new AlwaysMovePolicy();

        int prevPosition = car.currentPosition();
        Car newCar = car.move(movePolicy);
        int nextPosition = newCar.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition + 1);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤값이 4 미만이면 전진하지 않는다.")
    void notMove() {
        Car car = new Car("test");
        MovePolicy movePolicy = new AlwaysNotMovePolicy();

        int prevPosition = car.currentPosition();
        Car newCar = car.move(movePolicy);
        int nextPosition = newCar.currentPosition();

        assertThat(nextPosition).isEqualTo(prevPosition);
    }
}

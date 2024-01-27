import domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void MoveWithRandomNumberGreaterThanEqual4(int randmomNumber) {
        // Car 객체 생성
        Car car1 = new Car();
        Car car2 = new Car();

        car1.move(randmomNumber);

        boolean equals = car1.equals(car2);

        Assertions.assertThat(equals).isFalse();
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void MoveWithRandomNumberLessThan4(int randmomNumber) {
        // Car 객체 생성
        Car car1 = new Car();
        Car car2 = new Car();

        car1.move(randmomNumber);

        boolean equals = car1.equals(car2);

        Assertions.assertThat(equals).isTrue();
    }
}



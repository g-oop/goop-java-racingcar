import domain.Car;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void MoveWithRandomNumberGreaterThanEqual4(int randomNumber) {
        // Car 객체 생성
        Car car = new Car();
        int position = car.getPosition();

        car.move(randomNumber);

        assertEquals(car.getPosition(), position + 1);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void MoveWithRandomNumberLessThan4(int randomNumber) {
        // Car 객체 생성
        Car car = new Car();
        int position = car.getPosition();

        car.move(randomNumber);

        assertEquals(car.getPosition(), position);
    }
}



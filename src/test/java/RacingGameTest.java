import domain.entity.car.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.NumberGenerator;
import strategy.NumberGeneratorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void MoveWithRandomNumberGreaterThanEqual4(int randomNumber) {
        // Car 객체 생성
        Car car = new Car("sujin");
        int position = car.getPosition();

        car.move(randomNumber);

        assertEquals(car.getPosition(), position + 1);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void MoveWithRandomNumberLessThan4(int randomNumber) {
        // Car 객체 생성
        Car car = new Car("sujin");
        int position = car.getPosition();


        car.move(randomNumber);

        assertEquals(car.getPosition(), position);
    }


    @Test
    public void MoveFromNumberGenerator() {
        Car car = new Car("sujin");
        int position = car.getPosition();

        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        int randomValue = numberGenerator.generateRandomValue();


        if (randomValue <= 3) {
            car.move(randomValue);
            assertEquals(car.getPosition(), position);
        }

        if (randomValue > 3) {
            car.move(randomValue);
            assertEquals(car.getPosition(), position + 1);
        }
    }
}


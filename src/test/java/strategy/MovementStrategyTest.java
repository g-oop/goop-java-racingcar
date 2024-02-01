package strategy;

import domain.Car;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementStrategyTest {


    private Car car;

    @BeforeEach
    public void setup() {
        car = new Car("sujin");
    }

    @DisplayName("랜덤값이 3이하일떄 정지 테스트")
    @Test
    public void generateRandomValueForStop() {
        MovementStrategy movementStrategy = new StopMovementStrategy();
        int stopValue = movementStrategy.performAction();
        car.move(stopValue);

        assertEquals(car.getPosition(), 0);
    }

    @DisplayName("랜덤값이 4이상일떄 움직임 테스트")
    @Test
    public void generateRandomValueForMove() {
        MovementStrategy movementStrategy = new MoveMovementStrategy();
        int moveValue = movementStrategy.performAction();
        car.move(moveValue);

        assertEquals(car.getPosition(), 1);

    }
}

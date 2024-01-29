import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import domain.Car;
import domain.ui.RacingGame;
import domain.util.RacingCarInputHandler;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {

    @Test
    public void testCarMove() {
        Car car = new Car("TestCar");
        int initialPosition = car.getPosition();
        car.move();

        assertTrue(car.getPosition() == initialPosition + 1 || car.getPosition() == initialPosition);
    }

    @Test
    public void testCarState() {
        Car car = new Car("TestCar");
        String state = car.getState();
        assertNotNull(state);
        assertTrue(state.startsWith("|"));
        assertTrue(state.endsWith(">"));
    }

    @Test
    public void test() {
        // 시뮬레이션할 입력값 설정
        String simulatedInput = "5\n10\n";
        InputStream savedSystemIn = System.in;  // 기존 System.in 저장
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            RacingGame racingGame = new RacingGame();
            racingGame.play();

            // 상태를 검증
            assertThat(racingGame.getCarCount()).isEqualTo(5);
            assertThat(racingGame.getMoveCount()).isEqualTo(10);
        } finally {
            // System.in을 복원
            System.setIn(savedSystemIn);
        }
    }

}

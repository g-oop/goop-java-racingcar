package racingcar.application;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import racingcar.domain.car.Car;
import racingcar.view.InputView;

import static org.mockito.Mockito.*;

public class RacingGameTest {
    private InputView inputView;

    @BeforeEach
    void setUp(){
        inputView = mock(InputView.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void eachCarsShouldMoveWhenRaceStarted(int attempts) {
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        List<Car> cars = Arrays.asList(car1, car2);

        RacingGame racingGame = new RacingGame(inputView);

        racingGame.race(cars, attempts);

        verify(car1, Mockito.times(attempts)).move();
        verify(car2, Mockito.times(attempts)).move();
    }
}

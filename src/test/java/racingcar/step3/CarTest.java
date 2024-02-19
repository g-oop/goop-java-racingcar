package racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("지정된 수의 Car 객체를 cars 목록을 초기화")
    @ParameterizedTest
    @CsvSource( value = {"1, 4", "7,7"})
    public void move(int input, int expected) {
        Race race = new Race(input);
        List<Car> cars = race.getCars();
        assertThat(cars).hasSize(expected);
    }
}

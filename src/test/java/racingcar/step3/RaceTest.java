package racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceTest {

    private Race race;

    @DisplayName("전진 횟수는 시도 횟수보다 클수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 7, 16, 20})
    public void moveLengthCannotBeMoreThanAttempts(int input) {
        Race race = new Race(input);
        for (Car car : race.getCars()) {
            assertTrue(car.getPosition() <= input, "전진 횟수는 시도 횟수보다 클수 없다.");
        }
    }
}

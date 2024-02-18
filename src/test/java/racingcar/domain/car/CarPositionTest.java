package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarPositionTest {

    @Test
    @DisplayName("음수 비허용")
    void throwsExceptionWhenNegativeValuePassed() {
        int invalidPosition = -1;
        assertThrows(RuntimeException.class, () -> new CarPosition(invalidPosition));
    }
}

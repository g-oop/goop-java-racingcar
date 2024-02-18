package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @Test
    @DisplayName("이름 길이 제한 초과 시 예외 발생")
    void throwsExceptionWhenNameLengthOverLimit() {
        String invalidName = "123456";
        assertThrows(RuntimeException.class, () -> new Car(invalidName));
    }
}

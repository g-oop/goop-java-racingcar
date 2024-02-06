package domain.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("위치가 0미만 제한 테스트")
    public void validatePosition() {

        Assertions.assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

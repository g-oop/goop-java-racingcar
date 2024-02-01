import domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {


    @DisplayName("이름 길이 제한 테스트")
    @Test
    public void validateName() {
        Assertions.assertThatThrownBy(() -> new Car("sujin1234"))
            .isInstanceOf(IllegalArgumentException.class);
    }


}



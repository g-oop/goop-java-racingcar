package racingcar.step345;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RuleTest {

    @DisplayName("전진하는 조건은 항상 일정하다.")
    @Test
    void linearRule() {

        Rule rule = new LinearRule();

        Assertions.assertThat(rule.isRun()).isEqualTo(true);
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    @Test
    void randomRule() {

        Rule rule = new RandomRule(777);

        Assertions.assertThat(rule.isRun()).isEqualTo(false);
    }
}

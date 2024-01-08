package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringClassTest {

    @Test
    void firstOfRequirement1() {

        // given
        String inputString = "1,2";

        // when
        StringClass stringClass = new StringClass(inputString);

        // then
        Assertions.assertThat(stringClass.result).contains("1");
        Assertions.assertThat(stringClass.result).contains("2");

        Assertions.assertThat(stringClass.result).containsExactly("1", "2");
    }

    @Test
    void secondOfRequirement1() {

        // given
        String inputString = "1";

        // when
        StringClass stringClass = new StringClass(inputString);

        // then
        Assertions.assertThat(stringClass.result).contains("1");

        Assertions.assertThat(stringClass.result).containsExactly("1");
    }
}

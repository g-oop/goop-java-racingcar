package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringClassTest {

    @DisplayName("split 테스트 1")
    @Test
    void firstOfRequirement1() {

        // given
        String inputString = "1,2";

        // when
        StringClass stringClass = new StringClass(inputString);
        String[] result = stringClass.split();

        // then
        Assertions.assertThat(result).contains("1");
        Assertions.assertThat(result).contains("2");

        Assertions.assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("split 테스트 2")
    @Test
    void secondOfRequirement1() {

        // given
        String inputString = "1";

        // when
        StringClass stringClass = new StringClass(inputString);
        String[] result = stringClass.split();

        // then
        Assertions.assertThat(result).contains("1");

        Assertions.assertThat(result).containsExactly("1");
    }

    @DisplayName("substring 테스트")
    @Test
    void firstOfRequirement2() {

        // given
        String inputString = "(1,2)";

        // when
        StringClass stringClass = new StringClass(inputString);
        String result = stringClass.substring();

        // then
        Assertions.assertThat(result).contains("1,2");
    }

    @DisplayName("StringIndexOutOfBoundsException 테스트 1")
    @Test
    void firstOfRequirement3() {

        // given

        // when
        StringClass stringClass = new StringClass("abc");

        // then
        Assertions.assertThat(stringClass.charAt(2)).isEqualTo('c');
        Assertions.assertThatThrownBy(() -> {
            stringClass.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 5");
    }

    @DisplayName("StringIndexOutOfBoundsException 테스트 2")
    @Test
    void secondOfRequirement3() {

        // given
        String inputString = "abc";

        // when
        StringClass stringClass = new StringClass(inputString);

        // then
        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                stringClass.charAt(5);
            }).withMessageMatching("String index out of range: \\d+");
    }
}

package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split 결과 테스트")
    public void split() {
        //given
        String text = "1,2";
        //when
        String[] result = text.split(",");
        //then
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 결과 테스트")
    public void substring() {
        //given
        String text = "(1,2)";
        //when
        String result = text.substring(1, text.length() - 1);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("charAt 결과 테스트")
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    public void charAt(int index, char expected) {
        //given
        String text = "abc";

        //when
        char result = text.charAt(index);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt 예외 테스트 - StringIndexOutOfBoundsException")
    public void charAtStringIndexOutOfBoundsException() {
        //given
        String text = "abc";
        int index = text.length() + 1;

        assertThatThrownBy(() -> {
            //when
            text.charAt(index);
            //then
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

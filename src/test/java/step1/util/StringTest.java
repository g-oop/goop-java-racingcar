package step1.util;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("StringTest > 구분자로 구분")
    public void splitAndExpectContains_숫자() {
        String str = "1,2";
        String[] strArray = str.split(",");
        assertThat(strArray).contains("2", "1"); // 순서 상관없이 중복 확인
        assertThat(strArray).containsExactly("1", "2"); // 순서 포함 중복 확인
    }

    @Test
    @DisplayName("StringTest > 괄호 제거")
    public void substringAndExpectEquals_괄호_안_문자() {
        String str = "(1,2)";
        int openIndex = str.indexOf("(");
        int closeIndex = str.indexOf(")");
        assertThat(openIndex).isNotEqualTo(-1);
        assertThat(closeIndex).isNotEqualTo(-1);
        assertThat(str.substring(openIndex + 1, closeIndex)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringTest > string -> char 변경 시 StringIndexOutOfBoundsException 발생 여부 체크")
    public void stringToCharAndExpectThrowException() {
        String str = "abc";
        int index = 10;
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> { str.charAt(index); })
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: %d", index);
    }

}

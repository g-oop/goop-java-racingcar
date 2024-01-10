import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class StringClassTest {

    @Test
    public void stringSplit_ShouldContains() {
        String str = "1,2";
        String[] strArray = str.split(",");
        assertThat(strArray).contains("2", "1"); // 순서 상관없이 중복 확인
        assertThat(strArray).containsExactly("1", "2"); // 순서 포함 중복 확인
    }

    @Test
    public void stringSubstring_ShouldEqual() {
        String str = "(1,2)";
        int openIndex = str.indexOf("(");
        int closeIndex = str.indexOf(")");
        assertThat(openIndex).isNotEqualTo(-1);
        assertThat(closeIndex).isNotEqualTo(-1);
        assertThat(str.substring(openIndex + 1, closeIndex)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Catch StringIndexOutOfBoundsException")
    public void stringChatAt_ShouldThrowException() {
        String str = "abc";
        int index = 10;
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: %d", index);
    }

}

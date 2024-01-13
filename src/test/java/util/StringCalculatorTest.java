package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    @DisplayName("1. null 또는 빈 문자열을 입력할 경우 0을 반환해야 한다.")
    void nullOrBlankString_return_0(String input) {
        int result = StringCalculator.add(input);
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123"})
    @DisplayName("2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void oneNumberString_return_same(String input) {
        int result = StringCalculator.add(input);
        int expected = Integer.parseInt(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1,2 = 3",
        "3,4 = 7",
    }, delimiter = '=')
    @DisplayName("3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void twoNumberString_return_sum(String input, int sum) {
        int result = StringCalculator.add(input);
        assertThat(result).isEqualTo(sum);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1,2:3 = 6",
        "1:2,3 = 6",
        "1:2:3 = 6",
        "1,2,3 = 6",
    }, delimiter = '=')
    @DisplayName("4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void manyNumberStringWithMultiDelimeter_return_sum(String input, int sum) {
        int result = StringCalculator.add(input);
        assertThat(result).isEqualTo(sum);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "//;\\n1;2 = 3",
        "//;\\n1;2; = 3",
        "//.\\n1.2.3 = 6",
        "//.\\n1.2.3. = 6",
        "//;.\\n1;.2;.3 = 6",
        "//;.\\n1;.2;.3;. = 6",
    }, delimiter = '=')
    @DisplayName("5. “//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void manyNumberStringWithCustomDelimeter_return_sum(String input, int sum) {
        int result = StringCalculator.add(input);
        assertThat(result).isEqualTo(sum);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "-1",
        "-23",
        "-1,2",
        "3,-4",
        "-1,2:3",
        "1:-2,3",
        "1:2:-3",
        "1,-2,3",
        "//;\\n-1;2;3",
        "//.\\n1.-2.3",
        "//;.\\n1;.2;.-3",
    })
    @DisplayName("6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. ")
    void minusNumberString_throwException(String input) {
        ThrowingCallable callable = () -> StringCalculator.add(input);
        assertThatThrownBy(callable).isInstanceOf(RuntimeException.class)
            .hasMessage("음수는 처리할 수 없습니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {
        "x",
        "x2",
        "x,2",
        "1,x",
        "x,2:3",
        "1:x,3",
        "1:2:x",
        "1,x,3",
        "//;\\nx;2;3",
        "//.\\n1.x.3",
        "//;.\\n1;.2;.x",
    })
    @DisplayName("7. 숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생해야 한다. ")
    void invalidNumberString_throwException(String input) {
        ThrowingCallable callable = () -> StringCalculator.add(input);
        assertThatThrownBy(callable).isInstanceOf(RuntimeException.class)
            .hasMessage("숫자로 변환할 수 없습니다.");

    }
}

package testonly;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection에 대한 학습 테스트")
class SetTest {

    Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2")
    void contains(int value) {
        assertThat(numbers).contains(value);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1,true",
        "2,true",
        "3,true",
        "4,false",
        "5,false"
    })
    @DisplayName("요구사항 3")
    void contains(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}

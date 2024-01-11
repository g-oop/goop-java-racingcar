package util;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    @DisplayName("size 결과 테스트")
    public void size() {
        //given
        //when
        int result = numbers.size();

        //then
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest()
    @ValueSource(ints = {1,2,3})
    @DisplayName("contains 결과 테스트")
    public void contains(int index) {
        //given
        //when
        boolean result = numbers.contains(index);

        //then
        assertThat(result).isTrue();

    }

    @ParameterizedTest()
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("contains 결과 테스트")
    public void contains(int index, boolean expected) {
        //given
        //when
        boolean result = numbers.contains(index);

        //then
        assertThat(result).isEqualTo(expected);

    }
}

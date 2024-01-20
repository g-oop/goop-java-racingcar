package learningtest;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


    @Test
    @DisplayName("요구사항 1 > Set 사이즈 확인")
    void getSizeOfSet() {

        int size = numbers.size();

        int expected = 3;
        assertEquals(expected, size, "Set does not take duplicate elements");
    }

    @DisplayName("요구사항 2 > Set 요소 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void returnTrueWhenSetContains(int parameterizedNumber) {
        assertThat(numbers).contains(parameterizedNumber);
    }

    @DisplayName("요구사항 3 > Set 요소 확인")
    @ParameterizedTest
    @CsvSource(value = {"1 : true", "2: true", "3: true", "4: false", "5: false"}, delimiter = ':')
    void containsTestCases(int parameterizedNumber, boolean expected) {
        assertThat(numbers.contains(parameterizedNumber)).isEqualTo(expected);
    }
}


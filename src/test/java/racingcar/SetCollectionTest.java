package racingcar;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void firstOfRequirement1() {

        // given

        // when
        SetCollection setCollection = new SetCollection(numbers);
        int result = setCollection.size();

        // then
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void firstOfRequirement2() {

        // given

        // when
        SetCollection setCollection = new SetCollection(numbers);

        // then
        Assertions.assertThat(setCollection.contains(1)).isTrue();
        Assertions.assertThat(setCollection.contains(2)).isTrue();
        Assertions.assertThat(setCollection.contains(3)).isTrue();
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void secondOfRequirement2(int inputInt) {

        // given

        // when
        SetCollection setCollection = new SetCollection(numbers);

        // then
        Assertions.assertThat(setCollection.contains(inputInt)).isTrue();
    }

    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @ParameterizedTest
    void firstOfRequirement3(int inputInt, boolean inputBoolean) {

        // given

        // when
        SetCollection setCollection = new SetCollection(numbers);

        // then
        Assertions.assertThat(setCollection.contains(inputInt)).isEqualTo(inputBoolean);
    }
}

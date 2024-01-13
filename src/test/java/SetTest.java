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
    @DisplayName("Set Collection에 대한 학습 테스트 : 요구사항 1")
    public void test1(){
        int size = numbers.size();
        assertThat(numbers).hasSize(size);
    }

    @DisplayName("Set Collection에 대한 학습 테스트 : 요구사항 2")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void test2(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set Collection에 대한 학습 테스트 : 요구사항 3")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    void test3(int input , boolean contains){
        assertThat(numbers.contains(input)).isEqualTo(contains);
    }
}

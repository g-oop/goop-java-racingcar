import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    
    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 : 요구사항 1")
    public void test1(){
        String FirstRequirementStringValue  = "1,2";
        String[] split = FirstRequirementStringValue.split(",");
        String secondRequirementStringValue = "1";
        String[] split1 = secondRequirementStringValue.split(",");

        assertThat(split).contains("2","1"); //순서 상관없이 가능
        assertThat(split1).contains("1");


        assertThat(split).containsExactly("1", "2"); //순서 다르면 안됨
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 : 요구사항 2")
    public void test2(){
        String requirementStringValue = "(1,2)";
        String subString = requirementStringValue.substring(1, 4);
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 : 요구사항 3")
    public void test3(){
        String requirementStringValue = "abc";
        int specificLocation = 10;
        assertThatThrownBy(() -> requirementStringValue.charAt(specificLocation))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining(String.format("String index out of range: %d",specificLocation));
        //예외 메시지를 포함하는지
    }





}

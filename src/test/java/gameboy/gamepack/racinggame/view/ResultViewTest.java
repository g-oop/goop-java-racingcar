package gameboy.gamepack.racinggame.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {

    @Test
    @DisplayName("display 결과 테스트")
    void display_정상결과() {
        //given
        List<Integer> carsPosition = List.of(1,2,3,4,5);
        String expected = """
            -
            --
            ---
            ----
            -----
            """;
        ResultView resultView = new ResultView(carsPosition);
        //when
        String result = resultView.display();
        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("display 결과 테스트")
    void display_0_음수_무시() {
        //given
        List<Integer> carsPosition = List.of(0,-1,-2,4,5);
        String expected = """
            
            
           
            ----
            -----
            """;
        ResultView resultView = new ResultView(carsPosition);
        //when
        String result = resultView.display();
        //then
        assertThat(result).isEqualTo(expected);
    }
}
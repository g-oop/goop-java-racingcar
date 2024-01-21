package gameboy.gamepack.racinggame.view;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("VIEW - ResultView 테스트")
class ResultViewTest {

    @Test
    @DisplayName("결과 출력 테스트")
    void display_정상결과() {
        //given
        List<Integer> carsPosition = List.of(
            1, 2, 3, 4
        );
        String expected = """
            -
            --
            ---
            ----
            """;
        //when
        String result = ResultView.getRaceResult(carsPosition);
        //then
        assertThat(result).isEqualTo(expected);
    }
}

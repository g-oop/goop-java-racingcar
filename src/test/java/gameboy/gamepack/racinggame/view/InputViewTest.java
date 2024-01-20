package gameboy.gamepack.racinggame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("VIEW - InputView 테스트")
class InputViewTest {

    @ParameterizedTest
    @DisplayName("입력폼 출력 테스트")
    @ValueSource(strings = {"자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?"})
    void display(String inputGuide) {
        //given
        InputView inputView = new InputView(inputGuide);
        //when
        String result = inputView.display();
        //then
        assertThat(result).isEqualTo(inputGuide);
    }
}

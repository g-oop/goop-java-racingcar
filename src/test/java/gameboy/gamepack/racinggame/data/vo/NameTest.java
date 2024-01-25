package gameboy.gamepack.racinggame.data.vo;

import gameboy.gamepack.racinggame.exception.InvalidRacerNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static gameboy.gamepack.racinggame.data.vo.Name.MAX_NAME_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("도메인 - Name 테스트")
class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    public void initName_공백_검증(String name) {
        assertThatThrownBy(() -> new Name(name))
            .isInstanceOf(InvalidRacerNameException.class)
            .hasMessage("자동차 이름은 공백이 될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"초과한글이름", "OVERNAME", "123456"})
    public void initName_최대_길이_검증(String name) {
        assertThatThrownBy(() -> new Name(name))
            .isInstanceOf(InvalidRacerNameException.class)
            .hasMessage("자동차 이름이 " + MAX_NAME_SIZE + "글자를 초과할 수 없습니다.");
    }

}

package gameboy.gamepack.racinggame.data.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("도메인 - Position 테스트")
public class PositionTest {

    private static final int MIN_POSITION_VALUE = 0;

    @Test
    @DisplayName("위치 값 1 증가 테스트")
    void add() {
        //given
        Position position = new Position();
        //when
        position.addOne();
        //then
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("0미만 위치 값 오류 테스트")
    void position_0미만_테스트() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MIN_POSITION_VALUE + "미만의 포지션 생성: " + -1);
    }

    @ParameterizedTest
    @DisplayName("위치 값 반환 테스트")
    @ValueSource(ints = {1, 2})
    void getPosition(int value) {
        //given
        Position position = new Position(value);
        //when
        int result = position.value();
        //then
        assertThat(result).isEqualTo(value);
    }
}

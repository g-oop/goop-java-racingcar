package gameboy.gamepack.racinggame.data.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 - Position 테스트")
public class PositionTest {

    @Test
    @DisplayName("위치 값 증가 테스트")
    void add() {
        //given
        Position position = new Position();
        //when
        position.add();
        //then
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("위치 값 반환 테스트")
    void getPosition() {
        //given
        Position position = new Position();
        position.add();
        //when
        int result = position.getPosition();
        //then
        assertThat(result).isEqualTo(1);
    }
}

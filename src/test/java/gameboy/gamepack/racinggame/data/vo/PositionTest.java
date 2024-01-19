package gameboy.gamepack.racinggame.data.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("초기 Position의 add 결과 테스트")
    void add() {
        //given
        Position position = new Position();
        //when
        position.add();
        //then
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("초기 Position의 getPosition 결과 테스트")
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
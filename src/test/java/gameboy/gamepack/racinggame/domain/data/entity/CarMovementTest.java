package gameboy.gamepack.racinggame.domain.data.entity;

import gameboy.gamepack.racinggame.domain.data.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 - CarMovement 테스트")
class CarMovementTest {

    @Test
    @DisplayName("위치 이동 테스트")
    void move_이동_테스트() {
        //given
        Movement movement = new AlwaysMovement();
        Position position = new Position();
        //when
        Position result = movement.move(position);
        //then
        assertThat(result).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("위치 정지 테스트")
    void move_정지_테스트() {
        //given
        Movement movement = new StopMovement();
        Position position = new Position();
        //when
        Position result = movement.move(position);
        //then
        assertThat(result).isEqualTo(new Position());
    }
}

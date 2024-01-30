package gameboy.gamepack.racinggame.domain.data.entity;

import gameboy.gamepack.racinggame.domain.data.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarMovementTest {

    @ParameterizedTest
    @DisplayName("자동차 주행 테스트")
    @ValueSource(ints = {4, 9})
    void move_이동_테스트(int randomInt) {
        //given
        CarMovement car = new CarMovement(new TestRandom(randomInt));
        Position position = new Position();
        //when
        Position result = car.move(position);
        //then
        assertThat(result).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @DisplayName("자동차 정지 테스트")
    @ValueSource(ints = {0, 3})
    void move_정지_테스트(int randomInt) {
        //given
        CarMovement car = new CarMovement(new TestRandom(randomInt));
        Position position = new Position();
        //when
        Position result = car.move(position);
        //then
        assertThat(result).isEqualTo(new Position(0));
    }
}

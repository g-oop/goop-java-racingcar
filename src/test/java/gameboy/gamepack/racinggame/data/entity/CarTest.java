package gameboy.gamepack.racinggame.data.entity;

import gameboy.gamepack.racinggame.data.vo.Name;
import gameboy.gamepack.racinggame.data.vo.Position;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 - Car 테스트")
class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 주행 테스트")
    @ValueSource(ints = {4, 9})
    void run_주행_테스트(int randomInt) {
        //given
        Car car = new Car(new Name("테스터"), new TestRandom(randomInt));
        //when
        car.run();
        //then
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @DisplayName("자동차 정지 테스트")
    @ValueSource(ints = {0, 3})
    void run_정지_테스트(int randomInt) {
        //given
        Car car = new Car(new Name("테스터"), new TestRandom(randomInt));
        //when
        car.run();
        //then
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}

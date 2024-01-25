package gameboy.gamepack.racinggame.data.entity;

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
        Car car = new Car(new TestRandom(randomInt));
        //when
        car.run();
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차 정지 테스트")
    @ValueSource(ints = {0, 3})
    void run_정지_테스트(int randomInt) {
        //given
        Car car = new Car(new TestRandom(randomInt));
        //when
        car.run();
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}

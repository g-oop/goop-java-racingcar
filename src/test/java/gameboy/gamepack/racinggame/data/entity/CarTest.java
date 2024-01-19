package gameboy.gamepack.racinggame.data.entity;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @Test
    @DisplayName("초기 Car의 run 결과 테스트")
    void run() {
        //given
        Car car = new Car();
        //when
        car.run();
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
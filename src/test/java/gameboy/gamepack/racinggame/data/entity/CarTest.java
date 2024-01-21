package gameboy.gamepack.racinggame.data.entity;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 - Car 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 주행 테스트")
    void run() {
        //given
        Car car = new Car();
        //when
        car.run();
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}

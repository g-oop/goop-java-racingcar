package gameboy.gamepack.racinggame.domain.data.entity;

import gameboy.gamepack.racinggame.domain.data.entity.Car;
import gameboy.gamepack.racinggame.domain.data.vo.Name;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 - Car 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 불변 클레스 결과 불일치 테스트")
    void run() {
        //given
        Car givenCar = new Car(new Name("테스터"));
        //when
        Car result = givenCar.run();
        //then
        assertThat(result).isNotEqualTo(givenCar);
    }
}

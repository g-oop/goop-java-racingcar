package gameboy.gamepack.racinggame.domain.data.entity;

import gameboy.gamepack.racinggame.domain.data.vo.Name;
import gameboy.gamepack.racinggame.domain.data.vo.Position;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 - Car 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 불변 클레스 결과 불일치 테스트")
    void run_불변_테스트() {
        //given
        Car givenCar = new Car(new Name("테스터"));
        //when
        Car result = givenCar.run();
        //then
        assertThat(result).isNotEqualTo(givenCar);
    }

    @Test
    @DisplayName("자동차 주행 테스트")
    void run_주행_테스트() {
        //given
        Car givenCar = new AlwaysRunCar(new Name("테스터"));
        //when
        Car result = givenCar.run();
        //then
        assertThat(result.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("자동차 정지 테스트")
    void run_정지_테스트() {
        //given
        Car givenCar = new AlwaysStopCar(new Name("테스터"));
        //when
        Car result = givenCar.run();
        //then
        assertThat(result.getPosition()).isEqualTo(new Position());
    }
}

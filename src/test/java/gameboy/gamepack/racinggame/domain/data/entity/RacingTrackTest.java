package gameboy.gamepack.racinggame.domain.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.domain.data.entity.Car;
import gameboy.gamepack.racinggame.domain.data.entity.RacingTrack;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("도메인 - RacingTrack 테스트")
class RacingTrackTest {

    @Test
    @DisplayName("레이싱 경주 운전자 미참가 오류 테스트")
    void initRacingTrack_driver_0명_테스트() {
        List<Car> cars = new ArrayList<>();
        assertThatThrownBy(() -> new RacingTrack(cars))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("race 참가자가 0명 이하일 수 없습니다");
    }
}

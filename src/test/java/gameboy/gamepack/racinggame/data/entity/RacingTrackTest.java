package gameboy.gamepack.racinggame.data.entity;

import java.util.List;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.data.vo.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("도메인 - RacingTrack 테스트")
class RacingTrackTest {

    @Test
    @DisplayName("레이싱 경주 결과값 유효 테스트")
    void startRace_유효값() {
        //given
        Referee referee = new Referee();
        RacingTrack racingTrack = new RacingTrack(List.of(new Car()), referee);
        List<Car> cars = List.of(
            new Car(new Name(), new Position())
        );
        referee.record(cars);
        //when
        RaceResultDto result = racingTrack.startRace(1);
        //then
        assertThat(result).isEqualTo(RaceResultDto.of(referee.playback(), referee.getWinnerNames()));
    }

    @ParameterizedTest
    @DisplayName("레이싱 경주 0명 이하 참가 오류 테스트")
    @ValueSource(ints = {0, -1})
    void initRacingTrack_0이하_테스트(int driverCount) {
        assertThatThrownBy(() -> new RacingTrack(driverCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("race 참가자가 0명 이하일 수 없습니다");
    }

    @Test
    @DisplayName("레이싱 경주 운전자 미참가 오류 테스트")
    void initRacingTrack_driver_0명_테스트() {
        assertThatThrownBy(RacingTrack::new)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("race 참가자가 0명 이하일 수 없습니다");
    }
}

package gameboy.gamepack.racinggame.data.entity;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTrackTest {

    @ParameterizedTest
    @DisplayName("raceOneTime 결과값 길이 테스트")
    @ValueSource(ints = {0, 10})
    void raceOneTime_결과_길이(int driverCount) {
        //given
        RacingTrack racingTrack = new RacingTrack(driverCount);
        //when
        List<Integer> result = racingTrack.raceOneTime();
        //then
        assertThat(result).size().isEqualTo(driverCount);
    }

    @ParameterizedTest
    @DisplayName("raceOneTime 결과값 유효 테스트")
    @ValueSource(ints = {1, 10})
    void raceOneTime_유효값(int driverCount) {
        //given
        RacingTrack racingTrack = new RacingTrack(driverCount);
        //when
        List<Integer> result = racingTrack.raceOneTime();
        //then
        assertThat(result).contains(0, 1);
    }
}
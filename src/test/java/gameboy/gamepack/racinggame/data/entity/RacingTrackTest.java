package gameboy.gamepack.racinggame.data.entity;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("도메인 - RacingTrack 테스트")
class RacingTrackTest {

    @ParameterizedTest
    @DisplayName("레이싱 경주 결과값 길이 테스트")
    @ValueSource(ints = {1, 2})
    void raceOneTime_결과_길이(int driverCount) {
        //given
        RacingTrack racingTrack = new RacingTrack(driverCount);
        //when
        List<Integer> result = racingTrack.startRace();
        //then
        assertThat(result).size().isEqualTo(driverCount);
    }

    @ParameterizedTest
    @DisplayName("레이싱 경주 결과값 유효 테스트")
    @CsvSource(value = {
        "4:0:1:0",
        "10:3:1:0",
        "0:4:0:1",
        "3:10:0:1"
        }
        , delimiter = ':'
    )
    void raceOneTime_유효값(int randomInt1, int randomInt2, int expected1, int expected2) {
        //given
        RacingTrack racingTrack = new RacingTrack(
            new Driver(new TestRandom(randomInt1)),
            new Driver(new TestRandom(randomInt2))
        );
        //when
        List<Integer> result = racingTrack.startRace();
        //then
        assertThat(result).containsExactly(expected1, expected2);
    }

    @ParameterizedTest
    @DisplayName("레이싱 경주 0명 이하 참가 오류 테스트")
    @ValueSource(ints = {0, -1})
    void raceOneTime_0이하_테스트(int driverCount) {
        assertThatThrownBy(() -> new RacingTrack(driverCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("race 참가자가 0명 이하일 수 없습니다: " + driverCount);
    }

    @Test
    @DisplayName("레이싱 경주 운전자 미참가 오류 테스트")
    void raceOneTime_driver_0명_테스트() {
        assertThatThrownBy(RacingTrack::new)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("race 참가자가 0명 이하일 수 없습니다: 0");
    }
}

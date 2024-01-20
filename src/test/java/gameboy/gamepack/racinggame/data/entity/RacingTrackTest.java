package gameboy.gamepack.racinggame.data.entity;

import java.util.List;

import gameboy.gamepack.racinggame.data.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 - RacingTrack 테스트")
class RacingTrackTest {

    @ParameterizedTest
    @DisplayName("레이싱 경주 결과값 길이 테스트")
    @ValueSource(ints = {0, 10})
    void raceOneTime_결과_길이(int driverCount) {
        //given
        RacingTrack racingTrack = new RacingTrack(driverCount);
        //when
        racingTrack.raceOneTime();
        //then
        assertThat(racingTrack.getResult()).size().isEqualTo(driverCount);
    }

    @ParameterizedTest
    @DisplayName("레이싱 경주 결과값 유효 테스트")
    @ValueSource(ints = {1, 10})
    void raceOneTime_유효값(int driverCount) {
        //given
        RacingTrack racingTrack = new RacingTrack(driverCount);
        //when
        racingTrack.raceOneTime();
        //then
        checkRaceResult(racingTrack);
    }

    void checkRaceResult(RacingTrack racingTrack) {
        List<Car> result = racingTrack.getResult();
        result.stream().forEach(this::validCarPosition);
    }

    void validCarPosition(Car car) {
        if (isRun(car)) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
        if (!isRun(car)) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    boolean isRun(Car car) {
        Position runPosition = new Position(1);
        return car.getPosition() == runPosition.getPosition();
    }
}

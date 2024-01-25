package gameboy.gamepack.racinggame.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.data.vo.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceRecorderTest {

    private List<RaceLog> raceLogs;

    @BeforeEach
    void setUpRaceLogs() {
        raceLogs = new ArrayList<>();
        raceLogs.add(new RaceLog(setUpCars(0)));
        raceLogs.add(new RaceLog(setUpCars(1)));
        raceLogs.add(new RaceLog(setUpCars(2)));

    }

    private List<Car> setUpCars(int addPosition) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Name("일번말"), new Position(1 + addPosition)));
        cars.add(new Car(new Name("이번말"), new Position(2 + addPosition)));
        cars.add(new Car(new Name("삼번말"), new Position(3 + addPosition)));
        cars.add(new Car(new Name("삼번말"), new Position(3 + addPosition)));
        return cars;
    }

    @Test
    @DisplayName("마지막 경기 결과 로그 조회 테스트")
    void playbackLastLog() {
        //given
        RaceRecorder raceRecorder = new RaceRecorder(raceLogs);
        //when
        RaceLog result = raceRecorder.playbackLastLog();
        //then
        assertThat(result).isEqualTo(raceLogs.get(raceLogs.size() - 1));
    }

    @Test
    @DisplayName("기록이 없을 때 조회 테스트")
    void playbackLastLog_NO_RECORD() {
        //given
        RaceRecorder raceRecorder = new RaceRecorder();
        //when
        assertThatThrownBy(raceRecorder::playbackLastLog)
            .isInstanceOf(NoSuchElementException.class)
            .hasMessage("기록된 경기가 없습니다.");
    }
}

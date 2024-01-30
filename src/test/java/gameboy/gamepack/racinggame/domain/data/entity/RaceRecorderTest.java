package gameboy.gamepack.racinggame.domain.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.domain.data.entity.Car;
import gameboy.gamepack.racinggame.domain.data.entity.RaceRecorder;
import gameboy.gamepack.racinggame.domain.data.vo.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceRecorderTest {

    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUpCars() {
        cars.add(new Car(new Name("일번말"), new Position(1)));
        cars.add(new Car(new Name("이번말"), new Position(2)));
        cars.add(new Car(new Name("삼번말"), new Position(3)));
        cars.add(new Car(new Name("삼번말"), new Position(3)));
    }

    @Test
    @DisplayName("마지막 경기 결과 로그 조회 테스트")
    void playbackLastLog() {
        //given
        RaceRecorder raceRecorder = new RaceRecorder();
        raceRecorder.record(cars);
        //when
        RaceLog result = raceRecorder.playbackLastLog();
        //then
        assertThat(result.getCars()).isEqualTo(cars);
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

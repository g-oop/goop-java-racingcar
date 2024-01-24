package gameboy.gamepack.racinggame.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.data.vo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 - RefereeTest 테스트")
class RefereeTest {

    @Test
    @DisplayName("우승자 단일 우승 테스트")
    void getWinners_단일우승() {
        //given
        Referee referee = new Referee();
        List<Car> status = List.of(
            new Car(new Name("car1"), new Position(1)),
            new Car(new Name("car2"), new Position(2)),
            new Car(new Name("car3"), new Position(3))
        );
        referee.record(status);
        //when
        List<String> strings = referee.getWinners();
        //then
        assertThat(strings).contains("car3");
    }

    @Test
    @DisplayName("우승자 공동 우승 테스트")
    void getWinners_공동우승() {
        //given
        Referee referee = new Referee();
        List<Car> status = List.of(
            new Car(new Name("car1"), new Position(1)),
            new Car(new Name("car2"), new Position(3)),
            new Car(new Name("car3"), new Position(3))
        );
        referee.record(status);
        //when
        List<String> strings = referee.getWinners();
        //then
        assertThat(strings).contains("car2", "car3");
    }
}

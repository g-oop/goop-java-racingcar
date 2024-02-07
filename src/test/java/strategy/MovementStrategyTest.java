package strategy;

import java.util.List;

import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementStrategyTest {


    @DisplayName("랜덤값이 3이하일떄 정지 테스트")
    @Test
    public void generateRandomValueForStop() {
        Cars cars = getCars();
        RacingGame racingGame = new RacingGame(new AlwaysReturn0Generator(), cars, new String[] {"a", "b", "c"});
        List<String> winnerNames = racingGame.play(5);

        // 항상 0이 나오니까 모두 제자리에 있을 것임. 그래서 우승자는 모두
        assertThat(winnerNames).contains("a");
        assertThat(winnerNames).contains("b");
        assertThat(winnerNames).contains("c");
    }

    private static Cars getCars() {
        return new Cars();
    }

    @DisplayName("랜덤값이 4이상일떄 움직임 테스트")
    @Test
    public void generateRandomValueForMove() {
        Cars cars = getCars();
        RacingGame racingGame = new RacingGame(new AlwaysReturn5Generator(), cars, new String[] {"a", "b", "c"});
        List<String> winnerNames = racingGame.play(5);

        // 항상 0이 나오니까 모두 제자리에 있을 것임. 그래서 우승자는 모두
        assertThat(winnerNames).contains("a");
        assertThat(winnerNames).contains("b");
        assertThat(winnerNames).contains("c");

    }
}

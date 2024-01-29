package racingcar.racing;

import java.util.List;

public record RacingPreference(
    List<String> carNames,
    int moveCount
) {
}

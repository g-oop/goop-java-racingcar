package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.entity.car.Cars;

public class RacingGameResult {
    private final List<RacingGameState> gameStateHistory;

    public RacingGameResult() {
        this.gameStateHistory = new ArrayList<>();
    }

    public void logCurrentState(Cars cars) {
        gameStateHistory.add(RacingGameState.of(cars));
    }

    public List<RacingGameState> getGameStateHistory() {
        return gameStateHistory;
    }

}

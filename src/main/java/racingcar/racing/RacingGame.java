package racingcar.racing;

import racingcar.entry.MovePolicy;
import racingcar.entry.RandomMovePolicy;
import racingcar.ui.ConsoleRacingUi;
import racingcar.ui.RacingUi;

import java.util.List;

public class RacingGame {

    private final RacingPreference preference;
    private final RacingEntries racingEntries;

    public RacingGame(RacingPreference preference, MovePolicy movePolicy) {
        if (preference == null) {
            throw new IllegalArgumentException("게임 속성이 지정되지 않았습니다.");
        }

        this.preference = preference;
        List<String> carNames = this.preference.carNames();
        this.racingEntries = RacingEntries.of(carNames, movePolicy);
    }

    public RacingResult race() {
        RacingResult result = new RacingResult();
        RacingEntries currentEntries = racingEntries;
        for (int i = 0; i < preference.moveCount(); i++) {
            currentEntries = currentEntries.move();
            result.recordSnapshot(currentEntries);
        }
        return result;
    }


    public static void main(String[] args) {
        RacingUi racingUi = new ConsoleRacingUi();
        RacingPreference preference = racingUi.inputPreference();
        RacingGame racingGame = new RacingGame(preference, new RandomMovePolicy());
        racingUi.showResult(racingGame.race());
    }
}

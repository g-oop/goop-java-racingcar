package racingcar.racing;

import racingcar.entry.MovePolicy;
import racingcar.entry.RandomMovePolicy;
import racingcar.ui.ConsoleRacingUi;
import racingcar.ui.RacingUi;

public class RacingGame {

    private final RacingPreference preference;
    private final RacingEntries racingEntries;

    public RacingGame(RacingPreference preference) {
        this(preference, null);
    }

    public RacingGame(RacingPreference preference, MovePolicy movePolicy) {
        if (preference == null) {
            throw new IllegalArgumentException("게임 속성이 지정되지 않았습니다.");
        }

        this.preference = preference;
        this.racingEntries = new RacingEntries(this.preference.carCount(), movePolicy);
    }

    public RacingEntries getRacingEntries() {
        return racingEntries;
    }

    public int getRacingEntryCount() {
        return racingEntries.getEntryCount();
    }

    public RacingResult race() {
        RacingResult result = new RacingResult();
        for (int i = 0; i < preference.moveCount(); i++) {
            racingEntries.move();
            result.recordSnapshot(new RacingEntries(racingEntries));
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

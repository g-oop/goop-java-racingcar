package racingcar.racing;

import racingcar.ui.RacingConsoleUi;

import java.util.Random;

public class RacingGame {

    private final RacingPreference preference;
    private final RacingEntries racingEntries;
    private final RacingUi racingUi;


    public RacingGame(RacingPreference preference, RacingUi racingUi, Random random) {
        if (preference == null) {
            throw new IllegalArgumentException("RacingPreference 값을 지정해 주세요.");
        }

        this.preference = preference;
        this.racingEntries = new RacingEntries(this.preference.carCount(), random);
        this.racingUi = racingUi;
    }

    public RacingEntries getRacingEntries() {
        return this.racingEntries;
    }

    public int getRacingEntryCount() {
        return this.racingEntries.getEntryCount();
    }

    public void start() {
        for (int i = 0; i < preference.moveCount(); i++) {
            racingEntries.move();
            showStatus();
        }
    }

    private void showStatus() {
        racingUi.showStatus(this);
    }


    public static void main(String[] args) {
        RacingUi racingUi = new RacingConsoleUi();
        RacingPreference preference = racingUi.inputPreference();
        RacingGame racingGame = new RacingGame(preference, racingUi, new Random());
        racingGame.start();
    }
}

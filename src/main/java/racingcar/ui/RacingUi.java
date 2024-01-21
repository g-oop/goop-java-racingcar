package racingcar.ui;

import racingcar.racing.RacingPreference;
import racingcar.racing.RacingResult;

public interface RacingUi {

    RacingPreference inputPreference();

    void showResult(RacingResult result);
}

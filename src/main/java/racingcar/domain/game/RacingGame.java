package racingcar.domain.game;

import java.util.List;

import racingcar.domain.car.Car;
import racingcar.view.RacingGameView;

public class RacingGame implements Game {

    private final RacingGameView view;
    private final RacingGameSetting setting;

    public RacingGame(RacingGameSetting setting, RacingGameView view) {
        this.setting = setting;
        this.view = view;
    }

    @Override
    public void start() {
        for (int i = 0; i < setting.attemptCount(); i++) {
            moveCars();
            printCurrentStatus();
        }
    }


    public void moveCars() {
        for (Car car: setting.cars()) {
            car.move();
        }
    }

    public void printCurrentStatus() {
        view.printCurrentStatus(this);
    }

    public List<Car> getCars() {
        return setting.cars();
    }

    public int getAttempts(){
        return setting.attemptCount();
    }


}

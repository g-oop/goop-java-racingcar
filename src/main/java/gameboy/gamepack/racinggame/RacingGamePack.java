package gameboy.gamepack.racinggame;

import java.util.List;

import gameboy.gamepack.GamePack;
import gameboy.gamepack.racinggame.data.entity.Car;
import gameboy.gamepack.racinggame.data.entity.RacingTrack;
import gameboy.gamepack.racinggame.view.InputView;
import gameboy.gamepack.racinggame.view.ResultView;
import gameboy.gamepalyer.console.InputConsole;
import gameboy.gamepalyer.console.OutputConsole;

public class RacingGamePack implements GamePack {

    private RacingTrack racingTrack;

    @Override
    public void play() {
        initializeRacingTrack();

        int raceCount = InputConsole.askUserInput(askHowManyRace());
        for (int i = 0; i < raceCount; i++) {
            List<Car> raceResult = racingTrack.startRace();
            OutputConsole.displayOutput(new ResultView(raceResult));
        }
    }

    private void initializeRacingTrack() {
        int driverCount = InputConsole.askUserInput(askHowManyRacerEngage());
        racingTrack = new RacingTrack(driverCount);
    }

    private InputView askHowManyRacerEngage() {
        return new InputView("자동차 대수는 몇 대 인가요?");
    }

    private InputView askHowManyRace() {
        return new InputView("시도할 회수는 몇 회 인가요?");
    }

}

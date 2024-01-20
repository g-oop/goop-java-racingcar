package gameboy.gamepack.racinggame;

import java.util.List;

import gameboy.gamepack.GamePack;
import gameboy.gamepack.racinggame.data.entity.Car;
import gameboy.gamepack.racinggame.data.entity.RacingTrack;
import gameboy.gamepack.racinggame.view.ResultView;
import gameboy.gamepalyer.console.InputConsole;
import gameboy.gamepalyer.console.OutputConsole;

public class RacingGamePack implements GamePack {

    private RacingTrack racingTrack;

    @Override
    public void play() {
        initializeRacingTrack();

        int raceCount = InputConsole.inputNumber("시도할 회수는 몇 회 인가요?");
        for (int i = 0; i < raceCount; i++) {
            List<Car> raceResult = racingTrack.startRace();
            OutputConsole.displayOutput(ResultView.getRaceResult(raceResult));
        }
    }

    private void initializeRacingTrack() {
        int driverCount = InputConsole.inputNumber("자동차 대수는 몇 대 인가요?");
        racingTrack = new RacingTrack(driverCount);
    }
}

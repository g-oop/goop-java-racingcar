package gameboy.gamepack.racinggame;

import gameboy.gamepack.GamePack;
import gameboy.gamepack.racinggame.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.data.entity.RacingTrack;
import gameboy.gamepack.racinggame.view.InputView;
import gameboy.gamepack.racinggame.view.ResultView;

public class RacingGamePack implements GamePack {


    @Override
    public void play() {
        RacingTrack racingTrack = initializeRacingTrack();

        int raceCount = InputView.inputNumber("시도할 회수는 몇 회 인가요?");
        for (int i = 0; i < raceCount; i++) {
            RaceResultDto raceResult = racingTrack.startRace();
            ResultView.display(raceResult);
        }
    }

    private RacingTrack initializeRacingTrack() {
        int driverCount = InputView.inputNumber("자동차 대수는 몇 대 인가요?");
        return new RacingTrack(driverCount);
    }
}

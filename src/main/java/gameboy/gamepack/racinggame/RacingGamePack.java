package gameboy.gamepack.racinggame;

import java.util.List;

import gameboy.gamepack.GamePack;
import gameboy.gamepack.racinggame.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.data.entity.Driver;
import gameboy.gamepack.racinggame.data.entity.RacingTrack;
import gameboy.gamepack.racinggame.data.vo.Name;
import gameboy.gamepack.racinggame.view.InputView;
import gameboy.gamepack.racinggame.view.ResultView;

public class RacingGamePack implements GamePack {

    @Override
    public void play() {
        RacingTrack racingTrack = initializeRacingTrack();

        int raceCount = InputView.inputRaceCount();
        RaceResultDto raceResult = racingTrack.startRace(raceCount);
        ResultView resultView = new ResultView();
        resultView.display(raceResult);
    }

    private RacingTrack initializeRacingTrack() {
        List<Name> racerNames = InputView.inputCarsName();
        List<Driver> drivers = racerNames.stream().map(Driver::new).toList();
        return new RacingTrack(drivers);
    }
}

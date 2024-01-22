package gameboy.gamepack.racinggame;

import java.util.List;

import gameboy.gamepack.GamePack;
import gameboy.gamepack.racinggame.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.data.entity.Driver;
import gameboy.gamepack.racinggame.data.entity.RacingTrack;
import gameboy.gamepack.racinggame.view.InputView;
import gameboy.gamepack.racinggame.view.ResultView;

public class RacingGamePack implements GamePack {

    @Override
    public void play() {
        RacingTrack racingTrack = initializeRacingTrack();

        int raceCount = InputView.inputNumber("시도할 회수는 몇 회 인가요?");
        RaceResultDto raceResult = racingTrack.startRace(raceCount);
        ResultView resultView = new ResultView();
        resultView.display(raceResult);
    }

    private RacingTrack initializeRacingTrack() {
        List<String> racerNames = InputView.inputRacerName("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<Driver> drivers = racerNames.stream().map(Driver::new).toList();
        return new RacingTrack(drivers);
    }
}

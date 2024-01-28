package gameboy.gamepack.racinggame;

import java.util.List;

import gameboy.gamepack.GamePack;
import gameboy.gamepack.racinggame.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.data.entity.Car;
import gameboy.gamepack.racinggame.data.entity.RacingTrack;
import gameboy.gamepack.racinggame.data.vo.Name;
import gameboy.gamepack.racinggame.exception.InvalidRacerNameException;
import gameboy.gamepack.racinggame.view.InputView;
import gameboy.gamepack.racinggame.view.ResultView;

public class RacingGamePack implements GamePack {

    @Override
    public void play() {
        RacingTrack racingTrack = initializeRacingTrack();

        int raceCount = InputView.inputRaceCount();
        RaceResultDto raceResult = racingTrack.startRace(raceCount);
        ResultView.display(raceResult);
    }

    private RacingTrack initializeRacingTrack() {
        return initializeRacingTrack(null);
    }

    private RacingTrack initializeRacingTrack(String message) {
        try{
            return new RacingTrack(initializeCars(message));
        } catch (InvalidRacerNameException e) {
            return initializeRacingTrack(e.getMessage());
        }
    }

    private List<Car> initializeCars(String message) {
        return initializeNames(message)
            .stream()
            .map(Car::new)
            .toList();
    }

    private List<Name> initializeNames(String message) {
        if (message == null || message.isBlank()) {
            return InputView.inputCarsName();
        }
        return InputView.inputCarsName(message);
    }
}

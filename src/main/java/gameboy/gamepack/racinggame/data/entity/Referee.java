package gameboy.gamepack.racinggame.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.data.vo.Position;
import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class Referee {

    private static final int MIN_POSITION_VALUE = 0;

    private RaceRecorder recorder;

    public Referee() {
        this.recorder = new RaceRecorder();
    }

    public void record(List<Car> cars) {
        recorder.record(cars);
    }

    public List<RaceLog> playback() {
        return recorder.playback();
    }

    public List<Car> getWinner() {
        RaceLog raceLog = recorder.playbackLastLog();
        Position winnerPosition = getWinnerPosition(raceLog);
        return raceLog.getCars()
            .stream()
            .filter(car -> car.isSamePosition(winnerPosition))
            .toList();
    }

    private Position getWinnerPosition(RaceLog raceLog) {
        return raceLog.getCars()
            .stream()
            .map(Car::getPosition)
            .max(Position::compareTo)
            .orElse(new Position(MIN_POSITION_VALUE));
    }

}

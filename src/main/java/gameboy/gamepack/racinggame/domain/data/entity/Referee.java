package gameboy.gamepack.racinggame.domain.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.domain.data.vo.Position;
import gameboy.gamepack.racinggame.domain.data.vo.RaceLog;

public class Referee {

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

    public List<Car> getWinners() {
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
            .orElse(Position.MIN);
    }

}

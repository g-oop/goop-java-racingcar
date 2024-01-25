package gameboy.gamepack.racinggame.data.entity;

import java.util.*;

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

    public List<String> getWinnerNames() {
        RaceLog raceLog = recorder.playbackLastLog();
        int winnerPosition = getWinnerPosition(raceLog);
        return raceLog.getCars().stream().filter(car -> car.isWin(winnerPosition)).map(Car::getName).toList();
    }

    private int getWinnerPosition(RaceLog raceLog) {
        return raceLog.getCars().stream().mapToInt(Car::getPosition).max().orElse(MIN_POSITION_VALUE);
    }

}

package gameboy.gamepack.racinggame.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class Referee {

    private RaceRecorder recorder;
    private int winnerPosition = 0;

    public Referee() {
        this.recorder = new RaceRecorder();
    }

    public void record(List<Car> cars) {
        recorder.record(cars);
    }

    public List<RaceLog> playback() {
        return recorder.playback();
    }

    public List<String> getWinners() {
        RaceLog raceLog = recorder.playbackLastLog();
        int firstPosition = raceLog.getCars().stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winnerNames = new ArrayList<>();
        raceLog.getCars().forEach(status -> {if(firstPosition <= status.getPosition()) {winnerNames.add(status.getName());}});
        return winnerNames;
    }

}

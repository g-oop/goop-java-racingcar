package gameboy.gamepack.racinggame.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.data.vo.CarStatus;
import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class Referee {

    private RaceRecorder recorder;
    private int winnerPosition = 0;

    public Referee() {
        this.recorder = new RaceRecorder();
    }

    public void record(List<CarStatus> status) {
        recorder.record(status);
    }

    public List<RaceLog> playback() {
        return recorder.playback();
    }

    public List<String> getWinners() {
        RaceLog raceLog = recorder.playbackLastLog();
        int firstPosition = raceLog.getStatuses().stream().mapToInt(CarStatus::getPosition).max().orElse(0);
        List<String> winnerNames = new ArrayList<>();
        raceLog.getStatuses().forEach(status -> {if(firstPosition <= status.getPosition()) {winnerNames.add(status.getName());}});
        return winnerNames;
    }

    private void checkWin(CarStatus status, Set<String> winnerNames) {
        if(winnerPosition < status.getPosition()){
            winnerNames.clear();
            winnerNames.add(status.getName());
            winnerPosition = status.getPosition();
        }
    }

    private void checkDraw(CarStatus status, Set<String> winnerNames) {
        if(winnerPosition == status.getPosition()) {
            winnerNames.add(status.getName());
        }
    }
}

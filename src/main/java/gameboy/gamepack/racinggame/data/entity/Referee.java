package gameboy.gamepack.racinggame.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.data.vo.CarStatus;
import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class Referee {

    private RaceRecorder recorder;
    private static final ThreadLocal<Integer> winnerPosition = ThreadLocal.withInitial( () -> 0);
    public Referee() {
        this.recorder = new RaceRecorder();
    }

    public void record(List<CarStatus> status) {
        recorder.record(status);
    }

    public List<RaceLog> playback() {
        return recorder.playback();
    }

    public Set<String> getWinners() {
        RaceLog raceLog = recorder.playbackLastLog();

        Set<String> winnerNames = new HashSet<>();
        for(CarStatus status: raceLog.getStatuses()) {
            checkWin(status, winnerNames);
            checkDraw(status, winnerNames);
        }
        winnerPosition.remove();
        return winnerNames;
    }

    private void checkWin(CarStatus status, Set<String> winnerNames) {
        if(winnerPosition.get() < status.getPosition()){
            winnerNames.clear();
            winnerNames.add(status.getName());
            winnerPosition.set(status.getPosition());
        }
    }

    private void checkDraw(CarStatus status, Set<String> winnerNames) {
        if(winnerPosition.get() == status.getPosition()) {
            winnerNames.add(status.getName());
        }
    }
}

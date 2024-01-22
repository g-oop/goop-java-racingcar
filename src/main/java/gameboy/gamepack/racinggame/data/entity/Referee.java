package gameboy.gamepack.racinggame.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.data.vo.CarStatus;
import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class Referee {

    private RaceRecorder recorder;

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
        Integer winnerPosition = 0;
        Set<String> winnerNames = new HashSet<>();
        for(CarStatus status: raceLog.getStatuses()) {
            if(winnerPosition < status.getPosition()){
                winnerNames = new HashSet<>();
                winnerNames.add(status.getName());
                winnerPosition = status.getPosition();
            }
            if(winnerPosition == status.getPosition()) {
                winnerNames.add(status.getName());
            }
        }
        return winnerNames;
    }
}

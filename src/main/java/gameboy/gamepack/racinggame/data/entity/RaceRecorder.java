package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.data.vo.RaceLog;
import gameboy.gamepack.racinggame.data.vo.CarStatus;

public class RaceRecorder {

    private List<RaceLog> logs = new ArrayList<>();

    public void record(List<CarStatus> status) {
        this.logs.add(new RaceLog(status));
    }

    public List<RaceLog> playback() {
        return logs;
    }

    public RaceLog playbackLastLog() {
        return logs.get(logs.size() - 1);
    }
}

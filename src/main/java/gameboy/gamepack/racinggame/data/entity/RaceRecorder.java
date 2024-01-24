package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class RaceRecorder {

    private List<RaceLog> logs = new ArrayList<>();

    public void record(List<Car> cars) {
        this.logs.add(new RaceLog(cars));
    }

    public List<RaceLog> playback() {
        return logs;
    }

    public RaceLog playbackLastLog() {
        return logs.get(logs.size() - 1);
    }
}

package gameboy.gamepack.racinggame.data.entity;

import java.util.*;

import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class RaceRecorder {

    private List<RaceLog> logs = new ArrayList<>();

    public void record(List<Car> cars) {
        this.logs.add(new RaceLog(cars));
    }

    public List<RaceLog> playback() {
        validationLogs();
        return logs;
    }

    public RaceLog playbackLastLog() {
        validationLogs();
        return logs.get(logs.size() - 1);
    }

    private void validationLogs() {
        if (logs.isEmpty()) {
            throw new NoSuchElementException("기록된 경기가 없습니다.");
        }
    }
}

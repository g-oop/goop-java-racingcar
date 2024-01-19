package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.view.ResultView;
import gameboy.gamepalyer.console.OutputConsole;

public class RacingTrack {

    private List<Driver> drivers = new ArrayList<>();

    private RacingTrack(int driverCount) {
        engageDriver(driverCount);
    }

    private void engageDriver(int driverCount) {
        for (int i = 0; i < driverCount; i++) {
            drivers.add(new Driver());
        }
    }

    public void startRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            OutputConsole.displayOutput(raceOneTime());
        }
    }

    private ResultView raceOneTime() {
        return new ResultView(drivers.stream().map(Driver::drive).toList());
    }

    public static RacingTrack of(int driverCount) {
        return new RacingTrack(driverCount);
    }
}

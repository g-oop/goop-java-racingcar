package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.view.ResultView;
import gameboy.gamepalyer.console.OutputConsole;

public class RacingTrack {

    private List<Driver> drivers = new ArrayList<>();

    public RacingTrack(int driverCount) {
        engageDriver(driverCount);
    }

    private void engageDriver(int driverCount) {
        for (int i = 0; i < driverCount; i++) {
            drivers.add(new Driver());
        }
    }

    public void startRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            OutputConsole.displayOutput(getResult(raceOneTime()));
        }
    }

    public List<Integer> raceOneTime() {
        return drivers.stream().map(Driver::drive).toList();
    }

    public ResultView getResult(List<Integer> racerPosition) {
        return new ResultView(racerPosition);
    }
}

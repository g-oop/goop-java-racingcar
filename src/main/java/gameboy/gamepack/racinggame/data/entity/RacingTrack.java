package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

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

    public List<Car> startRace() {
        raceOneTime();
        return getResult();
    }

    public void raceOneTime() {
        drivers.stream().forEach(Driver::drive);
    }

    public List<Car> getResult() {
        return drivers.stream().map(Driver::getCar).toList();
    }

}

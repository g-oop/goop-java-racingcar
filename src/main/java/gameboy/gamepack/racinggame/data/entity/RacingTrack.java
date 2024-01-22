package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;

public class RacingTrack {

    private List<Driver> drivers;

    public RacingTrack(int driverCount) {
        this(engageDriver(driverCount));
    }

    private static List<Driver> engageDriver(int driverCount) {
        List<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < driverCount; i++) {
            drivers.add(new Driver());
        }
        return drivers;
    }

    public RacingTrack(List<Driver> drivers) {
        validationDriverCount(drivers);
        this.drivers = drivers;
    }

    public RacingTrack(Driver... drivers) {
        this(List.of(drivers));
    }

    private void validationDriverCount(List<Driver> drivers) {
        if (drivers.size() == 0) {
            throw new IllegalArgumentException("race 참가자가 0명 이하일 수 없습니다");
        }
    }

    public RaceResultDto startRace() {
        drivers.forEach(Driver::drive);
        return RaceResultDto.of(getCarsPosition());
    }

    private List<Integer> getCarsPosition() {
        return drivers.stream().map(Driver::getCarPosition).toList();
    }

}

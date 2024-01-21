package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;

public class RacingTrack {

    private List<Driver> drivers = new ArrayList<>();

    public RacingTrack(int driverCount) {
        validationDriverCount(driverCount);
        engageDriver(driverCount);
    }

    private void validationDriverCount(Integer driverCount) {
        if (driverCount.intValue() <= 0) {
            throw new IllegalArgumentException("race 참가자가 0명 이하일 수 없습니다: " + driverCount);
        }
    }

    public RacingTrack(Driver... drivers) {
        validationDriverCount(drivers);
        this.drivers = List.of(drivers);
    }

    private void validationDriverCount(Driver... drivers) {
        if (drivers.length == 0) {
            throw new IllegalArgumentException("race 참가자가 0명 이하일 수 없습니다: " + drivers.length);
        }
    }

    private void engageDriver(int driverCount) {
        for (int i = 0; i < driverCount; i++) {
            drivers.add(new Driver());
        }
    }

    public RaceResultDto startRace() {
        drivers.stream().forEach(Driver::drive);
        return RaceResultDto.of(getCarsPosition());
    }

    private List<Integer> getCarsPosition() {
        return drivers.stream().map(Driver::getCarPosition).toList();
    }

}

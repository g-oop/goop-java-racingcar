package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.data.vo.CarStatus;

public class RacingTrack {

    private List<Driver> drivers;
    private Referee referee;

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
        this.referee = new Referee();
    }

    public RacingTrack(Driver... drivers) {
        this(List.of(drivers));
    }

    private void validationDriverCount(List<Driver> drivers) {
        if (drivers.size() == 0) {
            throw new IllegalArgumentException("race 참가자가 0명 이하일 수 없습니다");
        }
    }

    public RaceResultDto startRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            drivers.forEach(Driver::drive);
            referee.record(getCarsStatus());
        }
        return new RaceResultDto(referee.playback(), referee.getWinners());
    }

    private List<CarStatus> getCarsStatus() {
        return drivers.stream().map(Driver::monitorCarStatus).toList();
    }

}

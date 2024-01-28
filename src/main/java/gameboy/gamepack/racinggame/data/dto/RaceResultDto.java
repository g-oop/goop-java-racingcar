package gameboy.gamepack.racinggame.data.dto;

import java.util.List;

import gameboy.gamepack.racinggame.data.entity.Car;
import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class RaceResultDto {

    private List<RaceLog> raceLogs;
    private List<Car> winners;

    private RaceResultDto(List<RaceLog> raceLogs, List<Car> winners) {
        this.raceLogs = raceLogs;
        this.winners = winners;
    }

    public List<RaceLog> getRaceLogs() {
        return raceLogs;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public static RaceResultDto of(List<RaceLog> raceLogs, List<Car> winners) {
        return new RaceResultDto(raceLogs, winners);
    }

}

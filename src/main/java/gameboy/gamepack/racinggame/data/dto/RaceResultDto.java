package gameboy.gamepack.racinggame.data.dto;

import java.util.List;

import gameboy.gamepack.racinggame.data.entity.Car;
import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class RaceResultDto {

    private List<RaceLog> raceLogs;
    private List<Car> winner;

    private RaceResultDto(List<RaceLog> raceLogs, List<Car> winner) {
        this.raceLogs = raceLogs;
        this.winner = winner;
    }

    public List<RaceLog> getRaceLogs() {
        return raceLogs;
    }

    public List<Car> getWinner() {
        return winner;
    }

    public static RaceResultDto of(List<RaceLog> raceLogs, List<Car> winner) {
        return new RaceResultDto(raceLogs, winner);
    }

}

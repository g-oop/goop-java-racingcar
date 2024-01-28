package gameboy.gamepack.racinggame.data.dto;

import java.util.List;

import gameboy.gamepack.racinggame.data.entity.Car;
import gameboy.gamepack.racinggame.data.vo.RaceLog;

public record RaceResultDto(
    List<RaceLog> raceLogs,
    List<Car> winners
) {

    public static RaceResultDto of(List<RaceLog> raceLogs, List<Car> winners) {
        return new RaceResultDto(raceLogs, winners);
    }
}

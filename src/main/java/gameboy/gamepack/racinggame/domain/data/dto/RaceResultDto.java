package gameboy.gamepack.racinggame.domain.data.dto;

import java.util.List;

import gameboy.gamepack.racinggame.domain.data.entity.Car;
import gameboy.gamepack.racinggame.domain.data.vo.RaceLog;

public record RaceResultDto(
    List<RaceLog> raceLogs,
    List<Car> winners
) {

    public static RaceResultDto of(List<RaceLog> raceLogs, List<Car> winners) {
        return new RaceResultDto(raceLogs, winners);
    }
}

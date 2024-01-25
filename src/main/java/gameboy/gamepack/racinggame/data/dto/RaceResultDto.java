package gameboy.gamepack.racinggame.data.dto;

import java.util.List;

import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class RaceResultDto {

    private List<RaceLog> raceLogs;
    private List<String> winnerNames;

    private RaceResultDto(List<RaceLog> raceLogs, List<String> winnerNames) {
        this.raceLogs = raceLogs;
        this.winnerNames = winnerNames;
    }

    public List<RaceLog> getRaceLogs() {
        return raceLogs;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public static RaceResultDto of(List<RaceLog> raceLogs, List<String> winnerNames) {
        return new RaceResultDto(raceLogs, winnerNames);
    }

}

package gameboy.gamepack.racinggame.data.dto;

import java.util.List;

import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class RaceResultDto {

    private List<RaceLog> raceLogs;
    private List<String> winners;

    private RaceResultDto(List<RaceLog> raceLogs, List<String> winners) {
        this.raceLogs = raceLogs;
        this.winners = winners;
    }

    public List<RaceLog> getRaceLogs() {
        return raceLogs;
    }

    public List<String> getWinners() {
        return winners;
    }

    public static RaceResultDto of(List<RaceLog> raceLogs, List<String> winners) {
        return new RaceResultDto(raceLogs, winners);
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode() + raceLogs.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}

package gameboy.gamepack.racinggame.data.dto;

import java.util.List;
import java.util.Set;

import gameboy.gamepack.racinggame.data.vo.RaceLog;

public class RaceResultDto {

    private List<RaceLog> raceLogs;
    private Set<String> winners;

    private RaceResultDto(List<RaceLog> raceLogs, Set<String> winners) {
        this.raceLogs = raceLogs;
        this.winners = winners;
    }

    public List<RaceLog> getRaceLogs() {
        return raceLogs;
    }

    public Set<String> getWinners() {
        return winners;
    }

    public static RaceResultDto of(List<RaceLog> raceLogs, Set<String> winners) {
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

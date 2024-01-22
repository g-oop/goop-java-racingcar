package gameboy.gamepack.racinggame.data.dto;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResultDto {
    List<Integer> carsPosition;

    private RaceResultDto(List<Integer> carsPosition) {
        this.carsPosition = carsPosition;
    }

    public static RaceResultDto of(List<Integer> carsPosition) {
        return new RaceResultDto(carsPosition);
    }

    public String getRaceResult() {
        return carsPosition.stream()
            .map(this::createWheelMark)
            .collect(Collectors.joining("\n","", "\n"));
    }

    private String createWheelMark(int carPosition) {
        return "-".repeat(carPosition);
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode() + carsPosition.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}

package gameboy.gamepack.racinggame.data.entity;

import java.util.List;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;

public class RacingTrack {

    private List<Car> cars;
    private Referee referee;

    public RacingTrack(List<Car> cars) {
        this(cars, new Referee());
    }

    public RacingTrack(List<Car> cars, Referee referee) {
        validationDriverCount(cars);
        this.cars = cars;
        this.referee = referee;
    }

    private void validationDriverCount(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("race 참가자가 0명 이하일 수 없습니다");
        }
    }

    public RaceResultDto startRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars.forEach(Car::run);
            referee.record(cars);
        }
        return RaceResultDto.of(referee.playback(), referee.getWinner());
    }

}

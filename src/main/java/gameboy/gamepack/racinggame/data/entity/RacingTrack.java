package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;

public class RacingTrack {

    private List<Car> cars;
    private Referee referee;
    public RacingTrack(List<Car> cars, Referee referee) {
        validationDriverCount(cars);
        this.cars = cars;
        this.referee = referee;
    }

    public RacingTrack(List<Car> cars) {
        this(cars, new Referee());
    }

    public RacingTrack(int carCount) {
        this(engageDriver(carCount));
    }

    private static List<Car> engageDriver(int driverCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < driverCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public RacingTrack(Car... cars) {
        this(List.of(cars));
    }

    private void validationDriverCount(List<Car> cars) {
        if (cars.size() == 0) {
            throw new IllegalArgumentException("race 참가자가 0명 이하일 수 없습니다");
        }
    }

    public RaceResultDto startRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars.forEach(Car::run);
            referee.record(cars);
        }
        return RaceResultDto.of(referee.playback(), referee.getWinners());
    }

}

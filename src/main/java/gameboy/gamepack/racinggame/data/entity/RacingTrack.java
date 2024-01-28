package gameboy.gamepack.racinggame.data.entity;

import java.util.HashSet;
import java.util.List;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.exception.InvalidRacerNameException;

public class RacingTrack {

    private List<Car> cars;
    private Referee referee;

    public RacingTrack(List<Car> cars) {
        this(cars, new Referee());
    }

    public RacingTrack(List<Car> cars, Referee referee) {
        validationDriverCount(cars);
        validDuplicateName(cars);
        this.cars = cars;
        this.referee = referee;
    }

    private void validationDriverCount(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("race 참가자가 0명 이하일 수 없습니다");
        }
    }

    private static void validDuplicateName(List<Car> cars) {
        List<String> carNames = cars.stream().map(Car::getName).toList();
        if (carNames.size() > new HashSet<>(carNames).size()) {
            throw new InvalidRacerNameException("자동차 이름이 중복될 수 없습니다.");
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

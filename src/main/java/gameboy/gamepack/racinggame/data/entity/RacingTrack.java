package gameboy.gamepack.racinggame.data.entity;

import java.util.ArrayList;
import java.util.List;

import gameboy.gamepack.racinggame.view.ResultView;

public class RacingTrack {

    private List<Car> cars = new ArrayList<>();

    private RacingTrack(int engageCount) {
        engageRacingCar(engageCount);
    }

    private void engageRacingCar(int engageCount) {
        for (int i = 0; i < engageCount; i++) {
            cars.add(new Car());
        }
    }

    public ResultView startRace() {
        raceOneTime();
        return getRaceResult();
    }

    private void raceOneTime() {
        cars.forEach(Car::run);
    }

    private ResultView getRaceResult() {
        StringBuilder result = new StringBuilder();
        for (Car car: cars) {
            result.append(car.wheelMark()).append("\n");
        }
        return new ResultView(result.toString());
    }

    public static RacingTrack of(int engageCount) {
        return new RacingTrack(engageCount);
    }
}

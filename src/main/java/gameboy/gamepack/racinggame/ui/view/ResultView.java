package gameboy.gamepack.racinggame.ui.view;

import java.util.*;
import java.util.stream.Collectors;

import gameboy.gamepack.racinggame.domain.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.domain.data.entity.Car;
import gameboy.gamepack.racinggame.domain.data.vo.RaceLog;

public class ResultView {

    public static void display(RaceResultDto result) {
        System.out.println(getRacePlayback(result.raceLogs()));
        System.out.println(getRaceResult(result.winners()));
    }

    private static String getRacePlayback(List<RaceLog> raceLogs) {
        return raceLogs
            .stream()
            .map(ResultView::createResult)
            .collect(Collectors.joining("\n"));
    }

    private static String createResult(RaceLog raceLog) {
        return raceLog.cars()
            .stream()
            .map(ResultView::createWheelMark)
            .collect(Collectors.joining("\n", "", "\n"));
    }

    private static String createWheelMark(Car car) {
        return car.getName() + ": " + "-".repeat(car.getPosition().value());
    }

    private static String getRaceResult(List<Car> winners) {
        return winners
            .stream()
            .map(Car::getName)
            .collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
    }

}

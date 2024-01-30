package com.megazone.goop.racingcar.ui;

import java.text.MessageFormat;
import java.util.List;

import com.megazone.goop.racingcar.logic.Car;

public class ResultView {

    public void startDisplay() {
        System.out.println("\n실행결과");
    }

    public void displayPositions(List<Car> cars) {
        cars.forEach(c ->
            System.out.println(MessageFormat.format("{0} : {1}", c.getName(), "-".repeat(c.getTotalDistance())))
        );
        System.out.println();
    }

    public void displayWinners(List<Car> cars) {
        System.out.println(String.join(", ", cars.stream().map(Car::getName).toList()) + "가 최종 우승했습니다.");
    }
}

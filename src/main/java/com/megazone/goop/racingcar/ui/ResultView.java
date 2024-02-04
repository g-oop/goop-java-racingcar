package com.megazone.goop.racingcar.ui;

import java.util.List;

import com.megazone.goop.racingcar.logic.*;

public class ResultView {

    public void displayRecords(List<RoundRecord> roundRecords) {
        System.out.println("\n실행결과");

        roundRecords.forEach(r -> {
            displayCarPositions(r.carDistances());
            System.out.println();
        });
    }

    public void displayWinners(List<Car> winners) {
        System.out.println(String.join(", ", winners.stream().map( n -> n.getName().name()).toList()) + "가 최종 우승했습니다.");
    }

    private void displayCarPositions(List<CarDistance> carDistances) {
        carDistances.forEach(d ->
            System.out.println(d.toString())
        );
    }
}

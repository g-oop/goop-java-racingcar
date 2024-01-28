package com.megazone.goop.racingcar.ui;

import java.util.List;

public class ResultView {

    public void startDisplay() {
        System.out.println("\n실행결과");
    }

    public void displayPositions(List<Integer> positions) {
        positions.forEach(n -> System.out.println("-".repeat(n)));
        System.out.println();
    }
}

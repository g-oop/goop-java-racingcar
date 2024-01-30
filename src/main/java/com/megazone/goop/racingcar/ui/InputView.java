package com.megazone.goop.racingcar.ui;

import java.util.*;

public class InputView {

    private List<String> carNames;
    private int roundCount;

    public void setRules() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)");
        String[] inNames = scanner.nextLine().split(",");

        carNames = Arrays.stream(inNames)
            .map(String::trim)
            .map(a -> a.substring(0, Math.min(a.length(), 5)))
            .toList();

        System.out.println("시도할 회수는 몇 회 인가요?");
        roundCount = scanner.nextInt();
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getRoundCount() {
        return roundCount;
    }
}

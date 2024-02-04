package com.megazone.goop.racingcar.ui;

import java.util.*;

import com.megazone.goop.racingcar.logic.CarName;
import com.megazone.goop.racingcar.logic.RacePlan;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private List<CarName> carNames;
    private int roundCount;

    public RacePlan setRacePlan() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)");
        String[] inNames = scanner.nextLine().split(CAR_NAME_DELIMITER, -1);

        carNames = Arrays.stream(inNames)
            .map(n -> new CarName(n.trim()))
            .toList();

        System.out.println("시도할 회수는 몇 회 인가요?");
        roundCount = scanner.nextInt();

        return new RacePlan(carNames, roundCount);
    }

    public List<CarName> getCarNames() {
        return carNames;
    }

    public int getRoundCount() {
        return roundCount;
    }
}

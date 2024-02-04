package com.megazone.goop.racingcar.car;

import java.text.MessageFormat;

public record CarName(String name) {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public CarName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 설정되지 않았습니다.");
        }
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(
                MessageFormat.format("자동차 이름이 최대길이({})를 초과하였습니다.", CAR_NAME_MAX_LENGTH));
        }
    }
}

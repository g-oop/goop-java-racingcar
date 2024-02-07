package step1.racingcar.domain.vo;

import step1.racingcar.exception.CarNameException;

public record CarName(String name) {

    public CarName {
        validateCarName(name);
    }

    private static void validateCarName(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new CarNameException("자동차 이름이 5자리 초과되었습니다.");
        }
    }

}

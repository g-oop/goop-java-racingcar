package racingcar.domain.entity.vo;

public record CarName(String value) {

    private static final int CAR_NAME_LIMIT = 5;

    public CarName {
        validateCarName(value);
    }

    private void validateCarName(String value) {
        if (value.length() > CAR_NAME_LIMIT) {
            throw new RuntimeException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}

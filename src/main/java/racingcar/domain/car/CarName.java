package racingcar.domain.car;

public record CarName(String name) {

    private static final int CAR_NAME_LIMIT = 5;

    public CarName {
        validateCarName(name);
    }

    private void validateCarName(String name) {
        if (name.length() > CAR_NAME_LIMIT) {
            throw new RuntimeException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}

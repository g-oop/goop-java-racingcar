package racingcar.entry;

public record CarName(String value) {

    public CarName {
        validate(value);
    }

    private static void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 지정되지 않았습니다.");
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
        }
    }
}

package racingcar.domain.entity.vo;

public record CarPosition(int value) {
    private static final int MIN_VALUE = 0;
    public CarPosition {
        validatePosition(value);
    }
    private void validatePosition(int value){
        if (value < MIN_VALUE) {
            throw new RuntimeException("Only positive numbers are allowed");
        }
    }

    public CarPosition increase(){
        return new CarPosition(value + 1);
    }
}


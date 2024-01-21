package gameboy.gamepack.racinggame.data.entity;

public enum RandomSeed {
    DRIVE_SEED(1L,"주행 값 생성 seed"),
    STOP_SEED(4L,"정지 값 생성 seed");

    private final long value;
    private final String  description;

    RandomSeed(long value, String description) {
        this.value = value;
        this.description = description;
    }

    public long value() {
        return value;
    }

}

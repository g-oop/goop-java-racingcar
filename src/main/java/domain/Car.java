package domain;

public class Car {

    private static final int MIN_VALUE = 4;


    private int position;

    public Car() {
        this.position = 0;
    }

    public Car(String name) {
        validateName(name);
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5자를 넘을수없습니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= MIN_VALUE) {
            position++;
        }
    }


}

package domain;

import domain.vo.CarName;

public class Car {

    private static final int MIN_VALUE = 4;


    private int position;
    private CarName name;

    public Car() {
        this.position = 0;
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = position;
    }


    public String getName() {
        return name.getValue();
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

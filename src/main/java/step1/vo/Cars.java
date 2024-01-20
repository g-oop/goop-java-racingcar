package step1.vo;

import java.util.List;

import step1.vo.Car;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::moveForward);
    }

    public int getCarCount() {
        return cars.size();
    }

    public int getCarLoc(int carNum) {
        return cars.get(carNum).getLoc();
    }
}

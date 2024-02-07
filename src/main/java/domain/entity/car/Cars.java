package domain.entity.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static List<Car> carList;


    public Cars() {
        carList = new ArrayList<>();
    }

    public void addCar(String carName) {
        carList.add(new Car(carName));
    }

    public static List<Car> getCarList() {
        return carList;
    }
}

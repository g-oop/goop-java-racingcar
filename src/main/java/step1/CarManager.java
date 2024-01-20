package step1;

import java.util.List;
import java.util.stream.IntStream;

import step1.view.ResultView;
import step1.vo.Car;
import step1.vo.Cars;

public class CarManager {

    public static Cars createCar(int carCount) {
        List<Car> carList = IntStream.range(0, carCount)
            .mapToObj(i -> new Car())
            .toList();
        return new Cars(carList);
    }

    public static void move(Cars cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            ResultView.divideProgressStage();
        }
    }
}

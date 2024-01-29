package ui;

import java.util.List;

import domain.Car;

public class OutputResult implements OutputProvider {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printCarStates(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getState());
        }
        System.out.println("\n");
    }
}

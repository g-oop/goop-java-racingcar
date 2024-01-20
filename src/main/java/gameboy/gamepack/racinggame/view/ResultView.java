package gameboy.gamepack.racinggame.view;

import java.util.List;

import gameboy.gamepack.racinggame.data.entity.Car;

public class ResultView implements TextView {

    private String resultText;

    public ResultView(List<Car> cars) {
        this.resultText = getRaceResult(cars);
    }

    private String getRaceResult(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> carsPosition = cars.stream().map(Car::getPosition).toList();
        carsPosition.stream().forEach(position -> stringBuilder.append(createWheelMark(position)));
        return stringBuilder.toString();
    }

    private String createWheelMark(int carPosition) {
        String wheelMark = "";
        for (int i = 0; i < carPosition; i++) {
            wheelMark += "-";
        }
        return wheelMark + "\n";
    }

    @Override
    public String display() {
        return resultText;
    }
}

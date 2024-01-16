package gameboy.gamepack.racinggame.data.entity;

import java.util.Random;

import gameboy.gamepack.racinggame.data.vo.WheelMark;

public class Car {

    private WheelMark wheelMark;
    private final Random random = new Random();
    private final int MOVE_RANGE = 10;
    private final int MOVE_MIN = 4;


    public Car() {
        this.wheelMark = new WheelMark();
    }

    public void run() {
        if (isMoved()) {
            wheelMark.add();
        }
    }

    private boolean isMoved() {
        return random.nextInt(MOVE_RANGE) >= MOVE_MIN;
    }

    public String wheelMark() {
        return wheelMark.getWheelMark();
    }
}

package domain;

import java.util.Random;

public class Car implements Moveable {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        generateRandomAndMove();
    }

    private void generateRandomAndMove() {
        int randomNumber = new Random().nextInt(10);
        if(randomNumber >= 4) {
            position++;
        }
    }

    public String getState(){
        StringBuilder state = new StringBuilder("|");
        for(int i = 0; i< position; i++){
            state.append("-");
        }
        state.append(">");
        return state.toString();
    }
}

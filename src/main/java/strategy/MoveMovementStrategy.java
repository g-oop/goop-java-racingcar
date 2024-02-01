package strategy;

public class MoveMovementStrategy implements MovementStrategy {


    @Override
    public int move() {
        return 5; // 무조건 움직이는 조건의 숫자를 반환
    }


}

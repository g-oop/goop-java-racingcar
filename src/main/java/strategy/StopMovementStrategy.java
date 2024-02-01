package strategy;

public class StopMovementStrategy implements MovementStrategy {

    @Override
    public int performAction() {
        return 0; // 무조건 정지하는 조건의 숫자를 반환
    }
}

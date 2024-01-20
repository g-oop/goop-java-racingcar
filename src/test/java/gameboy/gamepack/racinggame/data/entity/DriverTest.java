package gameboy.gamepack.racinggame.data.entity;

import gameboy.gamepack.racinggame.data.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    @Test
    @DisplayName("drive 정상 테스트")
    void drive() {
        //given
        Driver driver = new Driver();
        //when
        driver.drive();
        //then
        validCarPosition(driver.getCar());
    }

    void validCarPosition(Car car) {
        if (isRun(car)) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
        if (!isRun(car)) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    boolean isRun(Car car) {
        Position runPosition = new Position(1);
        return car.getPosition() == runPosition.getPosition();
    }
}

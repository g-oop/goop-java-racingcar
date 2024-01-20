package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTest {
    private static final int BOUND = 10;
    private Car car;
    private RandomNumberGenerator numberGenerator;

    @BeforeEach
    void setUp(){
        numberGenerator = mock(RandomNumberGenerator.class);
        numberGenerator.setBound(BOUND);
        car = new DefaultCar(numberGenerator, "TEST");
    }

    @Test
    void moveWhenRandomValueIsOverThreshold() {
        when(numberGenerator.generate()).thenReturn(6);
        car.move();

        assertEquals(1, car.getPosition());
    }

    @Test
    void stayWhenRandomValueIsUnderThreshold() {
        when(numberGenerator.generate()).thenReturn(3);
        car.move();

        assertEquals(0, car.getPosition());
    }
}

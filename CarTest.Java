import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void volvoEngineTest() {
        Volvo240 volvo = new Volvo240();
        double volvoPower = volvo.getEnginePower();
        assertEquals(100, volvoPower);
    }

    @Test
    void volvoSpeedTest() {
        Volvo240 volvo = new Volvo240();
        double volvoSpeed = volvo.speedFactor();
        double speedFactor = 100 * 0.01 * 1.25;
        assertEquals(speedFactor, volvoSpeed);
    }


}
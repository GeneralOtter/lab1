import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.*;

class CarTest {

    @Test
    void volvoTest() {
        Volvo240 volvo = new Volvo240();
        assertEquals(100, volvo.getEnginePower());
        assertEquals(100 * 0.01 * 1.25, volvo.speedFactor());
    }

    @Test
    void saabTest() {
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        assertEquals(125 * 0.01, saab.speedFactor());
        saab.setTurboOn();
        assertEquals(125 * 0.01 * 1.3, saab.speedFactor());
    }

    @Test
    void gettersTest() {
        Saab95 saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
        saab.setColor(Color.white);
        assertEquals(Color.white, saab.getColor());
        assertEquals(125, saab.getEnginePower());
        assertEquals("Saab 95", saab.getModelName());
        assertEquals(0, saab.getCurrentSpeed());
        assertEquals( 0.0, saab.getPosition()[0]);
        assertEquals( 0.0, saab.getPosition()[1]);
    }

    @Test
    void brakeGasTest() {
        Saab95 saab = new Saab95();
        saab.brake(1.0);
        assertEquals(0.0, saab.getCurrentSpeed());
        saab.startEngine();
        saab.brake(2);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.brake(-2);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.gas(2);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.gas(-1);
        assertEquals(0.1, saab.getCurrentSpeed());
    }

    @Test
    void moveTest() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        for (int i = 0; i < 1000; i++) {
            saab.gas(1.0);
        }
        assertEquals(saab.getEnginePower(), saab.getCurrentSpeed());

        saab.turnRight();
        saab.move();
        assertEquals(saab.getEnginePower(), saab.getPosition()[0]);
        assertEquals("East", saab.getDirection().toString());

        saab.turnLeft();
        saab.move();
        assertEquals(saab.getEnginePower(), saab.getPosition()[1]);
        assertEquals("North", saab.getDirection().toString());

        saab.turnLeft();
        saab.move();
        assertEquals(0.0, saab.getPosition()[0]);
        assertEquals("West", saab.getDirection().toString());

        saab.turnLeft();
        saab.move();
        assertEquals(0.0, saab.getPosition()[1]);
        assertEquals("South", saab.getDirection().toString());

        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals("South", saab.getDirection().toString());
    }

    @Test
    void genericCarTest() {
        class GenericCar extends Car {
            public GenericCar(int nrDoors, Color color, double enginePower, String modelName) {
                super(nrDoors, color, enginePower, modelName);
            }
        }
        GenericCar car = new GenericCar(4, Color.black, 100, "GenericCar");
        assertEquals(100 * 0.01, car.speedFactor());
    }

}
package main.agh.cs.lab3;

import main.agh.cs.lab4.RectangularMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        Car car = new Car(new RectangularMap(5,5));
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "N");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "N");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "N");
        car.move(MoveDirection.LEFT);
        assertEquals(car.toString(), "W");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "W");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "W");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "W");
        car.move(MoveDirection.RIGHT);
        assertEquals(car.toString(), "N");
        car.move(MoveDirection.BACKWARD);
        assertEquals(car.toString(), "N");
        car.move(MoveDirection.RIGHT);
        car.move(MoveDirection.RIGHT);
        assertEquals(car.toString(), "S");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "S");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "S");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "S");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "S");
        car.move(MoveDirection.RIGHT);
        assertEquals(car.toString(), "W");
        car.move(MoveDirection.BACKWARD);
        car.move(MoveDirection.BACKWARD);
        car.move(MoveDirection.BACKWARD);
        car.move(MoveDirection.BACKWARD);
        assertEquals(car.toString(), "W");
        car.move(MoveDirection.BACKWARD);
        assertEquals(car.toString(), "W");


    }
}
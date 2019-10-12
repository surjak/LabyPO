package main.agh.cs.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        Car car = new Car();
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Polnoc, position=(2,3)");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Polnoc, position=(2,4)");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Polnoc, position=(2,4)");
        car.move(MoveDirection.LEFT);
        assertEquals(car.toString(), "direction=Zachod, position=(2,4)");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Zachod, position=(1,4)");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Zachod, position=(0,4)");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Zachod, position=(0,4)");
        car.move(MoveDirection.RIGHT);
        assertEquals(car.toString(), "direction=Polnoc, position=(0,4)");
        car.move(MoveDirection.BACKWARD);
        assertEquals(car.toString(), "direction=Polnoc, position=(0,3)");
        car.move(MoveDirection.RIGHT);
        car.move(MoveDirection.RIGHT);
        assertEquals(car.toString(), "direction=Poludnie, position=(0,3)");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Poludnie, position=(0,2)");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Poludnie, position=(0,1)");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Poludnie, position=(0,0)");
        car.move(MoveDirection.FORWARD);
        assertEquals(car.toString(), "direction=Poludnie, position=(0,0)");
        car.move(MoveDirection.RIGHT);
        assertEquals(car.toString(), "direction=Zachod, position=(0,0)");
        car.move(MoveDirection.BACKWARD);
        car.move(MoveDirection.BACKWARD);
        car.move(MoveDirection.BACKWARD);
        car.move(MoveDirection.BACKWARD);
        assertEquals(car.toString(), "direction=Zachod, position=(4,0)");
        car.move(MoveDirection.BACKWARD);
        assertEquals(car.toString(), "direction=Zachod, position=(4,0)");


    }
}
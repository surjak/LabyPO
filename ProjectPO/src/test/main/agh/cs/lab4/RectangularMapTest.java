package main.agh.cs.lab4;

import main.agh.cs.lab3.Car;
import main.agh.cs.lab3.MoveDirection;
import main.agh.cs.lab3.OptionParser;
import main.agh.cs.lab3.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;


class RectangularMapTest {
    public RectangularMap map;

    @BeforeEach
    void setUp() {
        map = new RectangularMap(5, 5);
        map.place(new Car(new Position(2, 2), map));

    }

    @Test
    void canMoveTo() {
        assertFalse(map.canMoveTo(new Position(2, 2)));
        assertTrue(map.canMoveTo(new Position(4, 4)));
        assertFalse(map.canMoveTo(new Position(4, 5)));
        assertFalse(map.canMoveTo(new Position(5, 4)));
    }

    @Test
    void place() {
        Car car = new Car(new Position(2, 2), map);
        assertFalse(map.place(car));
        Car car1 = new Car(new Position(1, 1), map);
        assertTrue(map.place(car1));
    }

    @Test
    void run() {
        MoveDirection[] directions = new OptionParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        map.place(new Car(new Position(3, 4), map));
        map.run(directions);
        assertNotNull(map.objectAt(new Position(3,4)));
        assertNotNull(map.objectAt(new Position(2,0)));
    }

    @Test
    void isOccupied() {
        assertTrue(map.isOccupied(new Position(2, 2)));
        assertFalse(map.isOccupied(new Position(2, 1)));
    }

    @Test
    void objectAt() {
        assertNotNull((Car) map.objectAt(new Position(2, 2)));
        assertNull(map.objectAt(new Position(1, 1)));
    }
}
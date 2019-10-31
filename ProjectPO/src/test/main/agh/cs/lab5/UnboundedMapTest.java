package main.agh.cs.lab5;

import main.agh.cs.lab3.Car;
import main.agh.cs.lab3.MoveDirection;
import main.agh.cs.lab3.OptionParser;
import main.agh.cs.lab3.Position;
import main.agh.cs.lab4.IWorldMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UnboundedMapTest {
    public IWorldMap iWorldMap;

    @BeforeEach
    void setUp() {
        ArrayList<HayStack> hayStackArrayList = new ArrayList<HayStack>();
        hayStackArrayList.add(new HayStack(new Position(-4, -4)));
        hayStackArrayList.add(new HayStack(new Position(7, 7)));
        hayStackArrayList.add(new HayStack(new Position(3, 6)));
        hayStackArrayList.add(new HayStack(new Position(2, 0)));
        iWorldMap = new UnboundedMap(hayStackArrayList);
        iWorldMap.place(new Car(iWorldMap));
        iWorldMap.place(new Car(new Position(3, 4), iWorldMap));
        iWorldMap.place(new Car(new Position(2, 4), iWorldMap));
    }

    @Test
    void canMoveTo() {
        assertFalse(iWorldMap.canMoveTo(new Position(-4,-4)));
        assertFalse(iWorldMap.canMoveTo(new Position(3,4)));
        assertTrue(iWorldMap.canMoveTo(new Position(1,-4)));
    }

    @Test
    void place() {
        assertFalse(iWorldMap.place(new Car(new Position(3,6),iWorldMap)));
        assertFalse(iWorldMap.place(new Car(new Position(2,4),iWorldMap)));
        assertTrue(iWorldMap.place(new Car(new Position(1,100),iWorldMap)));

    }

    @Test
    void run() {
        MoveDirection[] directions = new OptionParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        iWorldMap.run(directions);
        assertNull(iWorldMap.objectAt(new Position(-4,-3)));
        assertNotNull(iWorldMap.objectAt(new Position(-4,-4)));
        assertNull(iWorldMap.objectAt(new Position(0,7)));
        assertNotNull(iWorldMap.objectAt(new Position(2,5)));
        assertNull(iWorldMap.objectAt(new Position(7,6)));
        assertNotNull(iWorldMap.objectAt(new Position(4,4)));
    }

    @Test
    void isOccupied() {
        assertTrue(iWorldMap.isOccupied(new Position(7,7)));
        assertTrue(iWorldMap.isOccupied(new Position(2,0)));
        assertTrue(iWorldMap.isOccupied(new Position(2,4)));
        assertTrue(iWorldMap.isOccupied(new Position(3,4)));
        assertFalse(iWorldMap.isOccupied(new Position(1,1)));

    }

    @Test
    void objectAt() {
        assertEquals(iWorldMap.objectAt(new Position(3,4)).getClass(),Car.class);
        assertEquals(iWorldMap.objectAt(new Position(7,7)).getClass(),HayStack.class);
        assertEquals(iWorldMap.objectAt(new Position(0,4)),null);

    }
}
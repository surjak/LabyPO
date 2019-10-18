package main.agh.cs.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testToString() {
        Position position = new Position(2, 1);
        assertEquals(position.toString(), "(2,1)");
    }

    @Test
    void smaller() {
        Position position = new Position(2, 1);
        assertTrue(position.smaller(new Position(3, 1)));
    }

    @Test
    void larger() {
        Position position = new Position(2, 1);

        assertTrue(position.larger(new Position(1, 1)));
    }

    @Test
    void upperRight() {
        Position position = new Position(2, 1);

        Position position2 = new Position(12, -4);

        assertEquals(position.upperRight(position2).toString(), "(12,1)");

    }

    @Test
    void lowerLeft() {
        Position position = new Position(2, 1);

        Position position2 = new Position(12, -4);
        assertEquals(position.lowerLeft(position2).toString(), "(2,-4)");
    }

    @Test
    void add() {
        Position position = new Position(2, 1);

        Position position2 = new Position(12, -4);
        assertEquals(position.add(position2).toString(), "(14,-3)");
    }

    @Test
    void subtract() {
        Position position = new Position(2, 1);

        Position position2 = new Position(12, -4);
        assertEquals(position.subtract(position2).toString(), "(-10,5)");

    }

    @Test
    void testEquals() {
        Position position = new Position(2, 1);

        Position position2 = new Position(12, -4);
        assertFalse(position.equals(position2));
        assertTrue(position.equals(new Position(2, 1)));
    }
}
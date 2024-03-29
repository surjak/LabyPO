package main.agh.cs.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {
        MapDirection mapDirection = MapDirection.EAST;
        assertEquals(mapDirection.next(), MapDirection.SOUTH);
        MapDirection mapDirection1 = MapDirection.NORTH;
        assertEquals(mapDirection1.next(), MapDirection.EAST);
        MapDirection mapDirection2 = MapDirection.SOUTH;
        assertEquals(mapDirection2.next(), MapDirection.WEST);
        MapDirection mapDirection3 = MapDirection.WEST;
        assertEquals(mapDirection3.next(), MapDirection.NORTH);
    }

    @Test
    void previous() {
        MapDirection mapDirection = MapDirection.EAST;
        assertEquals(mapDirection.previous(), MapDirection.NORTH);
        MapDirection mapDirection1 = MapDirection.NORTH;
        assertEquals(mapDirection1.previous(), MapDirection.WEST);
        MapDirection mapDirection2 = MapDirection.EAST;
        assertEquals(mapDirection2.previous(), MapDirection.NORTH);
        MapDirection mapDirection3 = MapDirection.WEST;
        assertEquals(mapDirection3.previous(), MapDirection.SOUTH);
    }

    @Test
    void toUnitVector() {
        assertEquals(MapDirection.NORTH.toUnitVector().toString(),new Position(0,1).toString() );
    }
}
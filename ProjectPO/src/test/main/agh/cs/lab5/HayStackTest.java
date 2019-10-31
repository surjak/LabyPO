package main.agh.cs.lab5;

import main.agh.cs.lab3.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HayStackTest {

    @Test
    void getPosition() {
        HayStack hayStack = new HayStack(new Position(2,4));
        assertTrue(hayStack.getPosition().equals(new Position(2,4)));
    }
}
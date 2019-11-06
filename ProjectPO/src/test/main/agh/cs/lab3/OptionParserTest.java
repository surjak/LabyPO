package main.agh.cs.lab3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OptionParserTest {

    @Test
    void parseOne() {
        assertEquals(OptionParser.parseOne("f"), MoveDirection.FORWARD);
    }

    @Test
    void parseOneNull() {
        assertThrows(IllegalArgumentException.class,()->OptionParser.parseOne("x"));

    }

    @Test
    void parse() {
        String[] strings = { "f", "backward", "left", "f", "r"};
        MoveDirection[] directions = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT};
        MoveDirection[] directions1 = OptionParser.parse(strings);
        for (int i = 0; i < directions1.length; i++) {
            assertEquals(directions1[i], directions[i]);
        }
    }
}
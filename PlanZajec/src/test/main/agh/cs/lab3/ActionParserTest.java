package main.agh.cs.lab3;

import main.agh.cs.lab2.Action;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ActionParserTest {
    ActionParser actionParser;

    @BeforeEach
    void setUp() {
        actionParser = new ActionParser();
    }

    @Test
    void parse() {
        String[] changeLesson = {"d+", "t+", "aaa", "dd", "d-", "t-"};
        Action[] actions = {Action.DAY_LATER, Action.TIME_LATER, Action.DAY_EARLIER, Action.TIME_EARLIER};
        assertTrue(Arrays.equals(actions, actionParser.parse(changeLesson)));
    }
}
package main.agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {

    @Test
    void testToString() {
        Day day = Day.MON;
        assertEquals(day.toString(), "Poniedzialek");
    }

    @Test
    void nextDay() {
        Day day = Day.SUN;
        assertEquals(day.nextDay(), Day.MON);
        assertEquals(day.nextDay().nextDay(), Day.TUE);
        assertEquals(day.nextDay().nextDay().nextDay(), Day.WED);
        assertEquals(day.nextDay().nextDay().nextDay().nextDay(), Day.THU);
        assertEquals(day.nextDay().nextDay().nextDay().nextDay().nextDay(), Day.FRI);
        assertEquals(day.nextDay().nextDay().nextDay().nextDay().nextDay().nextDay(), Day.SAT);
        assertEquals(day.nextDay().nextDay().nextDay().nextDay().nextDay().nextDay().nextDay(), Day.SUN);


    }

    @Test
    void prevDay() {
        Day day = Day.SUN;
        assertEquals(day.prevDay(), Day.SAT);
        assertEquals(day.prevDay().prevDay(), Day.FRI);
        assertEquals(day.prevDay().prevDay().prevDay(), Day.THU);
        assertEquals(day.prevDay().prevDay().prevDay().prevDay(), Day.WED);
        assertEquals(day.prevDay().prevDay().prevDay().prevDay().prevDay(), Day.TUE);
        assertEquals(day.prevDay().prevDay().prevDay().prevDay().prevDay().prevDay(), Day.MON);
        assertEquals(day.prevDay().prevDay().prevDay().prevDay().prevDay().prevDay().prevDay(), Day.SUN);
    }
}
package main.agh.cs.lab3;


import main.agh.cs.lab2.Day;
import main.agh.cs.lab2.Term;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LessonTest {
    Lesson lessonOnFullTime;
    Lesson lessonOnPartTime;

    @BeforeEach
    void setUp() {
        lessonOnFullTime = new Lesson(new Term(9, 30, Day.WED), "PO", "Stanislaw Polak", 2019, true);
        lessonOnPartTime = new Lesson(new Term(15, 30, Day.SAT), "PO", "Stanislaw Polak", 2019, false);
        assertEquals(lessonOnFullTime.getYear(), 2019);
    }

    @Test
    void earlierDay() {
        assertTrue(lessonOnFullTime.earlierDay());
        assertTrue(lessonOnFullTime.earlierDay());
        assertEquals(lessonOnFullTime.getTerm().getDay(), Day.MON);
        assertFalse(lessonOnFullTime.earlierDay());

        assertFalse(lessonOnPartTime.earlierDay());
        lessonOnPartTime.laterTime();
        lessonOnPartTime.laterTime();
        assertTrue(lessonOnPartTime.earlierDay());

    }

    @Test
    void laterDay() {
        assertTrue(lessonOnFullTime.laterDay());
        assertTrue(lessonOnFullTime.laterDay());
        assertEquals(lessonOnFullTime.getTerm().getDay(), Day.FRI);
        assertFalse(lessonOnFullTime.laterDay());
    }

    @Test
    void laterTime() {
        assertTrue(lessonOnFullTime.laterTime());
        assertTrue(lessonOnFullTime.laterTime());
        assertTrue(lessonOnFullTime.laterTime());
        assertTrue(lessonOnFullTime.laterTime());
        assertTrue(lessonOnFullTime.laterTime());
        assertTrue(lessonOnFullTime.laterTime());
        assertEquals(lessonOnFullTime.getTerm().getHour(), 18);
        assertEquals(lessonOnFullTime.getTerm().getMinute(), 30);
        lessonOnFullTime.getTerm().setDuration(30);
        assertTrue(lessonOnFullTime.laterTime());
    }

    @Test
    void earlierTime() {
        assertTrue(lessonOnFullTime.earlierTime());
        assertEquals(lessonOnFullTime.getTerm().getHour(), 8);
        assertEquals(lessonOnFullTime.getTerm().getMinute(), 0);
        assertFalse(lessonOnFullTime.earlierTime());
    }
}
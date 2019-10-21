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
        assertEquals(lessonOnFullTime.year, 2019);
    }

    @Test
    void earlierDay() {
        assertTrue(lessonOnFullTime.earlierDay());
        assertTrue(lessonOnFullTime.earlierDay());
        assertEquals(lessonOnFullTime.term.day, Day.MON);
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
        assertEquals(lessonOnFullTime.term.day, Day.FRI);
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
        assertEquals(lessonOnFullTime.term.hour, 18);
        assertEquals(lessonOnFullTime.term.minute, 30);
        lessonOnFullTime.term.duration = 30;
        assertTrue(lessonOnFullTime.laterTime());
    }

    @Test
    void earlierTime() {
        assertTrue(lessonOnFullTime.earlierTime());
        assertEquals(lessonOnFullTime.term.hour, 8);
        assertEquals(lessonOnFullTime.term.minute, 0);
        assertFalse(lessonOnFullTime.earlierTime());
    }
}
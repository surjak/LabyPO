package main.agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermTest {

    @Test
    void testToString() {
        Term term = new Term(9,45, Day.MON);
        assertEquals(term.toString(), "9:45 [90]");
    }

    @Test
    void earlierThan() {
        assertTrue(new Term(9,45, Day.MON).earlierThan(new Term(9,46, Day.MON)));
        assertFalse(new Term(9,45, Day.MON).earlierThan(new Term(9,44, Day.MON)));
    }

    @Test
    void laterThan() {
        assertFalse(new Term(9,45, Day.MON).laterThan(new Term(9,46, Day.MON)));
        assertTrue(new Term(9,45, Day.MON).laterThan(new Term(9,44, Day.MON)));
    }

    @Test
    void endTerm() {
        Term term = new Term(9,45, Day.MON);
        assertEquals(term.endTerm(new Term(10,15, Day.MON)).toString(), "9:45 [30]");
        assertEquals(term.endTerm(new Term(11,15, Day.MON)).toString(), "9:45 [90]");
    }

    @Test
    void testEndTerm() {
        Term term = new Term(9,45, Day.MON);
        assertEquals(term.endTerm().toString(), "11:15 [90]");
    }

    @Test
    void testEquals() {
        Term term = new Term(9,45, Day.MON);
        Term term1 = new Term(9,45, Day.MON);
        assertTrue(term1.equals(term));
        assertFalse(term.equals(new Term(9,43, Day.MON)));
        assertFalse(term.equals(new Term(9,45, Day.THU)));

    }
}
package main.agh.cs.lab2;

import java.util.Objects;

public class Term {
    public int hour;
    public int minute;
    public int duration;

    public Term(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        this.duration = 90;
    }

    @Override
    public String toString() {
        return this.hour + ":" + this.minute + " [" + this.duration + "]";
    }

    public boolean earlierThan(Term term) {
        return this.hour < term.hour || (this.hour == term.hour && this.minute < term.minute);
    }

    public boolean laterThan(Term term) {
        return this.hour > term.hour || (this.hour == term.hour && this.minute > term.minute);
    }

    private int getMinutes() {
        return this.hour * 60 + this.minute;
    }

    public Term endTerm(Term term) {
        int dur = term.getMinutes() - this.getMinutes();
        Term term1 = new Term(this.hour, this.minute);
        term1.duration = dur;
        return term1;
    }

    public Term endTerm() {
        int minutes = this.getMinutes() + this.duration;
        Term term = new Term(minutes / 60 % 24, minutes % 60);
        term.duration = this.duration;
        return term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return hour == term.hour &&
                minute == term.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, duration);
    }
}

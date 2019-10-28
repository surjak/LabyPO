package main.agh.cs.lab2;

import java.util.Objects;

public class Term {
    private int hour;
    private int minute;
    private int duration;
    private Day day;

    public Term(int hour, int minute, Day day) {
        this.hour = hour;
        this.minute = minute;
        this.duration = 90;
        this.day = day;
    }

    @Override
    public String toString()
    {
        String minute = String.valueOf(this.minute);
        if (this.minute<10){
        minute = "0"+minute;
    }
        return this.hour + ":" + minute + " [" + this.duration + "]";
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
        Term term1 = new Term(this.hour, this.minute, this.day);
        term1.duration = dur;
        return term1;
    }

    public Term endTerm() {
        int minutes = this.getMinutes() + this.duration;
        Term term = new Term(minutes / 60 % 24, minutes % 60, this.day);
        term.duration = this.duration;
        return term;
    }

    public Term prevTerm(){
        int minutes = this.getMinutes() - this.duration;
        Term term = new Term(minutes / 60 % 24, minutes % 60, this.day);
        term.duration = this.duration;
        return term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return hour == term.hour &&
                minute == term.minute && this.day.equals(term.day);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, duration);
    }
}

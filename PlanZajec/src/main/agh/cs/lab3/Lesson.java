package main.agh.cs.lab3;

import main.agh.cs.lab2.Day;
import main.agh.cs.lab2.Term;
import main.agh.cs.lab4.ITimetable;

public class Lesson {
    private ITimetable timetable;
    private Term term;
    private String name;
    private String teacherName;
    private int year;
    private boolean full_time;

    public Lesson(Term term, String name, String teacherName, int year, boolean full_time) {
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
        this.full_time = full_time;
    }

    public Lesson(ITimetable timetable, Term term, String name, String teacherName, int year, boolean full_time) {
        this.timetable = timetable;
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
        this.full_time = full_time;
    }

    public Lesson(ITimetable timetable, Term term, String name, String teacherName, int year) {
        this.timetable = timetable;
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
        this.full_time = true;
    }


    public Lesson earlierDay() {
        if(timetable.canBeTransferredTo(new Term(term.getHour(), term.getMinute(), term.getDay().prevDay()), full_time)) {
            this.term.setDay(term.getDay().prevDay());
            return this;
        }
        throw new IllegalArgumentException();
    }

    public Lesson laterDay() {
        if(timetable.canBeTransferredTo(new Term(term.getHour(), term.getMinute(), term.getDay().nextDay()), full_time)) {
            this.term.setDay(term.getDay().nextDay());
            return this;
        }
        throw new IllegalArgumentException();
    }


    public Lesson laterTime() {
        int d = this.term.getDuration();
        int hour = this.term.getHour() + (d / 60);
        int minute = this.term.getMinute() + (d % 60);
        hour = hour + (minute / 60);
        minute = minute % 60;

        Day day = this.term.getDay();

        Term newTerm = new Term(hour, minute, day);
        newTerm.setDuration(d);

        if(timetable.canBeTransferredTo(newTerm, full_time)) {
            this.term.setDay(day);
            this.term.setDuration(d);
            this.term.setHour(hour);
            this.term.setMinute(minute);
            return this;
        }
        throw new IllegalArgumentException();
    }



    public Lesson earlierTime() {
        int d = this.term.getDuration();
        int hour = this.term.getHour() - (d / 60);
        int minute = this.term.getMinute() - (d % 60);
        hour = hour + (minute / 60);
        minute = minute % 60;
        if(minute < 0) {
            hour--;
            minute = minute + 60;
        }
        Day day = this.term.getDay();
        Term newTerm = new Term(hour, minute, day);
        newTerm.setDuration(d);

        if(timetable.canBeTransferredTo(newTerm, full_time)) {
            this.term.setDay(day);
            this.term.setDuration(d);
            this.term.setHour(hour);
            this.term.setMinute(minute);
            return this;
        }

        throw new IllegalArgumentException();
    }


    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isFull_time() {
        return full_time;
    }

    public void setFull_time(boolean full_time) {
        this.full_time = full_time;
    }

    public ITimetable getiTimetable() {
        return timetable;
    }

    public void setiTimetable(ITimetable iTimetable) {
        this.timetable = iTimetable;
    }

    @Override
    public String toString() {
        String rodzaj;
        if (this.full_time == true) {
            rodzaj = "stacjonarnych";
        } else {
            rodzaj = "niestacjonarnych";
        }
        return this.name + " (" + this.term.getDay() + " " + this.term.getHour() + ":" + this.term.getMinute() + " - " + this.term.endTerm().getHour() + ":" + this.term.endTerm().getMinute() + ")\n" +
                this.year + " rok studiow " + rodzaj + "\n" + "Prowadzacy: " + this.teacherName;
    }
}

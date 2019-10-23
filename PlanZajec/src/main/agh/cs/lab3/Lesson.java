package main.agh.cs.lab3;

import main.agh.cs.lab2.Term;
import main.agh.cs.lab4.ITimetable;

public class Lesson {
    private ITimetable iTimetable;
    private Term term;
    private String name;
    private String teacherName;
    private int year;
    private boolean full_time;

    public Lesson(ITimetable iTimetable, Term term, String name, String teacherName, int year, boolean full_time) {
        this.iTimetable = iTimetable;
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
        this.full_time = full_time;
    }


    public boolean earlierDay() {
        Term term = new Term(this.term.getHour(), this.term.getMinute(), this.term.getDay());
        term.setDuration(this.term.getDuration());
        term.setDay(this.term.getDay().prevDay());

        if (this.full_time) {
            if (iTimetable.canBeTransferredTo(term, true)) {
                this.term = term;
                return true;
            } else return false;
        } else {
            if (iTimetable.canBeTransferredTo(term, false)) {
                this.term = term;
                return true;
            } else return false;
        }
    }

    public boolean laterDay() {
        Term term = new Term(this.term.getHour(), this.term.getMinute(), this.term.getDay());
        term.setDuration(this.term.getDuration());
        term.setDay(this.term.getDay().nextDay());
        if (this.full_time) {
            if (iTimetable.canBeTransferredTo(term, true)) {
                this.term = term;
                return true;
            } else return false;
        } else {
            if (iTimetable.canBeTransferredTo(term, false)) {
                this.term = term;
                return true;
            } else return false;
        }
    }


    public boolean laterTime() {
        if (this.full_time) {
            if (iTimetable.canBeTransferredTo(this.term.endTerm(), true)) {
                this.term = this.term.endTerm();
                return true;
            }
        } else {
            if (iTimetable.canBeTransferredTo(this.term.endTerm(), false)) {
                this.term = this.term.endTerm();
                return true;
            }
        }
        return false;
    }


    public boolean earlierTime() {
        if (this.full_time) {
            if (iTimetable.canBeTransferredTo(this.term.prevTerm(), true)) {
                this.term = this.term.prevTerm();
                return true;
            }
        } else {
            if (iTimetable.canBeTransferredTo(this.term.prevTerm(), false)) {
                this.term = this.term.prevTerm();
                return true;
            }
        }
        return false;
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
        return iTimetable;
    }

    public void setiTimetable(ITimetable iTimetable) {
        this.iTimetable = iTimetable;
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

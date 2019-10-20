package main.agh.cs.lab3;

import main.agh.cs.lab2.Term;

public class Lesson {
    public Term term;
    public String name;
    public String teacherName;
    public int year;
    public boolean full_time;

    public Lesson(Term term, String name, String teacherName, int year, boolean full_time) {
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
        this.full_time = full_time;
    }

    public boolean earlierDay() {
        if (this.full_time) {
            if (this.term.day.prevDay().ordinal() >= 0 && this.term.day.prevDay().ordinal() <= 4) {
                if (this.term.day.prevDay().ordinal() == 4) {
                    if (this.term.laterThan(new Term(7, 59, this.term.day)) && this.term.earlierThan(new Term(17, 1, this.term.day))) {
                        this.term.day = this.term.day.prevDay();
                        return true;
                    }
                } else {
                    if (this.term.laterThan(new Term(7, 59, this.term.day)) && this.term.earlierThan(new Term(20, 1, this.term.day))) {
                        this.term.day = this.term.day.prevDay();
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (this.term.day.prevDay().ordinal() >= 4 && this.term.day.prevDay().ordinal() <= 6) {
                if (this.term.day.prevDay().ordinal() == 4) {
                    if (this.term.laterThan(new Term(16, 59, this.term.day)) && this.term.earlierThan(new Term(20, 1, this.term.day))) {
                        this.term.day = this.term.day.prevDay();
                        return true;
                    }
                } else {
                    if (this.term.laterThan(new Term(7, 59, this.term.day)) && this.term.earlierThan(new Term(20, 1, this.term.day))) {
                        this.term.day = this.term.day.prevDay();
                        return true;
                    }
                }
            }
            return false;
        }

    }


    public boolean laterDay() {
        if (this.full_time) {
            if (this.term.day.nextDay().ordinal() >= 0 && this.term.day.nextDay().ordinal() <= 4) {
                if (this.term.day.nextDay().ordinal() == 4) {
                    if (this.term.laterThan(new Term(7, 59, this.term.day)) && this.term.earlierThan(new Term(17, 1, this.term.day))) {
                        this.term.day = this.term.day.nextDay();
                        return true;
                    }
                } else {
                    if (this.term.laterThan(new Term(7, 59, this.term.day)) && this.term.earlierThan(new Term(20, 1, this.term.day))) {
                        this.term.day = this.term.day.nextDay();
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (this.term.day.nextDay().ordinal() >= 4 && this.term.day.nextDay().ordinal() <= 6) {
                if (this.term.day.nextDay().ordinal() == 4) {
                    if (this.term.laterThan(new Term(16, 59, this.term.day)) && this.term.earlierThan(new Term(20, 1, this.term.day))) {
                        this.term.day = this.term.day.nextDay();
                        return true;
                    }
                } else {
                    if (this.term.laterThan(new Term(7, 59, this.term.day)) && this.term.earlierThan(new Term(20, 1, this.term.day))) {
                        this.term.day = this.term.day.nextDay();
                        return true;
                    }
                }
            }
            return false;
        }

    }


    public boolean laterTime() {
        if (this.full_time) {
            if (this.term.day.ordinal() >= 0 && this.term.day.ordinal() <= 4) {
                if (this.term.day.ordinal() == 4) {
                    if (this.term.endTerm().laterThan(new Term(7, 59, this.term.day)) && this.term.endTerm().endTerm().earlierThan(new Term(17, 1, this.term.day))) {

                        this.term = this.term.endTerm();
                        return true;
                    }
                } else {

                    if (this.term.endTerm().laterThan(new Term(7, 59, this.term.day)) && this.term.endTerm().endTerm().earlierThan(new Term(20, 1, this.term.day))) {
                        this.term = this.term.endTerm();
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (this.term.day.ordinal() >= 4 && this.term.day.ordinal() <= 6) {
                if (this.term.day.ordinal() == 4) {
                    if (this.term.endTerm().laterThan(new Term(16, 59, this.term.day)) && this.term.endTerm().endTerm().earlierThan(new Term(20, 1, this.term.day))) {
                        this.term = this.term.endTerm();
                        return true;
                    }
                } else {
                    if (this.term.endTerm().laterThan(new Term(7, 59, this.term.day)) && this.term.endTerm().endTerm().earlierThan(new Term(20, 1, this.term.day))) {
                        this.term = this.term.endTerm();
                        return true;
                    }
                }
            }
            return false;
        }

    }


    public boolean earlierTime() {
        if (this.full_time) {
            if (this.term.day.ordinal() >= 0 && this.term.day.ordinal() <= 4) {
                if (this.term.day.ordinal() == 4) {
                    if (this.term.prevTerm().laterThan(new Term(7, 59, this.term.day)) && this.term.prevTerm().endTerm().earlierThan(new Term(17, 1, this.term.day))) {
                        this.term = this.term.prevTerm();
                        return true;
                    }
                } else {
                    if (this.term.prevTerm().laterThan(new Term(7, 59, this.term.day)) && this.term.prevTerm().endTerm().earlierThan(new Term(20, 1, this.term.day))) {
                        this.term = this.term.prevTerm();
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (this.term.day.ordinal() >= 4 && this.term.day.ordinal() <= 6) {
                if (this.term.day.ordinal() == 4) {
                    if (this.term.prevTerm().laterThan(new Term(16, 59, this.term.day)) && this.term.prevTerm().endTerm().earlierThan(new Term(20, 1, this.term.day))) {
                        this.term = this.term.prevTerm();
                        return true;
                    }
                } else {
                    if (this.term.prevTerm().laterThan(new Term(7, 59, this.term.day)) && this.term.prevTerm().endTerm().earlierThan(new Term(20, 1, this.term.day))) {
                        this.term = this.term.prevTerm();
                        return true;
                    }
                }
            }
            return false;
        }

    }

    @Override
    public String toString() {
        String rodzaj;
        if (this.full_time == true) {
            rodzaj = "stacjonarnych";
        } else {
            rodzaj = "niestacjonarnych";
        }
        return this.name + " (" + this.term.day + " " + this.term.hour + ":" + this.term.minute + " - " + this.term.endTerm().hour + ":" + this.term.endTerm().minute + ")\n" +
                this.year + " rok studiow " + rodzaj + "\n" + "Prowadzacy: " + this.teacherName;
    }
}

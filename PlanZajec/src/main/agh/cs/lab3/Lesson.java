package main.agh.cs.lab3;

import main.agh.cs.lab2.Term;

public class Lesson {
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

    public boolean earlierDay() {
        if (this.full_time) {
            if (this.term.getDay().prevDay().ordinal() >= 0 && this.term.getDay().prevDay().ordinal() <= 4) {
                if (this.term.getDay().prevDay().ordinal() == 4) {
                    if (this.term.laterThan(new Term(7, 59, this.term.getDay())) && this.term.earlierThan(new Term(17, 1, this.term.getDay()))) {
                        this.term.setDay(this.term.getDay().prevDay());
                        return true;
                    }
                } else {
                    if (this.term.laterThan(new Term(7, 59, this.term.getDay())) && this.term.earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term.setDay(this.term.getDay().prevDay());
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (this.term.getDay().prevDay().ordinal() >= 4 && this.term.getDay().prevDay().ordinal() <= 6) {
                if (this.term.getDay().prevDay().ordinal() == 4) {
                    if (this.term.laterThan(new Term(16, 59, this.term.getDay())) && this.term.earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term.setDay(this.term.getDay().prevDay());
                        return true;
                    }
                } else {
                    if (this.term.laterThan(new Term(7, 59, this.term.getDay())) && this.term.earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term.setDay(this.term.getDay().prevDay());
                        return true;
                    }
                }
            }
            return false;
        }

    }


    public boolean laterDay() {
        if (this.full_time) {
            if (this.term.getDay().nextDay().ordinal() >= 0 && this.term.getDay().nextDay().ordinal() <= 4) {
                if (this.term.getDay().nextDay().ordinal() == 4) {
                    if (this.term.laterThan(new Term(7, 59, this.term.getDay())) && this.term.earlierThan(new Term(17, 1, this.term.getDay()))) {
                        this.term.setDay(this.term.getDay().nextDay());
                        return true;
                    }
                } else {
                    if (this.term.laterThan(new Term(7, 59, this.term.getDay())) && this.term.earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term.setDay(this.term.getDay().nextDay());
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (this.term.getDay().nextDay().ordinal() >= 4 && this.term.getDay().nextDay().ordinal() <= 6) {
                if (this.term.getDay().nextDay().ordinal() == 4) {
                    if (this.term.laterThan(new Term(16, 59, this.term.getDay())) && this.term.earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term.setDay(this.term.getDay().nextDay());
                        return true;
                    }
                } else {
                    if (this.term.laterThan(new Term(7, 59, this.term.getDay())) && this.term.earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term.setDay(this.term.getDay().nextDay());
                        return true;
                    }
                }
            }
            return false;
        }

    }


    public boolean laterTime() {
        if (this.full_time) {
            if (this.term.getDay().ordinal() >= 0 && this.term.getDay().ordinal() <= 4) {
                if (this.term.getDay().ordinal() == 4) {
                    if (this.term.endTerm().laterThan(new Term(7, 59, this.term.getDay())) && this.term.endTerm().endTerm().earlierThan(new Term(17, 1, this.term.getDay()))) {

                        this.term = this.term.endTerm();
                        return true;
                    }
                } else {

                    if (this.term.endTerm().laterThan(new Term(7, 59, this.term.getDay())) && this.term.endTerm().endTerm().earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term = this.term.endTerm();
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (this.term.getDay().ordinal() >= 4 && this.term.getDay().ordinal() <= 6) {
                if (this.term.getDay().ordinal() == 4) {
                    if (this.term.endTerm().laterThan(new Term(16, 59, this.term.getDay())) && this.term.endTerm().endTerm().earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term = this.term.endTerm();
                        return true;
                    }
                } else {
                    if (this.term.endTerm().laterThan(new Term(7, 59, this.term.getDay())) && this.term.endTerm().endTerm().earlierThan(new Term(20, 1, this.term.getDay()))) {
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
            if (this.term.getDay().ordinal() >= 0 && this.term.getDay().ordinal() <= 4) {
                if (this.term.getDay().ordinal() == 4) {
                    if (this.term.prevTerm().laterThan(new Term(7, 59, this.term.getDay())) && this.term.prevTerm().endTerm().earlierThan(new Term(17, 1, this.term.getDay()))) {
                        this.term = this.term.prevTerm();
                        return true;
                    }
                } else {
                    if (this.term.prevTerm().laterThan(new Term(7, 59, this.term.getDay())) && this.term.prevTerm().endTerm().earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term = this.term.prevTerm();
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (this.term.getDay().ordinal() >= 4 && this.term.getDay().ordinal() <= 6) {
                if (this.term.getDay().ordinal() == 4) {
                    if (this.term.prevTerm().laterThan(new Term(16, 59, this.term.getDay())) && this.term.prevTerm().endTerm().earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term = this.term.prevTerm();
                        return true;
                    }
                } else {
                    if (this.term.prevTerm().laterThan(new Term(7, 59, this.term.getDay())) && this.term.prevTerm().endTerm().earlierThan(new Term(20, 1, this.term.getDay()))) {
                        this.term = this.term.prevTerm();
                        return true;
                    }
                }
            }
            return false;
        }

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

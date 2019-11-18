package main.agh.cs.lab5;

import main.agh.cs.lab2.Action;
import main.agh.cs.lab2.Day;
import main.agh.cs.lab2.Term;
import main.agh.cs.lab3.Lesson;
import main.agh.cs.lab4.ITimetable;

import java.util.*;
import java.util.stream.Stream;

public abstract class AbstractTimetable implements ITimetable {
    protected ArrayList<Lesson> lessons = new ArrayList<>();
    protected Map<Term, Lesson> lessonMap = new LinkedHashMap<>();


    @Override
    public boolean canBeTransferredTo(Term term, boolean full_time) {
        if ((term.getDay() == Day.SAT || term.getDay() == Day.SUN) && full_time) return false;
        if (term.getDay() == Day.FRI && term.endTerm().laterThan(new Term(17, 0)) && full_time) return false;
        if (term.getDay() != Day.SAT && term.getDay() != Day.SUN && term.getDay() != Day.FRI && !full_time)
            return false;
        if (term.getDay() == Day.FRI && term.earlierThan(new Term(17, 0)) && !full_time) return false;
        if (term.earlierThan(new Term(8, 0))) return false;
        if (term.endTerm().laterThan(new Term(20, 0))) return false;
        if (busy(term)) return false;
        return true;
    }

    @Override
    public boolean busy(Term term) {
        if (lessonMap.get(term) != null) return true;

        for (Lesson l : lessons) {
            if (term.getDay() == l.getTerm().getDay())
                if ((!l.getTerm().earlierThan(term) && term.endTerm().laterThan(l.getTerm()))
                        || (term.earlierThan(l.getTerm().endTerm()) && !l.getTerm().endTerm().laterThan(term.endTerm())))
                    return true;
        }
        return false;
    }

    @Override
    public boolean put(Lesson lesson) {
        if (canBeTransferredTo(lesson.getTerm(), lesson.isFull_time())) {
            lessons.add(lesson);
            lessonMap.put(lesson.getTerm(), lesson);
            return true;
        }
        throw new IllegalArgumentException("Cannot transfer");
    }


    @Override
    public void perform(Action[] actions) {
        int lessSize = lessons.size();
        for (int i = 0; i < actions.length; i++) {
            switch (actions[i]) {
                case TIME_EARLIER:
                    Lesson lesson = lessons.get(i % lessSize);
                    lessonMap.remove(lesson.getTerm());
                    lesson.earlierTime();
                    lessonMap.put(lesson.getTerm(), lesson);
                    break;
                case TIME_LATER:
                    Lesson lesson2 = lessons.get(i % lessSize);
                    lessonMap.remove(lesson2.getTerm());
                    lesson2.laterTime();
                    lessonMap.put(lesson2.getTerm(), lesson2);
                    break;
                case DAY_EARLIER:
                    Lesson lesson3 = lessons.get(i % lessSize);
                    lessonMap.remove(lesson3.getTerm());
                    lesson3.earlierDay();
                    lessonMap.put(lesson3.getTerm(), lesson3);
                    break;
                case DAY_LATER:
                    Lesson lesson4 = lessons.get(i % lessSize);
                    lessonMap.remove(lesson4.getTerm());
                    lesson4.laterDay();
                    lessonMap.put(lesson4.getTerm(), lesson4);
                    break;
            }
        }


    }

    @Override
    public Object get(Term term) {
        return lessonMap.get(term);
    }

    @Override
    public String toString() {
        Day firstDay = Day.MON;
        Day lastDay = Day.SUN;
        Term firstTerm = new Term(8, 0, firstDay);
        Term lastTerm = new Term(20, 0, lastDay);
        Day day = null;
        Term term = null;
        String res = "";
        while (res.length() < 12) {
            res += " ";
        }
        res += "*";
        int dayCount = 0;
        for (day = firstDay; day.compareTo(lastDay) <= 0 && dayCount < 7; day = day.nextDay(), dayCount++) {
            String a = day.toString();
            while (a.length() < 12) {
                a += " ";
            }
            res += a;
            res += "*";
        }
        res += "\n";
        for (int i = 0; i < 12; i++) {
            res += " ";
        }
        for (int i = 0; i < 92; i++) {
            res += "*";
        }
        res += "\n";
        for (term = firstTerm; term.earlierThan(lastTerm); term = term.endTerm()) {
            dayCount = 0;
            String b = "";
            if (term.getMinute() < 10) {
                b = "0";
            }
            String a = term.getHour() + ":" + b + term.getMinute() + "";
            String c = "";
            if (term.endTerm().getMinute() < 10) {
                c = "0";
            }
            a += "-" + term.endTerm().getHour() + ":" + c + term.endTerm().getMinute();
            while (a.length() < 12) {
                a += " ";
            }
            res += a;
            res += "*";

            for (day = firstDay; day.compareTo(lastDay) <= 0 && dayCount < 7; day = day.nextDay(), dayCount++) {
                term.setDay(day);
                res += "";
                a = "";
                Lesson tmp = (Lesson) this.get(term);
                if (tmp != null) {
                    a += tmp.getName();

                }


                while (a.length() < 12) {
                    a += " ";
                }
                res += a;
                res += "*";
            }
            res += "\n";
            for (int i = 0; i < 12; i++) {
                res += " ";
            }
            for (int i = 0; i < 92; i++) {
                res += "*";
            }
            res += "\n";
        }
        return res;
    }
}
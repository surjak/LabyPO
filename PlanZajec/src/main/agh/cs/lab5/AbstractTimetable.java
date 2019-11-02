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
        for (Lesson l : lessons) {
            if (term.getDay() == l.getTerm().getDay())
                if ((!l.getTerm().earlierThan(term) && term.endTerm().laterThan(l.getTerm())) || (term.earlierThan(l.getTerm().endTerm()) && !l.getTerm().endTerm().laterThan(term.endTerm())))
                    return true;
        }
        return false;
    }

    @Override
    public boolean put(Lesson lesson) {
        if (canBeTransferredTo(lesson.getTerm(), lesson.isFull_time())) {
            lessons.add(lesson);
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
                    lessons.get(i % lessSize).earlierTime();
                    System.out.println(lessons.get(i % lessSize));
                    break;
                case TIME_LATER:
                    lessons.get(i % lessSize).laterTime();
                    System.out.println(lessons.get(i % lessSize));
                    break;
                case DAY_EARLIER:
                    lessons.get(i % lessSize).earlierDay();
                    System.out.println(lessons.get(i % lessSize));
                    break;
                case DAY_LATER:
                    lessons.get(i % lessSize).laterDay();
                    System.out.println(lessons.get(i % lessSize));
                    break;
            }
        }


    }

    @Override
    public Object get(Term term) {
        Lesson l = null;
        for (Lesson lesson: lessons){
            if (lesson.getTerm().equals(term)){
                l=lesson;
            }
        }
        if (l != null) return l;
        throw new NoSuchElementException();
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
                if (this.busy(term)) {
                    Lesson tmp = (Lesson) this.get(term);
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
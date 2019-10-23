package main.agh.cs.lab4;

import main.agh.cs.lab2.Action;
import main.agh.cs.lab2.Day;
import main.agh.cs.lab2.Term;
import main.agh.cs.lab3.Lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Timetable1 implements ITimetable {

    ArrayList<Lesson> lessons = new ArrayList<>();

    @Override
    public boolean canBeTransferredTo(Term term, boolean full_time) {
        if (full_time) {
            if (term.getDay().ordinal() >= 0 && term.getDay().ordinal() <= 4) {
                if (term.getDay().ordinal() == 4) {
                    if (term.laterThan(new Term(7, 59, term.getDay())) && term.earlierThan(new Term(17, 1, term.getDay())) && term.endTerm().earlierThan(new Term(17, 1, term.getDay())) && !this.busy(term)) {
                        return true;
                    }
                } else {
                    if (term.laterThan(new Term(7, 59, term.getDay())) && term.earlierThan(new Term(20, 1, term.getDay())) && term.endTerm().earlierThan(new Term(20, 1, term.getDay())) && !this.busy(term)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (term.getDay().ordinal() >= 4 && term.getDay().ordinal() <= 6) {
                if (term.getDay().ordinal() == 4) {
                    if (term.laterThan(new Term(16, 59, term.getDay())) && term.earlierThan(new Term(20, 1, term.getDay())) && term.endTerm().earlierThan(new Term(20, 1, term.getDay())) && !this.busy(term)) {
                        return true;
                    }
                } else {
                    if (term.laterThan(new Term(7, 59, term.getDay())) && term.earlierThan(new Term(20, 1, term.getDay())) && term.endTerm().earlierThan(new Term(20, 1, term.getDay())) && !this.busy(term)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public boolean busy(Term term) {
        AtomicBoolean busy = new AtomicBoolean(false);
        lessons.forEach(lesson -> {
            if (lesson.getTerm().equals(term)) {
                busy.set(true);
            }
        });
        return busy.get();
    }

    @Override
    public boolean put(Lesson lesson) {
        if (canBeTransferredTo(lesson.getTerm(), lesson.isFull_time())) {
            lessons.add(lesson);
            return true;
        } else return false;
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
        return lessons.stream().filter(lesson -> lesson.getTerm().equals(term)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
//todo
        Day firstDay = Day.MON;
        Day lastDay = Day.SUN;
        Term firstTerm = new Term(8, 0, firstDay);
        Term lastTerm = new Term(20, 0, lastDay);
        Day day = null;
        Term term = null;
        boolean flag = true;
        for (day = firstDay; day.compareTo(lastDay) <= 0 && flag; day = day.nextDay()) {
            System.out.println(day);
            if (day.ordinal() == 6) {
                flag = false;
            }
            firstTerm.setDay(day);
            lastTerm.setDay(day);
            for (term = firstTerm; term.earlierThan(lastTerm); term = term.endTerm()) {
                System.out.print(term);
                if (this.busy(term)) {

                    System.out.println(((Lesson) this.get(term)).getName());
                } else
                    System.out.println(" ");
            }
        }
        return "";
    }
}

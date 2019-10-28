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
        StringBuilder builder = new StringBuilder();

        Day firstDay1 = Day.MON;
        Day lastDay1 = Day.SUN;
        Day day1 = null;
        boolean flag1 = true;
        builder.append(("Godzina:     ").substring(0,10));

        for (day1 = firstDay1; day1.compareTo(lastDay1) <= 0 && flag1; day1 = day1.nextDay()) {
            builder.append(("  *" + day1.toString() + "        ").substring(0,10));
            if (day1.ordinal() == 6) {
                flag1 = false;
            }
        }
        builder.append("\n");
        for (int i = 0; i < 8; i++) {
            builder.append("*****************".substring(0,10));
        }
        builder.append("\n");


        Day firstDay = Day.MON;
        Day lastDay = Day.SUN;
        Term firstTerm = new Term(8, 0, firstDay);
        Term lastTerm = new Term(20, 0, lastDay);
        Day day = null;
        Term term = null;

        for (term = firstTerm; term.earlierThan(lastTerm); term = term.endTerm()) {

            builder.append((term.getHour()+":" + term.getMinute()+"         ").substring(0,10));

            boolean flag = true;
            for (day = firstDay; day.compareTo(lastDay) <= 0 && flag; day = day.nextDay()) {
                Term term1 = new Term(term.getHour(), term.getMinute(), day);
                if (day.ordinal() == 6) {
                    flag = false;
                }
                if (this.busy(term1)) {

                    builder.append((((Lesson) this.get(term1)).getName() + "            ").substring(0,10));
                } else {
                    builder.append("     *       ".substring(0,10));
                }

            }
            builder.append("\n");
            firstTerm.setDay(day);
            lastTerm.setDay(day);

        }

//        System.out.println(builder);
        return builder.toString();
    }
}

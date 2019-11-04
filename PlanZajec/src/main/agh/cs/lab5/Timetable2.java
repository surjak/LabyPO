package main.agh.cs.lab5;

import main.agh.cs.lab2.Action;
import main.agh.cs.lab2.Day;
import main.agh.cs.lab2.Term;
import main.agh.cs.lab3.Lesson;
import main.agh.cs.lab4.ITimetable;

public class Timetable2 extends AbstractTimetable implements ITimetable {
    private static Break[] breaks;
    private static boolean skip_breaks;

    public Timetable2(Break[] breaks, boolean skip_breaks) {
        Timetable2.breaks = breaks;
        Timetable2.skip_breaks = skip_breaks;
    }


    @Override
    public void perform(Action[] actions) {
        super.perform(actions);
        optimizeBreaks();
    }

    private void optimizeBreaks() {
        for (Lesson lesson : lessons) {
            Break bre = getBreak(lesson.getTerm());
            if (bre != null) {
                int dur = lesson.getTerm().getDuration();
                Day day = lesson.getTerm().getDay();
                lesson.setTerm(new Term(bre.getTerm().endTerm().hour, bre.getTerm().endTerm().minute));
                lesson.getTerm().setDuration(dur);
                lesson.getTerm().setDay(day);
            }
        }
    }


    public boolean overlapOnBreak(Term term) {
        if (skip_breaks) return false;
        for (Break b : breaks) {
            if ((!b.getTerm().earlierThan(term) && term.endTerm().laterThan(b.getTerm())) ||
                    (term.earlierThan(b.getTerm().endTerm()) && !b.getTerm().endTerm().laterThan(term.endTerm())))
                return true;
        }
        return false;
    }

    public Break getBreak(Term term) {
        for (Break b : breaks) {
            if ((!b.getTerm().earlierThan(term) && term.endTerm().laterThan(b.getTerm())) ||
                    (term.earlierThan(b.getTerm().endTerm()) && !b.getTerm().endTerm().laterThan(term.endTerm())))
                return b;
        }
        return null;
    }

    @Override
    public String toString() {
//todo better

        if (skip_breaks) {
            return super.toString();
        } else {
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
                    if (this.overlapOnBreak(term)) {
                        Break br = this.getBreak(term);
                        term = new Term(br.getTerm().hour, br.getTerm().minute, br.getTerm().duration,day);
                        String d = "";
                        while (d.length() < 12) {
                            d += "-";
                        }
                        a += d;
                    } else if (this.busy(term)) {
                        Lesson tmp = (Lesson) this.get(term);
                        if (tmp!=null){
                            term = new Term(tmp.getTerm().getHour(), tmp.getTerm().minute,tmp.getTerm().duration,tmp.getTerm().getDay());
                            a += tmp.getName();
                        }

                    }else{
                        term.setDuration(90);

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
            lessons.forEach(lesson -> System.out.println(lesson));
            return res;
        }
    }
}
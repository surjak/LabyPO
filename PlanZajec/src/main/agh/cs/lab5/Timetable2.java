package main.agh.cs.lab5;

import main.agh.cs.lab2.Action;
import main.agh.cs.lab2.Term;
import main.agh.cs.lab4.ITimetable;

public class Timetable2 extends AbstractTimetable implements ITimetable {
    private static Break[] breaks;
    private static boolean skip_breaks;

    public Timetable2(Break[] breaks, boolean skip_breaks) {
        Timetable2.breaks = breaks;
        Timetable2.skip_breaks = skip_breaks;
    }

    @Override
    public boolean canBeTransferredTo(Term term, boolean full_time) {
        if(!skip_breaks) {
            for (Break b : breaks) {
                if ((!b.getTerm().earlierThan(term) && term.endTerm().laterThan(b.getTerm())) ||
                        (term.earlierThan(b.getTerm().endTerm()) && !b.getTerm().endTerm().laterThan(term.endTerm())))
                    return false;
            }
        }
        return super.canBeTransferredTo(term, full_time);
    }

    @Override
    public void perform(Action[] actions) {
        int lessSize = lessons.size();
        for (int i = 0; i < actions.length; i++) {
            switch (actions[i]) {
                case TIME_EARLIER:
                    lessons.get(i % lessSize).earlierTime();
                    break;
                case TIME_LATER:
                    lessons.get(i % lessSize).laterTime();
                    break;
                case DAY_EARLIER:
                    lessons.get(i % lessSize).earlierDay();
                    break;
                case DAY_LATER:
                    lessons.get(i % lessSize).laterDay();
                    break;
            }
            optimizeBreaks();
        }
    }

    private  void optimizeBreaks(){
        //todo
    }

    public boolean overlapOnBreak(Term term) {
        if(skip_breaks) return false;
        for(Break b : breaks) {
            if((!b.getTerm().earlierThan(term) && term.endTerm().laterThan(b.getTerm())) ||
                    (term.earlierThan(b.getTerm().endTerm()) && !b.getTerm().endTerm().laterThan(term.endTerm())))
                return true;
        }
        return false;
    }

    public Break getBreak(Term term) {
        for(Break b : breaks) {
            if((!b.getTerm().earlierThan(term) && term.endTerm().laterThan(b.getTerm())) ||
                    (term.earlierThan(b.getTerm().endTerm()) && !b.getTerm().endTerm().laterThan(term.endTerm())))
                return b;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Todo";
//
//        if(skip_breaks) {
//            return super.toString();
//        }
//        else {
//            Day firstDay = Day.MON;
//            Day lastDay = Day.SUN;
//            Term firstTerm = new Term(8, 0, firstDay);
//            Term lastTerm = new Term(20, 0, lastDay);
//            Day day = null;
//            Term term = null;
//            String res = "";
//            while (res.length() < 12) {
//                res += " ";
//            }
//            res += "*";
//            int dayCount = 0;
//            for (day = firstDay; day.compareTo(lastDay) <= 0 && dayCount < 7; day = day.nextDay(), dayCount++) {
//                String a = day.toString();
//                while (a.length() < 12) {
//                    a += " ";
//                }
//                res += a;
//                res += "*";
//            }
//            res += "\n";
//            for (int i = 0; i < 12; i++) {
//                res += " ";
//            }
//            for (int i = 0; i < 92; i++) {
//                res += "*";
//            }
//            res += "\n";
//            for (term = firstTerm; term.earlierThan(lastTerm); term = term.endTerm()) {
//                dayCount = 0;
//                String b = "";
//                if (term.getMinute() < 10) {
//                    b = "0";
//                }
//                String a = term.getHour() + ":" + b + term.getMinute() + "";
//                String c = "";
//                if (term.endTerm().getMinute() < 10) {
//                    c = "0";
//                }
//                a += "-" + term.endTerm().getHour() + ":" + c + term.endTerm().getMinute();
//                while (a.length() < 12) {
//                    a += " ";
//                }
//                res += a;
//                res += "*";
//                for (day = firstDay; day.compareTo(lastDay) <= 0 && dayCount < 7; day = day.nextDay(), dayCount++) {
//                    term.setDay(day);
//                    res += "";
//                    a = "";
//                    if (this.overlapOnBreak(term)) {
//                        Break br = this.getBreak(term);
//                        term = new Term(br.getTerm().hour, br.getTerm().minute, br.getTerm().duration);
////                        term =  (Term)(br.getTerm());
//                        String d = "";
//                        while (d.length() < 12) {
//                            d += "-";
//                        }
//                        a += d;
//                    } else if (this.busy(term)) {
//                        Lesson tmp = (Lesson) this.get(term);
//                        if (tmp!=null){
//                            term = tmp.getTerm();
//                            a += tmp.getName();
//                        }
//
//                    }
//                    while (a.length() < 12) {
//                        a += " ";
//                    }
//                    res += a;
//                    res += "*";
//                }
//                res += "\n";
//                for (int i = 0; i < 12; i++) {
//                    res += " ";
//                }
//                for (int i = 0; i < 92; i++) {
//                    res += "*";
//                }
//                res += "\n";
//            }
//
//            return res;
//        }
    }
}
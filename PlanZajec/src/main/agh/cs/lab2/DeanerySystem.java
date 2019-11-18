package main.agh.cs.lab2;

import main.agh.cs.lab3.ActionParser;
import main.agh.cs.lab3.Lesson;
import main.agh.cs.lab4.ITimetable;
import main.agh.cs.lab4.Timetable1;
import main.agh.cs.lab5.BasicTerm;
import main.agh.cs.lab5.Break;
import main.agh.cs.lab5.Timetable2;

import java.util.NoSuchElementException;

public class DeanerySystem {
    public static void main(String[] args) {
        try {
//            Term term1 = new Term(9, 45, Day.MON);
//            System.out.println(term1);                    //Ma się wypisać: "9:45 [90]"
//            Term term2 = new Term(10, 15, Day.TUE);
//            System.out.println(term2);                    //Ma się wypisać: "10:15 [90]"
//            System.out.println(term1.earlierThan(term2)); //Ma się wypisać: "true"
//            System.out.println(term1.equals(term2));      //Ma się wypisać: "false"
//            System.out.println(term1.endTerm(term2));     //Ma się wypisać: "9:45 [30]"
//            System.out.println(term1.endTerm());          //Ma się wypisać: "11:15 [90]"
//            System.out.println(Day.TUE.toString());
//            System.out.println(Day.SUN.nextDay().toString());

//            Lesson programowanieObiektowe = new Lesson(new Term(8, 0, Day.MON), "Programowanie obiektowe", "Stanisław Polak", 2, true);
//            System.out.println(programowanieObiektowe);

            Action[] actions = new ActionParser().parse(args);
            Break[] breaks = {new Break(new BasicTerm(9,30,5)), new Break(new BasicTerm(11,5,10)), new Break(new BasicTerm(12,45,5))};
            ITimetable timetable = new Timetable2(breaks,false);
//            ITimetable timetable = new Timetable1();
            Lesson l1 = new Lesson(timetable, new Term(8, 0, Day.TUE), "Angielski", "Nowak", 1);
            Lesson l2 = new Lesson(timetable, new Term(9, 35, Day.MON), "JTP", "Kowalski", 3);
            timetable.put(l1);
            timetable.put(l2);
            timetable.perform(actions);

            System.out.println(timetable.toString());
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
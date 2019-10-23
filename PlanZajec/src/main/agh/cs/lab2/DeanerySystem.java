package main.agh.cs.lab2;

import main.agh.cs.lab3.ActionParser;
import main.agh.cs.lab3.Lesson;
import main.agh.cs.lab4.ITimetable;
import main.agh.cs.lab4.Timetable1;

import java.util.Arrays;

public class DeanerySystem {

    public static void main(String[] args) {

        String[] changeLesson = {"d+", "t+", "aaa", "dd", "t+", "t-", "d+", "t+"};
        Action [] actions = new ActionParser().parse(changeLesson);
        ITimetable timetable = new Timetable1();
        Lesson l1 = new Lesson(timetable,new Term(11,0,Day.MON),"Angielski","Nowak",1, true);
        Lesson l2 = new Lesson(timetable,new Term(9,30,Day.WED),"JTP","Kowalski",3,true);
        timetable.put(l1);
        timetable.put(l2);
        timetable.perform(actions);
        System.out.println(timetable);
    }
}

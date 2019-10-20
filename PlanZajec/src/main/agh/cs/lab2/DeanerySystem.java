package main.agh.cs.lab2;

import main.agh.cs.lab3.ActionParser;
import main.agh.cs.lab3.Lesson;

import java.util.Arrays;

public class DeanerySystem {

    public static void main(String[] args) {

        String[] changeLesson = {"d+", "t+", "aaa", "dd", "d-", "t-"};
        Action[] actions = ActionParser.parse(changeLesson);

        Lesson PO = new Lesson(new Term(10, 0, Day.WED), "Programowanie Obiektowe", "Stanisław Polak", 2, true);

        Arrays.stream(actions).forEach(action -> {
            switch (action) {
                case DAY_LATER:
                    PO.laterDay();
                    System.out.println(PO);
                    break;
                case DAY_EARLIER:
                    PO.earlierDay();
                    System.out.println(PO);
                    break;
                case TIME_LATER:
                    PO.laterTime();
                    System.out.println(PO);
                    break;
                case TIME_EARLIER:
                    PO.earlierTime();
                    System.out.println(PO);
                    break;
            }
        });
        System.out.println(PO);
    }
}

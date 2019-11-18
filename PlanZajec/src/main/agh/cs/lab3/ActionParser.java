package main.agh.cs.lab3;

import main.agh.cs.lab2.Action;

import java.util.Arrays;

public class ActionParser {

    private static Action parseOne(String a) {
        switch (a) {
            case "d-":
                return Action.DAY_EARLIER;
            case "d+":
                return Action.DAY_LATER;
            case "t-":
                return Action.TIME_EARLIER;
            case "t+":
                return Action.TIME_LATER;
            default:
                throw new IllegalArgumentException("Translation" + a + "is incorrect");

        }
    }

    public static Action[] parse(String[] args) {
        return Arrays.stream(args).map(ActionParser::parseOne).filter(a -> a != null).toArray(Action[]::new);
    }
}

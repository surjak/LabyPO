package main.agh.cs.lab3;

import java.util.Arrays;
import java.util.Objects;


public class OptionParser {

    public static MoveDirection parseOne(String a) {
        switch (a) {
            case "f":
            case "forward":
                return MoveDirection.FORWARD;
            case "b":
            case "backward":
                return MoveDirection.BACKWARD;
            case "l":
            case "left":
                return MoveDirection.LEFT;
            case "r":
            case "right":
                return MoveDirection.RIGHT;
            default:
                throw new IllegalArgumentException(a+ " is not legal move specification");

        }
    }

    public static MoveDirection[] parse(String[] args) {

        return Arrays.stream(args).map(OptionParser::parseOne).filter(Objects::nonNull).toArray(MoveDirection[]::new);

    }
}

package agh.cs.lab1;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {
    public static void runForOne(Direction direction) {
        switch (direction) {
            case FORWARD:
                System.out.println("Zwierzak idzie do przodu");
                break;
            case BACKWARD:
                System.out.println("Zwierzak idzie do tylu");
                break;
            case LEFT:
                System.out.println("Zwierzak idzie w lewo");
                break;
            case RIGHT:
                System.out.println("Zwierzak idzie w prawo");
                break;

        }
    }


    public static void main(String[] args) {

        System.out.println("Start");


        Direction[] directions = new Direction[args.length];
        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f":
                    directions[i] = Direction.FORWARD;
                    i++;
                    break;
                case "b":
                    directions[i] = Direction.BACKWARD;
                    i++;
                    break;
                case "r":
                    directions[i] = Direction.RIGHT;
                    i++;
                    break;
                case "l":
                    directions[i] = Direction.LEFT;
                    i++;
                    break;
                default:
                    System.out.println("Niepoprawna wartosc");
            }
        }
        Stream<Direction> directionStream = Arrays.stream(directions).filter(Objects::nonNull);
        directionStream.forEach(Main::runForOne);


        System.out.println("Koniec");
    }
}

package agh.cs.lab3;

import java.util.Arrays;

public class CarSystem {
    public static void main(String[] args) {
        Car car = new Car();
        String[] directions = {"f", "A", "forward", "l", "k", "f", "right" ,"backward", "cos"};

        Arrays.stream(OptionParser.parse(directions)).forEach(a -> {
            car.move(a);
            System.out.println(car);
        });

        System.out.println(car);
    }
}

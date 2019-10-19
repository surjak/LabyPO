package main.agh.cs.lab2;

public enum Day {
    MON("Poniedzialek"), TUE("Wtorek"), WED("Sroda"), THU("Czwartek"), FRI("Piatek"), SAT("Sobota"), SUN("Niedziela");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Day nextDay() {
        return Day.values()[(this.ordinal() + 1) % 7];
    }

    public Day prevDay() {
        return Day.values()[((this.ordinal() - 1) + 7) % 7];
    }
}

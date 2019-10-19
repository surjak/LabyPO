package main.agh.cs.lab2;

public class DeanerySystem {

    public static void main(String[] args) {
        Term term1 = new Term(9,45);
        System.out.println(term1);
        Term term2 = new Term(10,15);
        System.out.println(term2);
        System.out.println(term1.earlierThan(term2));
        System.out.println(term1.equals(term2));
        System.out.println(term1.endTerm(term2));
        System.out.println(term1.endTerm());
        Day day = Day.MON;
        System.out.println(day);
        System.out.println(day.prevDay().prevDay().prevDay().prevDay().prevDay().prevDay().prevDay().prevDay());
        System.out.println(day.nextDay().nextDay().nextDay().nextDay().nextDay().nextDay().nextDay());
    }
}

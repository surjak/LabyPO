package main.agh.cs.lab4;

import main.agh.cs.lab2.Action;
import main.agh.cs.lab2.Term;
import main.agh.cs.lab3.Lesson;

public interface ITimetable {

    boolean canBeTransferredTo(Term term, boolean full_time);

    boolean busy(Term term);

    boolean put(Lesson lesson);

    void perform(Action[] actions);

    Object get(Term term);
}
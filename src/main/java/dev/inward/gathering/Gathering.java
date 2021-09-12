package dev.inward.gathering;

public abstract class Gathering<A extends Agenda> {

    private final A attendance;

    public Gathering(A attendance) {
        this.attendance = attendance;
    }
}

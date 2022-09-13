package dev.inward.matrix.clues;

import java.time.Clock;

public class ClockPolicy extends Policy<Clock> {

    public ClockPolicy(Clock clock) {
        super();
    }

    @Override
    protected Clock initDefault() {
        return null;
    }
}

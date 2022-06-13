package dev.inward.matrix.clues;

import java.time.Clock;

public class ClockClue extends Clue<Clock> {

    public ClockClue(Clock clock) {
        super();
    }

    @Override
    protected Clock initDefault() {
        return null;
    }
}

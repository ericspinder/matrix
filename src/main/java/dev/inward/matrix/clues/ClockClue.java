package dev.inward.matrix.clues;

import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.time.Clock;

public class ClockClue<X extends Context<X>> extends Clue<X, Clock> {

    public ClockClue(X context) {
        super(context);
    }

    @Override
    Clock init(X context) {
         return Clock.systemUTC();
    }
}

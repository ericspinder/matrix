package dev.inward.matrix.concept.matter.limitReached;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Dogma;
import dev.inward.matrix.concept.matter.Matter;

import java.time.Instant;
import java.util.concurrent.locks.StampedLock;

public class LimitReached<S extends Scheme<S,L>,L extends Library<S,L>> extends Matter<S, L,LimitReached<S,L>,LimitReached.Log> {

    public LimitReached(Rubric<S, L, LimitReached<S, L>, Log> rubric, Log[] logs) {
        super(rubric, logs);
    }

    @Override
    public String[] stageSubscriptions() {
        return new String[0];
    }

    @Override
    public boolean isSettled() {
        return false;
    }

    @Override
    protected StampedLock getGate() {
        return null;
    }

    @Override
    public boolean setSettled(String... subscriptions) {

    }

    @Override
    public int compareTo(LimitReached<S, L> o) {
        return 0;
    }

    public record Log(Instant instant, int overage, Dogma<?,?,?> dogma) implements Comparable<Log> {

        @Override
        public int compareTo(Log o) {
            return 0;
        }
    }
}

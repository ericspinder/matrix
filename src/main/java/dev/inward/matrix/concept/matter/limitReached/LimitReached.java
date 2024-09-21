package dev.inward.matrix.concept.matter.limitReached;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Matter;

import java.util.concurrent.locks.StampedLock;

public class LimitReached<S extends Scheme<S,L>,L extends Library<S,L>> extends Matter<S, L,LimitReached<S,L>, Matter.Id> {

    public LimitReached(Id<S, L, LimitReached<S, L>, Id> id, Id[] ids) {
        super(id, ids);
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

}

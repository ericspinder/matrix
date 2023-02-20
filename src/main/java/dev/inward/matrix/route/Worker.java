package dev.inward.matrix.route;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

import java.util.BitSet;

public class Worker<F extends Fact<F,I,ID,VERSION,X>,I extends Identity<I,ID,VERSION,X>,ID extends Comparable<ID>,VERSION extends Comparable<VERSION>,X extends Context<VERSION,X>,R extends Representative<F,I,ID,VERSION,X,R>> extends Thread {


    protected volatile BitSet state;
    public enum State {
        NEW(0, "Thread is new, not started"),
        COMPLETING(1, "Thread is working"),
        NORMAL(2,"Waiting for work"),
        EXCEPTIONAL(3,"Exceptional"),
        CANCELLED(4,"Cancelled"),
        INTERRUPTING(5,"Interrupting"),
        INTERRUPTED(6,"Interrupted"),
        ;
        final BitSet id;
        final String description;
        State(int n, String description) {
            this.id = new BitSet(n);
            this.description = description;
        }
    }


}

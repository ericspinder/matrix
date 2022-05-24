package dev.inward.matrix.Agent;

import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;
import java.time.Clock;

public class Edition<E extends Edition<E,X>,X extends Context<X>> implements Comparable<E>, Serializable {

    protected final X context;
    protected final Version version;

    public Edition(X context, Version version) {
        this.context = context;
        this.version = version;

    }

    @Override
    public int compareTo(E o) {
        return 0;
    }

    public static class Code<X extends Context<X>> extends Edition<Code<X>,X> {
        public Code(X context, Version version) {
            super(context, version);
        }
    }
    public static class Jar<X extends Context<X>> extends Edition<Jar<X>,X> {
        public Jar(X context, Version version) {
            super(context, version);
        }
    }
    public static class Source<X extends Context<X>> extends Edition<Source<X>,X> {
        public Source(X context, Version version) {
            super(context, version);
        }
    }
}

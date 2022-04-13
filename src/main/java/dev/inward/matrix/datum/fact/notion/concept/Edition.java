package dev.inward.matrix.datum.fact.notion.concept;

import java.io.Serializable;
import java.time.Clock;

public class Edition<E extends Edition<E>> implements Comparable<E>, Serializable {

    private final Clock clock;
    private String version;

    public Edition(Clock clock) {
        this.clock = clock;
    }

    @Override
    public int compareTo(E o) {
        return 0;
    }

    public static class Code extends Edition<Code> {

        public Code(Clock clock) {
            super(clock);
        }
    }
    public static class Jar extends Edition<Jar> {

        public Jar(Clock clock) {
            super(clock);
        }
    }

    public static class Source extends Edition<Source> {
        public Source(Clock clock) {
            super(clock);
        }
    }


    public Clock getClock() {
        return clock;
    }

}

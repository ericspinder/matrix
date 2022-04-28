package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.Agent.Version;

import java.io.Serializable;
import java.time.Clock;

public class Edition<E extends Edition<E>> implements Comparable<E>, Serializable {

    private final Clock clock;
    private Version version;

    public Edition(Version version, Clock clock) {
        this.version = version;
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

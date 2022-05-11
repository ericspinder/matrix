package dev.inward.matrix.Agent;

import java.io.Serializable;
import java.time.Clock;

public class Edition<E extends Edition<E>> implements Comparable<E>, Serializable {


    private Version version;

    public Edition(Version version) {
        this.version = version;

    }

    @Override
    public int compareTo(E o) {
        return 0;
    }

    public static class Code extends Edition<Code> {

        public Code(Version version, Clock clock) {
            super(version);
        }
    }
    public static class Jar extends Edition<Jar> {

        public Jar(Version version, Clock clock) {
            super(version);
        }
    }

    public static class Source extends Edition<Source> {
        public Source(Version version, Clock clock) {
            super(version);
        }
    }
}

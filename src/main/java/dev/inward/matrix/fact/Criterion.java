package dev.inward.matrix.fact;

import dev.inward.matrix.Library;
import dev.inward.matrix.Meta_I;
import dev.inward.matrix.Range;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.engine.Zone;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.BitSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class Criterion<DATUM,S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> implements Comparable<Criterion>,Meta_I, WatchEvent.Modifier {

    protected final String label;
    protected final String description;
    protected final transient String name;
    protected final Operational<DATUM,S,L,PATH,ID,T,C> operational;

    @Override
    public String name() {
        return this.name;
    }


    protected String buildName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClassName()).append('.').append(label).append('_').append('[');
        for (Zone zone: zones) {
            sb.append(zone.label).append(',');
        }
        sb.deleteCharAt(sb.length());
        sb.append(']');
        return sb.toString();
    }

    public Criterion(String label, String description, Operational<DATUM,S,L,PATH,ID,T,C> operational) {
        this.label = label;
        this.description = description;
        this.operational = operational;
        this.name = buildName();
    }

    public static class Limiter extends Criterion {

        protected final int totalAllowed;
        protected final Map<Integer,Alert> warnLevels;

        public Limiter(String label, String description, Zone[] zones, int totalAllowed, Map<Integer,Alert> warnLevels) {
            super(label,description, zones);
            this.totalAllowed = totalAllowed;
            this.warnLevels = warnLevels;
        }

        @Override
        public boolean repeat() {
            return true;
        }

        public int getTotalAllowed() {
            return totalAllowed;
        }

        public Map<Integer, Alert> getWarnLevels() {
            return warnLevels;
        }

    }
    public static class Timeout extends Criterion {

        protected final long timeout;
        protected final TimeUnit timeUnit;

        public Timeout(String label, String description, Zone[] zones, long timeout, TimeUnit timeUnit) {
            super(label,description, zones);
            this.timeout = timeout;
            this.timeUnit = timeUnit;
        }

        @Override
        public boolean repeat() {
            return true;
        }

        public long getTimeout() {
            return timeout;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }

        public Duration duration() {
            return Duration.of(timeout, timeUnit.toChronoUnit());
        }

        public Instant whenFromNow() {
            return Instant.now().plus(timeout,timeUnit.toChronoUnit());
        }
        public Instant whenFromThen(Instant then) {
            return then.plus(timeout,timeUnit.toChronoUnit());
        }

    }

    public static class Ranged<DATUM extends Comparable<DATUM>> extends Criterion {

        protected final Range range;
        public Ranged(String label, String description, Zone[] zones, Range<DATUM> range) {
            super(label,description, zones);
            this.range = range;
        }

        @Override
        public boolean repeat() {
            return true;
        }

    }
    public static class Timed extends Criterion {

        protected final long count;
        protected final TimeUnit timeUnit;

        public Timed(String label, String description, Zone[] zones, long count, TimeUnit timeUnit) {
            super(label,description, zones);
            this.count = count;
            this.timeUnit = timeUnit;
        }

        @Override
        public boolean repeat() {
            return false;
        }
    }
    public static class OnCountdown<DATUM> extends Criterion {
        public OnCountdown(String label, String description, Zone[] zones) {
            super(label, description, zones);
        }

        @Override
        public boolean repeat() {
            return false;
        }
    }
    /**
     * https://stackoverflow.com/questions/2473597/bitset-to-and-from-integer-long
     */
    public static class Bits {

        public static BitSet convert(long value) {
            BitSet bits = new BitSet();
            int index = 0;
            while (value != 0L) {
                if (value % 2L != 0) {
                    bits.set(index);
                }
                ++index;
                value = value >>> 1;
            }
            return bits;
        }

        public static long convert(BitSet bits) {
            long value = 0L;
            for (int i = 0; i < bits.length(); ++i) {
                value += bits.get(i) ? (1L << i) : 0L;
            }
            return value;
        }
    }
    public abstract boolean repeat();
    @Override
    public final String getLabel() {
        return label;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Criterion that) {
        return this.name().compareTo(that.name());
    }
}
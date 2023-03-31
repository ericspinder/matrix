package dev.inward.matrix.fact;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.engine.Purpose;
import dev.inward.matrix.engine.Variant;

import java.time.Duration;
import java.util.BitSet;
import java.util.concurrent.TimeUnit;

public abstract class Criterion implements Meta_I {

    protected final String label;
    protected final String description;
    protected final String predictableClassName;
    protected final Purpose[] purposes;

    public Criterion(String label, String description,String predictableClassName,Purpose[] purposes) {
        this.label = label;
        this.description = description;
        this.predictableClassName = predictableClassName;
        this.purposes = purposes;
    }

    public static class Limiter extends Criterion {

        protected final int totalAllowed;
        protected final int warnLevel;

        public Limiter(String label, String description,String limitedClassName, Purpose[] purposes,int totalAllowed, int warnLevel) {
            super(label,description,limitedClassName,purposes);
            this.totalAllowed = totalAllowed;
            this.warnLevel = warnLevel;
        }
        public int getTotalAllowed() {
            return totalAllowed;
        }

        public int getWarnLevel() {
            return warnLevel;
        }

    }
    public static class Timeout extends Criterion {

        protected final long timeout;
        protected final TimeUnit timeUnit;

        public Timeout(String label, String description, String timeoutClassName, Purpose[] purposes, long timeout,TimeUnit timeUnit) {
            super(label,description,timeoutClassName,purposes);
            this.timeout = timeout;
            this.timeUnit = timeUnit;
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

    }

    public static class Ranged<DATUM extends Comparable<DATUM>> extends Criterion {

        protected final DATUM maxValue;
        protected final DATUM minValue;
        protected final Comparable<DATUM> comparable;
        public Ranged(String label, String description, String rangedClassName, Purpose[] purposes, DATUM maxValue, DATUM minValue, Comparable<DATUM> comparable) {
            super(label,description,rangedClassName,purposes);
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.comparable = comparable;
        }

        public DATUM getMaxValue() {
            return maxValue;
        }

        public DATUM getMinValue() {
            return minValue;
        }

        public Comparable<DATUM> getComparable() {
            return comparable;
        }
    }
    public static class Chronological<DATUM> extends Criterion {
        public Chronological(Variant variant, String label,String description) {
            super(variant,label,description);
        }
    }
    public static class OnCountdown<DATUM> extends Criterion {
        public OnCountdown(Variant variant,String label,String description) {
            super(variant,label,description);
        }
    }

    @Override
    public final String getLabel() {
        return label;
    }

    @Override
    public final String getDescription() {
        return description;
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
}
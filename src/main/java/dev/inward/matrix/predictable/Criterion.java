package dev.inward.matrix.predictable;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.Range;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Alert;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.BitSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class Criterion implements Meta_I, WatchEvent.Modifier {

    protected final String label;
    protected final String description;
    protected final String i18n;
    protected final Zone[] zones;
    protected final boolean singleCustomer;
    protected final boolean autoStart;

    public Criterion(String label, String description, Zone[] zones, String i18n, boolean autoStart, boolean singleCustomer) {
        this.label = label;
        this.description = description;
        this.zones = zones;
        if (i18n != null) {
            this.i18n = i18n;
        }
        else {
            this.i18n = this.parseDefaultI18n();
        }
        this.autoStart = autoStart;
        this.singleCustomer = singleCustomer;
    }

    public abstract boolean repeat();
    @Override
    public String name() {
        return this.label;
    }

    @Override
    public String getI18n() {
        return i18n;
    }
    @Override
    public final String getLabel() {
        return label;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    public boolean isAutoStart() {
        return autoStart;
    }

    public boolean isSingleCustomer() {
        return singleCustomer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClassName()).append('.').append(label).append('_').append(description).append('_').append('[');
        for (Zone zone: zones) {
            sb.append(zone.label).append(',');
        }
        sb.deleteCharAt(sb.length());
        sb.append(']');
        return sb.toString();
    }

    public static class Limiter extends Criterion {

        protected final int totalAllowed;
        protected final Map<Integer, Alert> warnLevels;

        public Limiter(Zone[] zones, int totalAllowed, Map<Integer,Alert> warnLevels) {
            this("limiter","generates Alerts based on the count of either",zones,null,true,true,null,totalAllowed,warnLevels);
        }
        public Limiter(String label, String description, Zone[] zones, String i18n, boolean autoStart, boolean singleCustomer, String targetClassName, int totalAllowed, Map<Integer,Alert> warnLevels) {
            super(label,description,zones,i18n,autoStart,singleCustomer,targetClassName);
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

        public Timeout(Zone[] zones, long timeout, TimeUnit timeUnit) {
            this("Timeout", "Timeout criteria with convince methods to describe it from 'now'", zones,null,true,true,timeout,timeUnit);
        }
        public Timeout(String label, String description, Zone[] zones, String i18n, boolean autoStart, boolean singleCustomer, long timeout, TimeUnit timeUnit) {
            super(label,description, zones,i18n,autoStart,singleCustomer);
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

        protected final Range<DATUM> range;

        public Ranged(Zone[] zones,Range<DATUM> range) {
            this("Ranged","ranged datum of declared type, probably a PATH of the declared type",zones,null,false,range);
        }
        public Ranged(String label, String description, Zone[] zones,String i18n,boolean singleCustomer,Range<DATUM> range) {
            super(label,description, zones,i18n,singleCustomer);
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

        public Timed(Zone[] zones, long count, TimeUnit timeUnit) {
            this("Timed", "Criteria based on time",zones, null,false, count,timeUnit);
        }
        public Timed(String label, String description, Zone[] zones, String i18n,boolean singleCustomer, long count, TimeUnit timeUnit) {
            super(label,description, zones,i18n,singleCustomer);
            this.count = count;
            this.timeUnit = timeUnit;
        }

        @Override
        public boolean repeat() {
            return false;
        }
    }
    public static class OnCountdown<DATUM> extends Criterion {
        public OnCountdown(String label, String description, Zone[] zones, String i18n,boolean singleCustomer) {
            super(label, description, zones, i18n, singleCustomer);
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


}
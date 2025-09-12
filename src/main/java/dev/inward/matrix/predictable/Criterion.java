/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.*;

import java.nio.file.WatchEvent;

public abstract class Criterion<PK extends MatrixKey<PK,PI,PV,PM,PR,PG>,PI extends MatrixItem<PK,PI,PV,PM,PR,PG>,PV extends View<PI,PM>,PM extends Model<PI>,PR extends _WeakReference<PI,PV,PM,PR,PG>,PG extends Concept<PI,PV,PM,PR,PG>, DATUM,V extends View<DATUM,M>,M extends Model<DATUM>,R extends _WeakReference<DATUM,V,M,R,G>,G extends Concept<DATUM,V,M,R,G>> implements Meta_I, WatchEvent.Modifier {

    protected final String label;
    protected final String description;
    protected final String i18n;

    public Criterion(String label, String description, String i18n) {
        this.label = label;
        this.description = description;
        if (i18n != null) {
            this.i18n = i18n;
        }
        else {
            this.i18n = this.parseDefaultI18n();
        }
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClassName()).append('.').append(label).append('_').append(description).append('_').append('[');
        sb.deleteCharAt(sb.length());
        sb.append(']');
        return sb.toString();
    }
//    public static class Timeout extends Criterion {
//
//        protected final long timeout;
//        protected final TimeUnit timeUnit;
//
//        public Timeout(Zone[] zones, long timeout, TimeUnit timeUnit) {
//            this("Timeout", "Timeout criteria with convince methods to describe it from 'now'", zones,null,true,true,timeout,timeUnit);
//        }
//        public Timeout(String label, String description, Zone[] zones, String i18n, boolean autoStart, boolean singleCustomer, long timeout, TimeUnit timeUnit) {
//            super(label,description, zones,i18n,autoStart,singleCustomer);
//            this.timeout = timeout;
//            this.timeUnit = timeUnit;
//        }
//
//        @Override
//        public boolean repeat() {
//            return true;
//        }
//
//        public long getTimeout() {
//            return timeout;
//        }
//
//        public TimeUnit getTimeUnit() {
//            return timeUnit;
//        }
//
//        public Duration duration() {
//            return Duration.of(timeout, timeUnit.toChronoUnit());
//        }
//
//        public Instant whenFromNow() {
//            return Instant.now().plus(timeout,timeUnit.toChronoUnit());
//        }
//        public Instant whenFromThen(Instant then) {
//            return then.plus(timeout,timeUnit.toChronoUnit());
//        }

//    }

//    public static class Ranged<DATUM extends Comparable<DATUM>> extends Criterion {
//
//        protected final Range<DATUM> range;
//
//        public Ranged(String label, String description, Zone[] zones, String i18n, boolean autoStart, boolean singleCustomer,Range<DATUM> range) {
//            super(label,description, zones,i18n,autoStart,singleCustomer);
//            this.range = range;
//        }
//
//        @Override
//        public boolean repeat() {
//            return true;
//        }
//
//    }
//    public static class Timed extends Criterion {
//
//        protected final long count;
//        protected final TimeUnit timeUnit;
//
//        public Timed(String label, String description, Zone[] zones, String i18n, boolean autoStart, boolean singleCustomer, long count, TimeUnit timeUnit) {
//            super(label,description, zones,i18n,autoStart,singleCustomer);
//            this.count = count;
//            this.timeUnit = timeUnit;
//        }
//
//        @Override
//        public boolean repeat() {
//            return false;
//        }
//    }
//    public static class OnCountdown<DATUM> extends Criterion {
//
//        protected final int openingValue;
//        public OnCountdown(String label, String description, Zone[] zones, String i18n, boolean autoStart, boolean singleCustomer, int openingValue) {
//            super(label, description, zones, i18n,autoStart, singleCustomer);
//            this.openingValue = openingValue;
//        }
//
//        @Override
//        public boolean repeat() {
//            return false;
//        }
//    }
//    /**
//     * https://stackoverflow.com/questions/2473597/bitset-to-and-from-integer-long
//     */
//    public static class Bits {
//
//        public static BitSet convert(long value) {
//            BitSet bits = new BitSet();
//            int directory = 0;
//            while (value != 0L) {
//                if (value % 2L != 0) {
//                    bits.set(directory);
//                }
//                ++directory;
//                value = value >>> 1;
//            }
//            return bits;
//        }
//
//        public static long convert(BitSet bits) {
//            long value = 0L;
//            for (int i = 0; i < bits.length(); ++i) {
//                value += bits.get(i) ? (1L << i) : 0L;
//            }
//            return value;
//        }
//    }
}
/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward.crud;

import java.time.Instant;
import java.util.function.Function;

public abstract class Reaper<EXPIRE extends Comparable<EXPIRE>, R extends Reaper<EXPIRE, R, F>, F extends Function<EXPIRE, ? super Comparable<EXPIRE>>> implements Comparable<R> {
    protected final EXPIRE expire;
    protected final F function;

    public Reaper(EXPIRE expire, F function) {
        this.expire = expire;
        this.function = function;
    }

    public EXPIRE getExpire() {
        return this.expire;
    }

    protected static class DeleteIfExpired implements Function<Instant,CarelessReaper> {

        @Override
        public CarelessReaper apply(Instant instant) {
            return null;
        }

    }
    public static class CarelessReaper extends Reaper<Instant,DeleteIfExpired> {

        public CarelessReaper(Instant expire,DeleteIfExpired deleteIfExpired) {
            super(expire,deleteIfExpired);
        }

        @Override
        public int compareTo(CarelessReaper o) {
            return 0;
        }
    }
}

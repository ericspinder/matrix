package dev.inward.matrix.fact;

import dev.inward.matrix.Clerk;
import dev.inward.matrix.Pathway;

import java.time.Instant;
import java.util.Map;

public abstract class Expire {

    abstract boolean isExpired();

    public static class HoldFor extends Expire {
        protected final Map<Rider<?,?,?,?,?>,Instant> conceptLastClerkMap;

        public HoldFor(Map<Concept<?,?,?,?,?>,Instant> conceptLastClerkMap) {

        }
    }
}

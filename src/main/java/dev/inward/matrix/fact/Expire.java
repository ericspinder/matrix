package dev.inward.matrix.fact;

import dev.inward.matrix.Concept;
import dev.inward.matrix.Representitive;

import java.time.Instant;
import java.util.Map;

public abstract class Expire {

    public static final String Property = "expire";
    abstract boolean isExpired();

    public static class HoldFor extends Expire {
        protected final Map<Representitive<?,?,?,?,?>,Instant> conceptLastClerkMap;

        public HoldFor(Map<Concept<?,?,?,?,?>,Instant> conceptLastClerkMap) {

        }
    }
}

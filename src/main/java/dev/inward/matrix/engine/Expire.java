package dev.inward.matrix.engine;

import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.fact.notion.authority.Authority;
import dev.inward.matrix.fact.notion.concept.Context;

import java.time.Instant;

public abstract class Expire<VERSION extends Comparable<VERSION>, V extends Version<VERSION,V>, E extends Expire<VERSION,V,E>> implements Comparable<E> {

    protected final Instant expireTime;

    public Expire(Instant expireTime) {
        this.expireTime = expireTime;
    }

    public Instant getExpireTime() {
        return expireTime;
    }
    public abstract boolean checkExpire(Authority authorityCode);

    public static class DefaultExpire<VERSION extends Comparable<VERSION>,V extends Version<VERSION,V>> extends Expire<VERSION,V,DefaultExpire<VERSION,V>> {

        public DefaultExpire(Instant expireTime) {
            super(expireTime);
        }

        @Override
        public boolean checkExpire(Context context) {
            return false;
        }
    }

}

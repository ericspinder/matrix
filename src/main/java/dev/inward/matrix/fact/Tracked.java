package dev.inward.matrix.fact;

import dev.inward.matrix.engine.Expire;
import dev.inward.matrix.engine.Version;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;

public abstract class Tracked<T extends Tracked<T,I,X,VERSION,V,E>,I extends Identity<I,X>,X extends Context<X>,VERSION extends Comparable<VERSION>,V extends Version<VERSION,V,E>,E extends Expire<VERSION,V,E>> extends Fact<T,I,X> {

    protected final V version;
    protected final E expire;

    public Tracked(I identity,V version,E expire) {
        super(identity);
        this.version = version;
        this.expire = expire;
    }

    public V getVersion() {
        return version;
    }

    public E getExpire() {
        return expire;
    }
}

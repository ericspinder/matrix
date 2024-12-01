package dev.inward.matrix;

import java.lang.ref.SoftReference;

public class Ware<DATUM,W extends Ware<DATUM,W>> extends SoftReference<DATUM> {

    protected final Resource<DATUM,W> resource;
    protected final Long sequence;

    public Ware(DATUM referent, Resource<DATUM,W> resource) {
        super(referent, resource);
        this.resource = resource;
        this.sequence = resource.incrementAndGet();
    }
}

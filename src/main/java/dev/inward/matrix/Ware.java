package dev.inward.matrix;

import java.lang.ref.SoftReference;

public class Ware<DATUM,W extends Ware<DATUM,W,A>,A extends Attributes<DATUM,W,A>> extends SoftReference<DATUM>  {

    protected final Resource<DATUM,W,A> datumResource;
    protected final Long sequence;
    protected final A attributes;

    public Ware(DATUM referent, Resource<DATUM,W,A> datumResource) {
        super(referent, datumResource);
        this.datumResource = datumResource;
        this.sequence = datumResource.incrementAndGet();
        this.attributes = datumResource.createAttributes(referent);
    }
}

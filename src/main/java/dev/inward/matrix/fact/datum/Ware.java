package dev.inward.matrix.fact.datum;

import dev.inward.matrix.Context;
import dev.inward.matrix.MatrixException;
import dev.inward.matrix.Resource;
import dev.inward.matrix.fact.Concept;

import java.lang.ref.SoftReference;
import java.util.UUID;

public class Ware<DATUM,W extends Ware<DATUM,W>> extends SoftReference<DATUM> implements Comparable<W> {

    protected final UUID uuid;
    public Ware(UUID uuid, DATUM datum, Resource<DATUM> resource) {
        super(datum, resource);
        this.uuid = (uuid == null)? UUID.randomUUID():uuid;
        try {
            resource.increment();
        }
        catch (MatrixException matrixException) {
            ((Context<?,?,?,?,?>)datum.getClass().getProtectionDomain()).getFactory().processError(datum, resource.parent,matrixException);
        }
    }
    protected void doIncrementFailure(DATUM datum, Concept.Resource<?,?,?,?> resource, MatrixException matrixException) {
        datum.getClass().getProtectionDomain().
    }

    @Override
    public int compareTo(W that) {
        return this.uuid.compareTo(that.uuid);
    }
}
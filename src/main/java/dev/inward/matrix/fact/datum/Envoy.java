package dev.inward.matrix.fact.datum;

import dev.inward.matrix.resources.Resource;

import java.io.Serializable;
import java.lang.invoke.CallSite;
import java.lang.ref.SoftReference;
import java.util.UUID;

public class Envoy<DATUM> extends SoftReference<DATUM> {

    public Envoy(DATUM datum, Resource<DATUM> resource) {
        super(datum, resource);
        if (resource.increment()) {
        }
    }

}
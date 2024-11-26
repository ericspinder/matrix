package dev.inward.matrix;

import java.lang.ref.SoftReference;

public class Ware<DATUM,W extends Ware<DATUM,W,PR>,PR extends Representitive<?,?,?,?,PR,?>> extends SoftReference<DATUM> {

    public Ware(DATUM referent, Resource<DATUM,W,PR> resource) {
        super(referent, resource);
    }
}

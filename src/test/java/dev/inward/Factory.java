package dev.inward;

import java.lang.ref.SoftReference;
import java.security.ProtectionDomain;

public class Factory<PATH extends Comparable<PATH>,X extends ProtectionDomain,ID extends Comparable<ID>,I extends Comparable<I>,C extends Comparable<C>,R extends SoftReference<C>> extends ClassLoader {


    public <DATUM, D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E>> E add(D datum) {
        return null;
    }


}

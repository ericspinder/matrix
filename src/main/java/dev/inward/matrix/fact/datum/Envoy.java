package dev.inward.matrix.fact.datum;

import dev.inward.matrix.Library;
import dev.inward.matrix.MatrixException;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.resources.Resource;

import java.lang.ref.SoftReference;

public class Envoy<DATUM,E extends Envoy<DATUM,E,S,L,PATH,ID,T,C>,S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends SoftReference<DATUM> {


    protected
    public Envoy(DATUM datum, Resource<DATUM,S,L,T,C> resource) {
        super(datum, resource);
        try {
            resource.increment();
        }
        catch (MatrixException matrixException) {
            doIncrementFailure(datum,resource,matrixException);
        }
    }
    protected void doIncrementFailure(DATUM datum, Resource<DATUM,S,L,?,?> resource,MatrixException matrixException ) {

    }

}
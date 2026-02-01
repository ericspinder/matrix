/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward;

import dev.inward.matrix.concept.Concept;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.item.datum.standard.Standard;
import dev.inward.matrix.item.datum.DatumView;

import java.io.Serializable;
import java.util.function.Function;


public abstract class Datum<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> implements Serializable {

    @SuppressWarnings("unchecked")
    public final Envoy<DATUM,D,V> envoy = ((Factory<?,?,?,?,?,?>)this.getClass().getClassLoader()).add((D)this);

    static class DatumConcept<S extends Scheme<S,L>,L extends Authority<S,L>,D extends dev.inward.matrix.item.datum.Datum<S,L,D,E,A>, E extends DatumReferenceWeak<S,L,D,E,A>,A extends DatumView<S,L,D,E,A>> extends Concept<S,L,D,E,A> {



        public DatumConcept(Standard standard, Function<E,E> graveDigger) {
            super(standard, graveDigger);
        }
    }
}

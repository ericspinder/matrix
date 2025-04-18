/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward;

import dev.inward.matrix.*;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

import java.io.Serializable;
import java.util.function.Function;


public abstract class Datum<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> implements Serializable {

    @SuppressWarnings("unchecked")
    public final Envoy<DATUM,D,V> envoy = ((Factory<?,?,?,?,?,?>)this.getClass().getClassLoader()).add((D)this);

    static class DatumLibrarian<S extends Scheme<S,L>,L extends Library<S,L>,D extends dev.inward.matrix.Datum<S,L,D,E,A>, E extends DatumReference<S,L,D,E,A>,A extends DatumView<S,L,D,E,A>> extends Librarian<S,L,D,E,A> {



        public DatumLibrarian(Standard standard, Function<E,E> graveDigger) {
            super(standard, graveDigger);
        }
    }
}

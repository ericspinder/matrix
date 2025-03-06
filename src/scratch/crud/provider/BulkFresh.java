/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.provider;

import dev.inward.crud.Container;
import dev.inward.matrix.Provider;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Operational;

import java.io.Serializable;

public class BulkFresh<DATUM extends Comparable<DATUM> & Serializable,O extends Operational<DATUM,O>, B extends Bus<DATUM,O,B,C,D,?,?,?>, C extends Container<DATUM,O,B,C,D>,D extends Datum<D,O,C,?>> extends Provider<DATUM,O,B,C,D> {

    public BulkFresh(O options, B bus) {
        super(bus);
    }

    @Override
    public U getWrappedReady() {
        return null;
    }
}

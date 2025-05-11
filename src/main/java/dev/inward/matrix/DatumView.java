/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.directory.*;

public class DatumView<D extends Datum<D,V,M,R,L>,V extends DatumView<D,V,M,R,L>,M extends DatumModel<D,V,M,R,L>,R extends DatumReference<D,V,M,R,L>,L extends DatumLibrarian<D,V,M,R,L>> extends View<D,V,M> {

    public DatumView(String name, D datum) {
        super(name, datum);
    }

    @SuppressWarnings("unchecked")
    @Override
    public M getModel() {
        return (M) datum.getContext().getLibrarian().getModel();
    }
}

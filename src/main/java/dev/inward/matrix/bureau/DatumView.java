/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau;

import dev.inward.matrix.*;

public class DatumView<D extends Datum<D,R,A,RESOURCE,M>,R extends DatumReference<D,R,A,RESOURCE,M>,A extends DatumAttributes<D,R,A,RESOURCE,M>,RESOURCE extends DatumResource<D,R,A,RESOURCE,M>,M extends DatumModel<D,R,A,RESOURCE,M>> extends View<D,R,A,RESOURCE,M> {

    public DatumView(String name, D d) {
        super(name, d);
    }
}

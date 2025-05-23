/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.ControlModel;
import dev.inward.matrix.control.ControlView;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class DatumLibrarian<D extends Datum<D,V,M,R,L>,V extends DatumView<D,V,M,R,L>,M extends DatumModel<D,V,M,R,L>,R extends DatumReference<D,V,M,R,L>,L extends DatumLibrarian<D,V,M,R,L,CL,CV,CM>,CL extends Control<CL,CV,CM>,CV extends ControlView<CL,CV,CM>,CM extends ControlModel<CL,CV,CM>> extends Librarian<D,V,M,R,L,CL,CV,CM> {

    public DatumLibrarian(Standard standard) {
        super(standard);
    }
}

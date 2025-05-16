/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.ControlModel;
import dev.inward.matrix.control.ControlView;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class FileLibrarian<F extends File<F,K,V,M,R,L>,K extends FileKey<F,K,V,M,R,L>,V extends FileView<F,K,V,M,R,L>,M extends FileModel<F,K,V,M,R,L>,R extends FileReference<F,K,V,M,R,L>,L extends FileLibrarian<F,K,V,M,R,L,CL,CV,CM>,CL extends Control<CL,CV,CM>,CV extends ControlView<CL,CV,CM>,CM extends ControlModel<CL,CV,CM>> extends DatumLibrarian<F,V,M,R,L,CL,CV,CM> {

    public FileLibrarian(Standard standard) {
        super(standard);
    }
}

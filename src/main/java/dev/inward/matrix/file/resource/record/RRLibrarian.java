/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.domain.DomainModel;
import dev.inward.matrix.control.domain.DomainView;
import dev.inward.matrix.file.FileLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class RRLibrarian<F extends ResourceRecord<F,K,V,M,R,L>,K extends RRKey<F,K,V,M,R,L>,V extends RRView<F,K,V,M,R,L>,M extends RRModel<F,K,V,M,R,L>,R extends RRReference<F,K,V,M,R,L>,L extends RRLibrarian<F,K,V,M,R,L>> extends FileLibrarian<F,K,V,M,R,L,Domain,DomainView,DomainModel> {

    public RRLibrarian(Standard standard) {
        super(standard);
    }
}

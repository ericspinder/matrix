/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.dns;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.concept.file.FileModel;

public class RRModel<F extends ResourceRecord<F,K,V,M,R,L>,K extends RRKey<F,K,V,M,R,L>,V extends RRView<F,K,V,M,R,L>,M extends RRModel<F,K,V,M,R,L>,R extends RRReference<F,K,V,M,R,L>,L extends RRLibrarian<F,K,V,M,R,L>> extends FileModel<F,K,V,M,R,L> {
    public RRModel(Class<F> resourceRecordClass, Aspect[] labeledAspects) {
        super(resourceRecordClass, labeledAspects);
    }
}

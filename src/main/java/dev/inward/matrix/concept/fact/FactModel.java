/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact;

import dev.inward.matrix.*;

public abstract class FactModel<F extends Fact<F,K,V,M,R,L,C>,K extends FactKey<F,K,V,M,R,L,C>,V extends FactView<F,K,V,M,R,L,C>,M extends FactModel<F,K,V,M,R,L,C>,R extends Cabin<F>,L extends Librarian<F,K,V,M,R,L,C>,C extends Context<F,V,M,L,C>> extends Model<F> {

    public FactModel(Class<F> fileClass, Aspect[] labeledAspects) {
        super(fileClass, labeledAspects);
    }

}

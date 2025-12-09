/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.concept.Concept;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.concept.fact.addressed.depot.specification.Specification;

public class Librarian<F extends Fact<F,K,V,M,R,L,X>,K extends FactKey<F,K,V,M,R,L,X>,V extends FactView<F,K,V,M,R,L,X>,M extends FactModel<F,K,V,M,R,L,X>,R extends Seat<F>,L extends Librarian<F,K,V,M,R,L,X>, X extends Context<F,V,M,L,X>> extends Concept<F,V,M> {

    protected final Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library;
    protected final Factory factory;

    public Librarian(Specification specification, Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library) {
        super(specification.getStandards()[0]);
        this.library = library;
        this.factory = new Factory(this);
        this.factory.installEngine(new Operational<DATUM, V, M, R, B>() {
        });

    }

    public Library<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> getLibrary() {
        return library;
    }
}

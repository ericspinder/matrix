/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact;

import dev.inward.matrix.concept.Concept;
import dev.inward.matrix.item.datum.standard.Standard;
import dev.inward.matrix.item.Clerk;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.item.datum.specification.Specification;
import dev.inward.matrix.engine.Factory;

import java.security.Permission;
import java.util.Enumeration;

public abstract class Librarian<F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> extends Concept<F,V,M,L,X> {

    protected final Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library;
    protected final Clerk<?,?,?,?,?>[] clerks;

    public Librarian(Specification specification, Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library, Operational<F,K,V,M,L,X> operational) {
        super(specification.getStandards()[0]);
        this.library = library;
        if (specification.getStandards().length > 1) {
            this.clerks = new Clerk[specification.getStandards().length - 1];
            for (int i = 1; i < specification.getStandards().length; i++) {
                Standard standard = specification.getStandards()[i];
                this.clerks[i - 1] = this.getClass().getClassLoader().loadClass(standard.getConceptClass());
            }
        }
        else {
            this.clerks = new Clerk[0];
        }
    }
    public abstract Factory<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> newFactory(Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library);

    public Library<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> getLibrary() {
        return library;
    }

    @Override
    public void add(Permission permission) {

    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return null;
    }
}

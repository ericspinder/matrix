/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.item.datum.administrator;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.concept.item.datum.Datum;

import java.security.Principal;

public abstract class Administrator<D extends Administrator<D,V,M,C>,V extends AdministratorView<D,V,M,C>,M extends AdministratorModel<D,V,M,C>,C extends AdministratorClerk<D,V,M,C>> implements Principal, Datum<D, V, M, C> {

    protected final String name;
    protected final Domain domain;
    public Administrator(Domain domain, String name) {
        this.domain = domain;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public Domain getDomain() {
        return domain;
    }
}

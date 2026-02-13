/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.item.materilized.administrator;

import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.item.datum.Datum;

import java.security.Principal;

public abstract class Materialized<A extends Materialized<A,V,M>,V extends MaterializedView<A,V,M>,M extends MaterializedModel<A,V,M>> implements Principal, Item<A,V,M,> {

    protected final Authority<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> authority;
    protected final String name;

    public Materialized(String name, Authority<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> authority) {
        this.name = name;
        this.authority = authority;
    }

    @Override
    public String getName() {
        return name;
    }

    public Authority<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> getAuthority() {
        return authority;
    }
}

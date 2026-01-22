/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item;

import dev.inward.matrix.concept.Concept;
import dev.inward.matrix.concept.fact.addressed.depot.standard.Standard;

import java.security.Permission;
import java.util.Enumeration;

public class Clerk<ITEM,V extends ItemView<ITEM,V,M,C,X>,M extends ItemModel<ITEM,V,M,C,X>,C extends Clerk<ITEM,V,M,C,X>,X extends ItemContext<ITEM,V,M,C,X>> extends Concept<ITEM,V,M,C,X> {

    public Clerk(Standard standard) {
        super(standard);
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

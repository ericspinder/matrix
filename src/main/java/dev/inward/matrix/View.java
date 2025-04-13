/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.nio.file.attribute.AttributeView;

public abstract class View<B extends Librarian<B,DATUM,V,M,R,S>,DATUM,V extends View<B,DATUM,V,M,R,S>,M extends Model<DATUM>,R extends Reference<B,DATUM,V,M,R,S>,S extends Steward<B,DATUM,V,M,R,S>> implements AttributeView {

    protected final String name;
    protected final DATUM datum;
    protected final R reference;

    public View(String name, DATUM datum, R reference) {
        this.name = name;
        this.datum = datum;
        this.reference = reference;
    }
    @Override
    public String name() {
        return null;
    }

    public DATUM getDatum() {
        return this.datum;
    }

    public R getReference() {
        return reference;
    }
}

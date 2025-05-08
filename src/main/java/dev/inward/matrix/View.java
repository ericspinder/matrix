/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.nio.file.attribute.AttributeView;

public abstract class View<DATUM,V extends View<DATUM,V,M>,M extends Model<DATUM>> implements AttributeView {

    protected final String name;
    protected final DATUM datum;

    public View(String name, DATUM datum) {
        this.name = name;
        this.datum = datum;
    }
    @Override
    public String name() {
        return null;
    }

    public DATUM getDatum() {
        return this.datum;
    }
    public abstract M getModel();


}

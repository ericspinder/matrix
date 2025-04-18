/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.lang.ref.WeakReference;
import java.util.Map;

public class Reference<DATUM,V extends View<DATUM,V,M,R,B>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,B>,B extends Librarian<DATUM,V,M,R,B>> extends WeakReference<DATUM> {


    protected final Long sequence;
    protected final Map<String, Model.InstanceValue<?>> attributes;
    protected final B librarian;

    public Reference(DATUM referent, B librarian) {
        super(referent, librarian);
        this.librarian = librarian;
        this.sequence = librarian.incrementAndGet();
        this.attributes = librarian.getModel().getInitialProperties(referent);
    }

    public B getLibrarian() {
        return librarian;
    }

    public boolean release() {
        if (isHeld()) {
            this.attributes.remove("held");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isHeld() {
        return this.attributes.get("held") != null;
    }

    public Map<String, Model.InstanceValue<?>> getAttributes() {
        return attributes;
    }

    public Long getSequence() {
        return sequence;
    }

}

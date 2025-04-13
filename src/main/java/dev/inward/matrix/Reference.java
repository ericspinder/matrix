/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.lang.ref.WeakReference;
import java.util.Map;

public class Reference<B extends Librarian<B,DATUM,V,M,R, T>,DATUM,V extends View<B,DATUM,V,M,R, T>,M extends Model<DATUM>,R extends Reference<B,DATUM,V,M,R, T>, T extends Steward<B,DATUM,V,M,R, T>> extends WeakReference<DATUM> {

    protected final Long sequence;
    protected final Map<String, Model.InstanceValue<?>> attributes;
    protected final T steward;

    public Reference(DATUM referent, T steward) {
        super(referent, steward);
        this.steward = steward;
        this.sequence = steward.incrementAndGet();
        this.attributes = steward.getModel().getInitialProperties(referent);
    }

    public T getSteward() {
        return steward;
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

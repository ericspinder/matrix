/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.lang.ref.WeakReference;
import java.nio.file.Path;

public class Reference<DATUM,R extends Reference<DATUM,R,A,RESOURCE,M>,A extends Attributes<DATUM,R,A,RESOURCE,M>,RESOURCE extends Resource<DATUM,R,A,RESOURCE,M>,M extends Model<DATUM,R,A,RESOURCE,M>> extends WeakReference<DATUM> {

    protected final RESOURCE resource;
    protected final Long sequence;
    protected final A attributes;

    public Reference(DATUM referent, RESOURCE resource) {
        super(referent, resource);
        this.resource = resource;
        this.sequence = resource.incrementAndGet();
        this.attributes = resource.createAttributes(referent);
    }


    public boolean release() {
        if (isHeld()) {
            this.attributes.properties.remove("held");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isHeld() {
        return this.attributes.properties.get("held") != null;
    }
}

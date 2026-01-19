/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact;

import dev.inward.matrix.Shadow;

public interface Cabin<F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> extends Shadow<F,V,M> {

    /**
     *
     * @return False it was not being held. True if it was being held. Either way the property is removed, however the
     */
    default boolean releaseForGarbageCollection() {
        if (isHeld()) {
            this.getAttributes().remove("held");
            return true;
        }
        else {
            return false;
        }
    }

    default boolean isHeld() {
        return this.getAttributes().get("held") != null;
    }

    @SuppressWarnings("unchecked")
    default L getLibrarian() {
        return (L) this.getAttributes().get("librarian").getValue();
    }
}

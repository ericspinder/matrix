/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.fact.Fact;
import dev.inward.matrix.concept.fact.FactKey;
import dev.inward.matrix.route.Ticket;

import java.util.Collections;
import java.util.Map;

public interface Seat<TARGET> {

    default Map<String, Ticket<?>> getAttributes() {
        return Collections.emptyMap();
    }
    default long getSequence() {
        return 0;
    };

    default FactKey<?,?,?,?,?,?,?> getKey() {
        TARGET target = this.get();
        if(target != null) {
            if(target instanceof Fact<?,?,?,?,?,?,?>) {
                return ((Fact<?,?,?,?,?,?,?>) target).getKey();
            }
        }
        return (FactKey<?,?,?,?,?,?,?>)(this.getAttributes().get("parent")).getValue();
    }
    TARGET get();

}

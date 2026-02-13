/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.fact.Fact;
import dev.inward.matrix.concept.fact.FactKey;
import dev.inward.matrix.predictable.Complication;
import dev.inward.matrix.route.Road;
import dev.inward.matrix.route.Ticket;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.nio.file.attribute.AttributeView;
import java.util.Collections;
import java.util.Map;

public interface Shadow<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>> extends AttributeView, Comparable<Shadow<TARGET,V,M>> {

    default Map<String, Ticket<?>> getAttributes() {
        return Collections.emptyMap();
    }
    default long getSequence() {
        return 0;
    };

    @SuppressWarnings("unchecked")
    default FactKey<?,?,?,?,?,?> getKey() {
        TARGET target = this.get();
        if(target != null) {
            if(target instanceof Fact<?,?,?,?,?,?>) {
                return ((Fact<?,?,?,?,?,?>) target).getKey();
            }
        }
        Ticket<FactKey<?,?,?,?,?,?>> ticket = (Ticket<FactKey<?,?,?,?,?,?>>) this.getAttributes().get("context");
        if (ticket != null) {
            return ticket.getValue();
        }
        return null;
    }
    TARGET get();
}

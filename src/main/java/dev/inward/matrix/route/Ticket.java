/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import dev.inward.matrix.concept.fact.addressed.log.Log;

public abstract class Ticket<V> {

    protected final Log initLog;
    
    protected final V value;

    public Ticket(Log initLog, V value) {
        this.initLog = initLog;
        this.value = value;
    }

    public static class Immutable<V> extends Ticket<V> {

        Immutable(Log initLog, V value) {
            super(initLog, value);
        }
    }

    public static class Published<S extends Seat<S>> extends Ticket<S> {

        Published(S seat) {
            super(seat);
        }
    }


}

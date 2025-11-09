/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

public abstract class Ticket<V> {

    
    protected final V value;

    public Ticket(V value) {
        this.value = value;
    }

    public static class Immutable<V> extends Ticket<V> {

        Immutable(V value) {
            super(value);
        }
    }

    public static class Published<S extends Seat<S>> extends Ticket<S> {

        Published(S seat) {
            super(seat);
        }
    }


}

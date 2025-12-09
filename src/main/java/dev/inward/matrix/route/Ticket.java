/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import dev.inward.matrix.concept.fact.addressed.log.Log;
import dev.inward.matrix.concept.item.datum.administrator.Persona;

import java.util.UUID;

public abstract class Ticket<V> {

    protected final Log initLog;

    protected final UUID uuid = UUID.randomUUID();

    public Ticket(Log initLog) {
        this.initLog = initLog;
    }

    public static class Simple<V> extends Ticket<V> {

        private final V value;

        Simple(Log log, V value) {
            super(log);
            this.value = value;
        }
        public V getValue() {
            return value;
        }
    }
    public static class Containerized<V> extends Ticket<V> {

        protected final Container<V> container;
        protected Containerized(Log initLog, Container<V> container) {
            super(initLog);
            this.container = container;
        }

        @Override
        public V getValue() {
            return container.getValue();
        }

        public Container<V> getContainer(Persona persona) {
            return container.authorize(persona) ? container : null;
        }
    }

    public Log getInitLog() {
        return initLog;
    }
    public abstract V getValue();
    public final UUID getUuid() {
        return uuid;
    }
}

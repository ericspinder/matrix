/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import dev.inward.matrix.control.administrator.Persona;
import dev.inward.matrix.predictable.Complication;

import java.lang.ref.SoftReference;

public abstract class Container<V> {

    public static class Secure<V> extends Container<V> {

        private final SoftReference<Complication<V>> complicationSoftReference;

        public Secure(SoftReference<Complication<V>> complicationSoftReference) {
            this.complicationSoftReference = complicationSoftReference;
        }

        @Override
        public boolean authorize(Persona persona) {
            Complication<V> complication = complicationSoftReference.get();
            if (complication == null) return true;
            complication.authorize(persona);
        }
    }
    public static class Insecure<V> extends Container<V> {

        @Override
        public boolean authorize(Persona persona) {
            return true;
        }
    }

    private V value;

    public Container(V value) {
        this.value = value;
    }
    public Container() {
        this(null);
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public boolean authorize(Persona persona) {
        return false;
    }
}

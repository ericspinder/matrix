/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.Driver;

import java.util.Map;

public interface Bus {

    /**
     *
     * @return False is not being held already. True if it was being held.
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



    Map<String, Bus.Route<?>> getAttributes();

    class Route<V> implements Meta_I {

        protected final V value;

        public Route(V value) {
            this.value = value;
        }

        @Override
        public String getLabel() {
            return "public";
        }

        @Override
        public String getDescription() {
            return "not specifically attached to security, rights determined up level";
        }

        public static class Published<V> extends Route<V> {

            protected final String label;
            protected final String description;

            Published(V value, String label, String description) {
                super(value);
                this.label = label;
                this.description = description;
            }

            @Override
            public String getLabel() {
                return label;
            }

            @Override
            public String getDescription() {
                return description;
            }

            public static class Driven<V> extends Published<V> {

                protected final Dispatch dispatch;

                Driven(V value, String label, String description, Dispatch dispatch) {
                    super(value, label, description);
                    this.dispatch = dispatch;
                }

                public Dispatch getDispatch() {
                    return dispatch;
                }
            }
        }
    }
}

package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.datum.Ware;

import java.util.*;

public class Bus<DATUM, R extends Ware<DATUM, R,P,ID,T,C,?>,P extends Pathway<P,?>,ID extends Comparable<ID>,T extends Concept.Tangible<P,ID,T,C,?>,C extends Concept<P,ID,T,C,?>> {

//        E envoy = new Envoy<DATUM>(passenger,((Context)passenger.getClass().getProtectionDomain()).getLibrary().getCatalog().register(passenger);
        public enum Schedule implements Meta_I {
                Timed("Timed",""),
                Reload("Reload","When the datum is reloaded, before determining duplicate or update"),
                ReloadChange("ReloadChange","When the datum reload has a change"),
                NoChangeReload("NoChangeReload", "When datum is reloaded without any changes"),
                Write("Write","On creation or update of the datum"),
                Creation("Creation","On creation of datum"),
                Updated("Updated","When datum is updated"),
                SoftDelete("SoftDelete","Reference Queue returned datum"),
                Delete("Delete","When the datum is permanently deleted"),
                ;
                final String label;
                final String description;
                Schedule(String label,String description) {
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
        }
        protected final UUID uuid = UUID.randomUUID();
        protected final Deque<R> deque;
        protected final Context<P,ID,T,C,?> context;

        public Bus(Deque<R> deque, Context<P,ID,T,C,?> context) {
                this.deque = deque;
                this.context = context;
        }

        public Deque<R> getDeque() {
                return this.deque;
        }


        public final void register(R representative) {

        }
}



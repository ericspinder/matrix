package com.notionds.dataSupplier.advisor;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.datum.sanction.Sanction;
import com.notionds.dataSupplier.maker.Engagement;
import com.notionds.dataSupplier.meta.Meta_I;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Matter<D extends Datum<D,O,C,I>,O extends Operational<D,O>, C extends Container<D,O,C,I,?>,I extends Id<D,I>, S extends Sanction<D,O,C,I,?>, M extends Matter<D,O,C,I,S,M>> implements Comparable<M>, Serializable {

    private final String name;
    private final S sanction;
    private final Footing footing;
    private final Locus locus;

    public Matter(String name, S sanction, Footing footing, Locus locus) {
        this.name = name;
        this.sanction = sanction;
        this.footing = footing;
        this.locus = locus;

    }
    public enum Focus implements Meta_I<Focus> {
        Initialization("Initialization", "initialization"),
        Wrap("Wrap", "Matter is focused on the initialization of the Datum with the container"),
        Operational("Operation", "An operational matter"),
        Cleanup("Cleanup", "On cleanup, during garbage collection"),
        Shutdown("Shutdown", "On shutdown"),
        ;
        private final String label;
        private final String description;
        Focus(String label, String description) {
            this.label = label;
            this.description = description;
        }
        @Override
        public String getLabel() {
            return this.label;
        }
        @Override
        public String getDescription() {
            return this.description;
        }

    }

    public enum Footing implements Meta_I<Footing> {
        Changing("Changing","change is afoot for the locus"),
        Deleting("Deleting", "locus was deleted"),
        Monitory("Monitory", "Locus is providing information on a monitory matter, generally a regularly emitted item for observation and may indicate an adverse state"),
        Admonitory("Admonitory", "Locus is an admonitory matter, while not necessarily critical these indicate an adverse state"),
        Integral("Integral", "Locus is an integral matter"),
        ;
        private final String label;
        private final String description;
        Footing(final String label, final String description) {
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
    public enum Locus implements Meta_I<Locus> {
        Id("Id", "the datum's Id"),
        Container("Container","the datum's Container"),
        Datum("Datum","the Datum, Notion or Fact"),
        Notion("Notion","A Notion or Fact"),
        Fact("Fact", "A Fact"),
        Factory("Factory","The factory"),
        Chronicle("Chronicle","The Chronicle"),
        //Platform("Platform Issue",""),
        System("System","An unexpected occurrence"),
        ;
        private final String label;
        private final String description;
        Locus(final String label, final String description) {
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

    public enum State {
        Updating("Updating, this is a locked state"),
        Open("Open, normal operations encouraged"),
        Closed("Closed"),
        Empty("Empty,  expected to be garbage collected, do not hold or create new reference as that will interfere with expected operations")
        ;
        final String description;
        State(String description) {
            this.description = description;
        }
    }
}

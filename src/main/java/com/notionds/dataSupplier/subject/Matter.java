package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.container.Phase;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.meta.Meta_I;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public final class Matter<D extends Datum<?,D,?,?,I>,I extends Id<?,I,?>,EVT extends Subject<D,I,EVT>> implements Comparable<Matter<D,I,EVT>>, Serializable {

    private final String name;
    private final Focus focus;
    private final Locus locus;
    private final Phase phase;
    private final Class<D> dClass;

    public Matter(String name, Focus focus, Locus locus, Phase phase) {
        this.name = name;
        this.focus = focus;
        this.locus = locus;
        this.phase = phase;
        this.dClass = (Class<D>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    public enum Focus implements Meta_I<Focus,Focus> {
        Change("Change","change is afoot for the locus"),
        Deleting("Deleting", "locus was deleted"),
        Monitory("Monitory", "Locus is providing information on a monitory matter, generally a regularly emitted item for observation and may indicate an adverse state"),
        Admonitory("Admonitory", "Locus is an admonitory matter, while not necessarily critical these indicate an adverse state"),
        Integral("Integral", "Locus is an integral matter"),
        ;
        private final String label;
        private final String description;
        Focus(final String label, final String description) {
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
    public enum Locus implements Meta_I<Locus,Locus> {
        Phase("Phase","Phase Change issue"),
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

    public String getName() {
        return name;
    }

    public Focus getFocus() {
        return focus;
    }

    public Locus getLocus() {
        return locus;
    }

    public Phase getPhase() {
        return phase;
    }
    @Override
    public int compareTo(Matter<D,I,EVT> that) {
        if (this.locus.equals(that.getLocus())) {
            if(this.focus.equals(that.getFocus())) {
                if(this.phase.equals(that.getPhase())) {
                    if(this.name.equals(that.getName())) {
                        return 0;
                    }
                    return this.name.compareTo(that.getName());
                }
                return this.phase.compareTo(that.getPhase());
            }
            return this.focus.compareTo(that.getFocus());
        }
        return this.locus.compareTo(that.getLocus());
    }
}

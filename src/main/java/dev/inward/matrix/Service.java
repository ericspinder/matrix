package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.datum.Complication;

public class Service<PATH extends Comparable<PATH>,X extends Context<PATH,X,ID,I,C,R>,ID extends Comparable<ID>,I extends Concept.Identity<PATH,X,ID,I,C,R>,C extends Concept<PATH,X,ID,I,C,R>,R extends Representitive<PATH,X,ID,I,C,R>,CRIT extends Criterion,PRE extends Predictable<PATH,X,ID,I,C,R,CRIT,PRE,COMP,M,OCCURRENCE>,COMP extends Complication<PATH,X,ID,I,C,R,CRIT,PRE,COMP,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> implements Comparable<Service<PATH,X,ID,I,C,R,CRIT,PRE,COMP,M,OCCURRENCE>> {

    protected final String name;
    protected COMP complication;

    public Service(String name, COMP complication) {
        this.name = name;
        this.complication = complication;
    }

    public COMP getComplication() {
        return complication;
    }

    public void setComplication(COMP complication) {
        this.complication = complication;
    }

    @Override
    public int compareTo(Service<PATH,X,ID,I,C,R,CRIT,PRE,COMP,M,OCCURRENCE> that) {
        return this.name.compareTo(that.name);
    }
}

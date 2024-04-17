package dev.inward.matrix.ticket;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.concept.matter.messaging.Engagement;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Criterion;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.session.Session;
import dev.inward.matrix.resources.Resource;

public abstract class Ticket<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CRIT extends Criterion,P extends Predictable<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>,COMP extends Complication<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>,M extends Matter<S,L,M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> implements Comparable<Ticket<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>> {

    protected final Session<S,L> session;
    public Ticket(Session<S,L> session) {
        this.session = session;
    }

    public Session<S, L> getSession() {
        return session;
    }
}

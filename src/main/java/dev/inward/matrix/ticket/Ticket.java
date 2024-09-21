package dev.inward.matrix.ticket;

import dev.inward.matrix.Library;
import dev.inward.matrix.Pathway;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.session.Session;

public abstract class Ticket<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>> implements Comparable<Ticket<PATH,P,ID,T,C>> {

    protected final Session session;
    public Ticket(Session<S,L> session) {
        this.session = session;
    }

    public Session<S, L> getSession() {
        return session;
    }
}

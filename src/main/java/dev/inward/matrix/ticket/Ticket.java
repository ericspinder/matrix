package dev.inward.matrix.ticket;

import dev.inward.matrix.*;
import dev.inward.matrix.Concept;
import dev.inward.crud.Session;

public abstract class Ticket<PATH extends Comparable<PATH>,D extends Index<PATH,D>,ID extends Comparable<ID>,T extends Concept.Identity<PATH,D,ID,T,C,R>,C extends Concept<PATH,D,ID,T,C,R>,R extends Representative<PATH,D,ID,T,C,R>> implements Comparable<Ticket<PATH,D,ID,T,C,R>> {

    protected final Session session;
    public Ticket(Session<S,L> session) {
        this.session = session;
    }

    public Session<S, L> getSession() {
        return session;
    }
}

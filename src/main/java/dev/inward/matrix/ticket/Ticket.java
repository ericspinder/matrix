/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.ticket;

import dev.inward.crud.Session;
import dev.inward.matrix.file.Directory;
import dev.inward.matrix.file.addressed.AddressedReference;
import dev.inward.matrix.operation.Concept;

public abstract class Ticket<PATH extends Comparable<PATH>,D extends Directory<PATH,D>,ID extends Comparable<ID>,T extends Concept.Identity<PATH,D,ID,T,C,R>,C extends Concept<PATH,D,ID,T,C,R>,R extends AddressedReference<PATH,D,ID,T,C,R>> implements Comparable<Ticket<PATH,D,ID,T,C,R>> {

    protected final Session session;
    public Ticket(Session<S,L> session) {
        this.session = session;
    }

    public Session<S, L> getSession() {
        return session;
    }
}

package dev.inward.matrix.datum.fact.session;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Guest extends Progenitor<SessionFactory,Session,Keeper, Identity.Ego<Context.Service>,Context.Service,Huddle,Guest> {

    public Guest(Session fact, ReferenceQueue<Session> referenceQueue, Huddle bus, Keeper operational) {
        super(fact, referenceQueue, bus, operational);
    }
}

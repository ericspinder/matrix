package dev.inward.matrix.fact.session;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Guest extends Model<SessionFactory,Session,Keeper, Identity.Ego<Context.Service>,Context.Service,Huddle,Guest> {

    public Guest(Session fact, ReferenceQueue<Session> referenceQueue, Huddle bus, Keeper operational) {
        super(fact, referenceQueue, bus, operational);
    }
}

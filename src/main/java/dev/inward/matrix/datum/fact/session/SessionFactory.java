package dev.inward.matrix.datum.fact.session;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class SessionFactory extends Factory<SessionFactory,Session,Keeper, Identity.Ego<Context.Service>,Context.Service,Huddle,Guest> {
    public SessionFactory(Diplomat diplomat, LinkedBlockingDeque<Keeper> operationalDeque, Map<Class<?>, List<Predictor<SessionFactory, ?, Session, Keeper, Identity.Ego<Context.Service>, Context.Service, Huddle, Guest, ?, ?, ?>>> predictorMap) {
        super(diplomat, operationalDeque, predictorMap);
    }

    @Override
    public int compareTo(SessionFactory o) {
        return 0;
    }
}

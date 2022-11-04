package dev.inward.matrix.datum.fact.session;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Model;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import crud.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class SessionFactory extends Factory<SessionFactory,Session,Keeper, Identity.Ego<Context.Service>,Context.Service,Huddle,Guest> {
    public SessionFactory(Model model, LinkedBlockingDeque<Keeper> operationalDeque, Map<Class<?>, List<Predictor<SessionFactory, ?, Session, Keeper, Identity.Ego<Context.Service>, Context.Service, Huddle, Guest, ?, ?, ?>>> predictorMap) {
        super(model, operationalDeque, predictorMap);
    }

    @Override
    public int compareTo(SessionFactory o) {
        return 0;
    }
}

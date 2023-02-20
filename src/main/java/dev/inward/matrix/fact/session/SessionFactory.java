package dev.inward.matrix.fact.session;

import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class SessionFactory extends Factory<SessionFactory,Session,Keeper, Identity.Ego<Context.Path>, Context.Path,Huddle,Guest> {
    public SessionFactory(Model model, LinkedBlockingDeque<Keeper> operationalDeque, Map<Class<?>, List<Predictable<SessionFactory, ?, Session, Keeper, Identity.Ego<Context.Path>, Context.Path, Huddle, Guest, ?, ?, ?>>> predictorMap) {
        super(model, operationalDeque, predictorMap);
    }

    @Override
    public int compareTo(SessionFactory o) {
        return 0;
    }
}

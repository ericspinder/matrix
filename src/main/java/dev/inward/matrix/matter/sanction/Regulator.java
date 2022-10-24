package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Regulator<ID extends Identity.Id<ID,P>,P extends Context.Platform<P>> extends Fact<Regulator<ID,P>, Identity.SuperEgo, Context.Service,Regulated<ID,P>,ID,P> {

    protected Aegis aegis;

    public Regulator(Identity.SuperEgo id) {
        super(id);
    }
}

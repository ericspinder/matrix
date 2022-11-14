package dev.inward.matrix.fact.matter.sanction;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.notion.concept.Context;

public class Regulator extends Fact<Regulator, Identity.SuperEgo,Context.Service> {

    protected Aegis aegis;

    public Regulator(Identity.SuperEgo id) {
        super(id);
    }
}

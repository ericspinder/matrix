package dev.inward.matrix.datum.fact.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Regulator extends Fact<Regulator, Identity.SuperEgo,Context.Service> {

    protected Aegis aegis;

    public Regulator(Identity.SuperEgo id) {
        super(id);
    }
}

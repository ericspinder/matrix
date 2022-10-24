package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.resources.Storage;

public class Governance<ID extends Identity.Id<ID,P>,P extends Context.Platform<P>> extends Factory<Governance<ID,P>,Regulator<ID,P>,Bureaucracy<ID,P>, Identity.SuperEgo,Context.Service,RedTape<ID,P>,Regulated<ID,P>,ID,P,> {
    public Governance(Storage<Governance<I, X, IC, XC>, Regulator<I, X, IC, XC>, Bureaucracy<I, X, IC, XC>, I, X, RedTape<I, X, IC, XC>, Regulated<I, X, IC, XC>, IC, XC> storage) {
        super(storage);
    }
}

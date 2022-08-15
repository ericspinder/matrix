package dev.inward.matrix.maker.issuer;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.authority.Authority;
import dev.inward.matrix.datum.fact.notion.authority.Judge;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Imprint<I extends Identity<I,X>,X extends Context<X>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Representative<Issuer<I,X>,I,X, Judge<I,X,IC,XC>,IC,XC> {
    public Imprint(Imprint<I,X,IC,XC> fact, ReferenceQueue referenceQueue, Identity containerId) {
        super(fact, referenceQueue, containerId);
    }
}

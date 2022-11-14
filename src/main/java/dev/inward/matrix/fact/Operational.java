package dev.inward.matrix.fact;

import dev.inward.matrix.fact.datum.Identity;

import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.matter.report.Report;
import dev.inward.matrix.phenomenon.Tolerances;
import dev.inward.matrix.phenomenon.producer.settlement.Settlement;
import dev.inward.matrix.engine.Zone;

public abstract class Operational<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,O extends Operational<F,I,X,O,M,T>,M extends Matter<M,I,X>,T extends Tolerances<M,T>> {

    protected final Specification<F,I,X> specification;

    public Operational(Zone zone, Specification<F,I,X> specification) {
        this.specification = specification;
    }

    public Specification<F,I,X> specification() {
        return this.specification;
    }

    public Settlement settle(Matter<?,I,X> matter) {
        Server[] servers = this.specification.indiciaServerMap.get(matter.getIndica());
        return null;
    }

}

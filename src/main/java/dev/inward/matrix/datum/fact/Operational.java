package dev.inward.matrix.datum.fact;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.datum.Identity;

import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.engine.Induction;
import dev.inward.matrix.datum.fact.matter.Indicia;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.datum.fact.matter.report.Report;
import dev.inward.matrix.phenomenon.Tolerances;
import dev.inward.matrix.phenomenon.producer.settlement.Settlement;
import dev.inward.matrix.resources.Supplier;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.datum.Standard;

import java.lang.reflect.InvocationTargetException;

public abstract class Operational<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,O extends Operational<F,I,X,O,N,NI,NX,M,T>,N extends Notion<N,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>,M extends Matter<M,I,X>,T extends Tolerances<M,T>> {

    protected final Specification<F,I,X> specification;

    public Operational(Zone zone, Specification<F,I,X> specification) {
        this.specification = specification;
    }

    public Specification<F,I,X> specification() {
        return this.specification;
    }

    public Settlement settle(Matter<?,I,X> matter) {
        Server[] servers = this.specification.indiciaServerMap.get(matter.getIndica());

    }

    public void report(Report<NI, NX> report) {
        Server[] servers = this.specification.indiciaServerMap.get(report.getIndica());

    }
}
